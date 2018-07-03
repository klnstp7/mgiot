package com.migen.myiot.netty;

import com.migen.myiot.rabbitmq.RabbitService;
import com.migen.myiot.service.DealMessageService;
import com.migen.myiot.service.DeviceService;
import com.migen.myiot.utils.BytesUtil;
import com.migen.myiot.utils.LogUtil;
import com.migen.myiot.entity.Device;
import com.migen.myiot.enums.Constants;
import com.migen.myiot.enums.DtuCommand;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.Attribute;
import io.netty.util.ReferenceCountUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.migen.myiot.enums.Constants.HM_QUENEN_DEVICE;

/**
 * Created by Administrator on 2018/5/31.
 */
public class NettyServerInHandler extends ChannelInboundHandlerAdapter {

    private int lossConnectCount;

    /**
     * 连接
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        LogUtil.info(ctx.channel().toString());
    }

    /**
     * 读取数据
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object message) throws Exception {
        lossConnectCount=0;
        Attribute<ChannelSession> attribute = ((SocketChannel)ctx.channel()).attr(Constants.ATTRIBUTEKEY);
        ChannelSession session=attribute.get();
        boolean isInit=false;
        try
        {
            ByteBuf buffer=(ByteBuf) message;
            byte[] bytes = new byte[buffer.readableBytes()];
            buffer.readBytes(bytes);
            char start=(char)bytes[0];
            boolean isDealed=false;
            String result=null;

            if(start=='+'){//DTU-非数字
                StringBuffer sb = new StringBuffer(bytes.length);
                for (int i = 0; i < bytes.length; ++ i) {
                    if (bytes[i] < 0) throw new IllegalArgumentException();
                    sb.append((char) bytes[i]);
                }
                result=sb.toString().replace("\r\n","");
            }else{
                result= BytesUtil.byteTo16String(bytes);
            }

            if(!(result.equalsIgnoreCase(Constants.CAR_RETRUN_LINE_HEX) || result.equalsIgnoreCase(DtuCommand.REC_HEARTBEAT))){
                LogUtil.info("client str: " + result);
            }

            //注册
            if(result.startsWith(DtuCommand.REC_SERIAL_NUM)) {
                String moduleId = null;
                String reg = "\\d{12}";
                Pattern pattern = Pattern.compile(reg);
                Matcher matcher = pattern.matcher(result);
                if (matcher.find()) {
                    moduleId = matcher.group();
                }
                Device device= DeviceService.getDeviceByModuleId(moduleId);
                int did= DealMessageService.dealSerialNum(moduleId, device,(SocketChannel) ctx.channel());
                if(session==null) {
                    session = new ChannelSession();
                    session.setDid(did);
                    attribute.setIfAbsent(session);
                }
                isInit=true;
                isDealed=true;
            }else if(result.startsWith(DtuCommand.REC_POSITION)){//定位
                session.setOperateType(Constants.OUTER_LOCATION);
            }else if(result.startsWith(DtuCommand.REC_UPDATE_VERSION)){//更新智盒版本
                isDealed=true;
            }else if(result.startsWith(DtuCommand.REC_CMD_STATE)){//在线状态
                isDealed=true;
            }else if(result.startsWith(DtuCommand.REC_CMD_HEARTBEAT)){//心跳命令
                isDealed=true;
            }else if(result.equalsIgnoreCase(DtuCommand.REC_HEARTBEAT)){//心跳
                isDealed=true;
            }else if(result.startsWith(DtuCommand.REC_CMD_GPRS)){//主连接类型,地址和端口配置
                isDealed=true;
            }else if(result.equalsIgnoreCase(Constants.CAR_RETRUN_LINE_HEX)) {//回车换行
                isDealed=true;
            }
            //Modbus命令
            if(!isDealed){
                session.setData(result);
                RabbitService.sendNettyMesssage(session);
                isDealed=true;
            }

        }catch (Exception ex){
            ex.printStackTrace();
            LogUtil.error("bussiness dealed error,message:"+ex.getMessage());
        }finally {
            HM_QUENEN_DEVICE.put(session.getDid(),false);
            ReferenceCountUtil.release(message);
            if(isInit) {
                NettyInitThread initThread = new NettyInitThread(session.getDid());
                initThread.run();
            }
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        LogUtil.info(ctx.channel().toString()+" inactive");
        Attribute<ChannelSession> attribute = ((SocketChannel)ctx.channel()).attr(Constants.ATTRIBUTEKEY);
        ChannelSession session=attribute.get();
        DealMessageService.inactiveSocket(session.getDid(),(SocketChannel)ctx.channel());
    }

    /**
     * 报错 处理事件
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LogUtil.error("socket dealed error,message:"+cause.getMessage());
    }


    /**
     * 检查连接状态
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent)evt;
            if (event.state()== IdleState.READER_IDLE){
                lossConnectCount++;
                if(lossConnectCount>3){
                    LogUtil.info("heart beat auto close,socket "+ctx.channel().toString());
                    ctx.channel().close();
                }
            } else if (event.state().equals(IdleState.WRITER_IDLE)) {

            } else if (event.state().equals(IdleState.ALL_IDLE)) {

            }
        }else {
            super.userEventTriggered(ctx,evt);
        }
    }
}
