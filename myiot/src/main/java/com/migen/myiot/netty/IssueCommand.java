package com.migen.myiot.netty;

import com.migen.myiot.entity.Device;
import com.migen.myiot.entity.Issue;
import com.migen.myiot.enums.Constants;
import com.migen.myiot.modbus.ModbusUtils;
import com.migen.myiot.service.CommandService;
import com.migen.myiot.service.DeviceService;
import com.migen.myiot.utils.BytesUtil;
import com.migen.myiot.utils.LogUtil;
import com.migen.myiot.entity.Command;
import com.migen.myiot.enums.DtuCommand;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.Attribute;
import org.apache.commons.lang.ArrayUtils;

import java.util.Map;

public class IssueCommand
{

	/**
	 * 锁定机器
	 * @param issue
	 * @return
	 */
	public  static  String issueLock(Issue issue){
		String rt = Constants.FAIL;
		try {
			Map<Integer, SocketChannel> hs = Constants.HM_SOCKET;
			if (null != hs && !"".equals(hs) && hs.size() > 0)
			{
				SocketChannel skt = hs.get(issue.getDid());
				if (null != skt && skt.isActive())
				{
					SetSocketSessionIssue(Constants.OUTER_LOCK,issue,skt);
					Command cmd= CommandService.getCmdByCode(Constants.OUTER_LOCK);
					cmd.setDataSegment(BytesUtil.shortToByte((short)1));
					if(cmd!=null){
						byte[] send = ModbusUtils.cmdToBytes(cmd);
						writeSocket(send,skt);
					}
				}
			}
			rt = Constants.SUC;
		}catch (Exception ex){
			LogUtil.error(ex.getMessage());
		}
		return rt;
	}

	/**
	 * 解除锁定
	 * @param issue
	 * @return
	 */
	public  static  String issueUnLock(Issue issue){
		String rt = Constants.FAIL;
		try {
			Map<Integer, SocketChannel> hs = Constants.HM_SOCKET;
			if (null != hs && !"".equals(hs) && hs.size() > 0)
			{
				SocketChannel skt = hs.get(issue.getDid());
				if (null != skt && skt.isActive())
				{
					SetSocketSessionIssue(Constants.OUTER_UNLOCK,issue,skt);
					Command cmd= CommandService.getCmdByCode(Constants.OUTER_UNLOCK);
					cmd.setDataSegment(BytesUtil.shortToByte((short)0));
					if(cmd!=null){
						byte[] send = ModbusUtils.cmdToBytes(cmd);
						writeSocket(send,skt);
						DeviceService.updateStatus(issue.getDid(),Constants.DEVICE_UNLOCKING);
					}
				}
			}
			rt = Constants.SUC;
		}catch (Exception ex){
			LogUtil.error(ex.getMessage());
		}
		return rt;
	}

	/**
	 * 发送定位命令
	 * @param issue
	 * @return
	 */
	public static String issuePosition(Issue issue)
	{
		String rt = Constants.FAIL;
		try {
			Map<Integer, SocketChannel> hs = Constants.HM_SOCKET;
			if (null != hs && !"".equals(hs) && hs.size() > 0)
			{
				SocketChannel skt = hs.get(issue.getDid());
				if (null != skt && skt.isActive())
				{
					SetSocketSessionIssue(Constants.OUTER_LOCATION,issue,skt);
					byte[] send=DtuCommand.SEND_POSITION.getBytes();
					writeSocket(send,skt);
					rt = Constants.SUC;
				}
			}
			rt = Constants.SUC;
		}catch (Exception ex){
			LogUtil.error(ex.getMessage());
		}
		return rt;
	}

	/**
	 * 预设产量
	 * @param issue
	 * @return
	 */
    public  static  String issueInstallYield(Issue issue){
		String rt = Constants.FAIL;
		try {
			Map<Integer, SocketChannel> hs = Constants.HM_SOCKET;
			if (null != hs && !"".equals(hs) && hs.size() > 0)
			{
				SocketChannel skt = hs.get(issue.getDid());
				if (null != skt && skt.isActive())
				{
					SetSocketSessionIssue(Constants.OUTER_INSTALL_YIELD,issue,skt);
					Command cmd= CommandService.getCmdByCode(Constants.OUTER_INSTALL_YIELD);
					cmd.setDataSegment(BytesUtil.shortToByte((short)2));
					if(cmd!=null){
						byte[] send = ModbusUtils.cmdToBytes(cmd);
						writeSocket(send,skt);
					}
				}
			}
			rt = Constants.SUC;
		}catch (Exception ex){
			LogUtil.error(ex.getMessage());
		}
		return rt;
	}

	/**
	 * 产量计数
	 * @param issue
	 * @return
	 */
	public  static  String issueRealYield(Issue issue){
		String rt = Constants.FAIL;
		try {
			Map<Integer, SocketChannel> hs = Constants.HM_SOCKET;
			if (null != hs && !"".equals(hs) && hs.size() > 0)
			{
				SocketChannel skt = hs.get(issue.getDid());
				if (null != skt && skt.isActive())
				{

					SetSocketSessionIssue(Constants.OUTER_REAL_YIELD,issue,skt);
					Command cmd= CommandService.getCmdByCode(Constants.OUTER_REAL_YIELD);
					cmd.setDataSegment(BytesUtil.shortToByte((short)2));
					if(cmd!=null){
						byte[] send = ModbusUtils.cmdToBytes(cmd);
						writeSocket(send,skt);
					}
				}
			}
			rt = Constants.SUC;
		}catch (Exception ex){
			LogUtil.error(ex.getMessage());
		}
		return rt;
	}

	/**
	 * 发送升级版本命令
	 * @param issue
	 * @return
	 */
	public static String issueUpdateVer(Issue issue)
	{
		String rt = Constants.FAIL;
		try {
			Map<Integer, SocketChannel> hs = Constants.HM_SOCKET;
			if (null != hs && !"".equals(hs) && hs.size() > 0)
			{
				SocketChannel skt = hs.get(issue.getDid());
				if (null != skt && skt.isActive())
				{
					SetSocketSessionIssue(Constants.OUTER_UP_VERSION,issue,skt);
					byte[] send=DtuCommand.SEND_UPDATE_VERSION.getBytes();
					writeSocket(send,skt);
					rt = Constants.SUC;
				}
			}
		}catch (Exception ex){
			LogUtil.error(ex.getMessage());
		}
		return rt;
	}

	/**
	 * 增加产量
	 * @param issue
	 * @return
	 */
	public  static  String issueAddNum(Issue issue){
		String rt = Constants.FAIL;
		try {
			Map<Integer, SocketChannel> hs = Constants.HM_SOCKET;
			if (null != hs && !"".equals(hs) && hs.size() > 0)
			{
				SocketChannel skt = hs.get(issue.getDid());
				if (null != skt && skt.isActive())
				{

					SetSocketSessionIssue(Constants.OUTER_STUFF,issue,skt);
					Command cmd= CommandService.getCmdByCode(Constants.OUTER_STUFF);
					//增加预设产量
					Device device=DeviceService.getDeviceByDId(issue.getDid());
					int installYield=device.getInstallYield()+Integer.parseInt(issue.getData());
					byte[] prex={0x00,0x02,0x04};
					byte[] num=BytesUtil.intToByteArrayLowHigh(installYield);
				    cmd.setDataSegment(ArrayUtils.addAll(prex,num));
					if(cmd!=null){
						byte[] send = ModbusUtils.cmdToBytes(cmd);
						writeSocket(send,skt);
					}
				}
			}
			rt = Constants.SUC;
		}catch (Exception ex){
			LogUtil.error(ex.getMessage());
		}
		return rt;
	}

	/**
	 * 更新超级密码
	 * @param issue
	 * @return
	 */
	public  static  String issueSpwd(Issue issue){
		String rt = Constants.FAIL;
		try {
			Map<Integer, SocketChannel> hs = Constants.HM_SOCKET;
			if (null != hs && !"".equals(hs) && hs.size() > 0)
			{
				SocketChannel skt = hs.get(issue.getDid());
				if (null != skt && skt.isActive())
				{

					SetSocketSessionIssue(Constants.OUTER_SPWD,issue,skt);
					Command cmd= CommandService.getCmdByCode(Constants.OUTER_SPWD);
					cmd.setDataSegment(BytesUtil.shortToByte(Short.parseShort(issue.getData())));
					if(cmd!=null){
						byte[] send = ModbusUtils.cmdToBytes(cmd);
						writeSocket(send,skt);
					}
				}
			}
			rt = Constants.SUC;
		}catch (Exception ex){
			LogUtil.error(ex.getMessage());
		}
		return rt;
	}

	/**
	 * 删除设备
	 * @param did
	 * @return
	 */
	public  static  String deleteDevice(int did){
		String rt = Constants.FAIL;
		try {
			Map<Integer, SocketChannel> hs = Constants.HM_SOCKET;
			if (null != hs && !"".equals(hs) && hs.size() > 0)
			{
				SocketChannel skt = hs.get(did);
				if (null != skt && skt.isActive())
				{
					skt.close();

				}
				Constants.HM_SOCKET.remove(did);
                Constants.HM_QUENEN_DEVICE.remove(did);
			}
			rt = Constants.SUC;
		}catch (Exception ex){
			LogUtil.error(ex.getMessage());
		}
		return rt;
	}

	/**
	 * Modbus命令
	 * @param issue
	 * @return
	 */
	public  static  String sendCommand(Issue issue){
		String rt = Constants.FAIL;
		try {
			Map<Integer, SocketChannel> hs = Constants.HM_SOCKET;
			if (null != hs && !"".equals(hs) && hs.size() > 0)
			{
				SocketChannel skt = hs.get(issue.getDid());
				if (null != skt && skt.isActive())
				{
					SetSocketSessionIssue(Constants.OUTER_SEND_COMMAND,issue,skt);
					byte[] temp=BytesUtil.hexStringToBytes(issue.getData());
					byte[] send = ModbusUtils.getDataWithCrc(temp);
					writeSocket(send,skt);
				}
			}
			rt = Constants.SUC;
		}catch (Exception ex){
			LogUtil.error(ex.getMessage());
		}
		return rt;
	}

	/**
	 * 发送心跳
	 * @param issue
	 * @return
	 */
	public static String sendHeartBeat(Issue issue)
	{
		String rt = Constants.FAIL;
		try {
			Map<Integer, SocketChannel> hs = Constants.HM_SOCKET;
			if (null != hs && !"".equals(hs) && hs.size() > 0)
			{
				SocketChannel skt = hs.get(issue.getDid());
				if (null != skt && skt.isActive())
				{
					SetSocketSessionIssue(Constants.OUTER_HEART_BEAT,issue,skt);
					String data=String.format(DtuCommand.SEND_HEART_BEAT,issue.getData());
					byte[] send=data.getBytes();
					writeSocket(send,skt);
					rt = Constants.SUC;
				}
			}
			rt = Constants.SUC;
		}catch (Exception ex){
			LogUtil.error(ex.getMessage());
		}
		return rt;
	}

	/**
	 * 主连接类型,地址和端口配置
	 * @param issue
	 * @return
	 */
	public static String sendGprs(Issue issue)
	{
		String rt = Constants.FAIL;
		try {
			Map<Integer, SocketChannel> hs = Constants.HM_SOCKET;
			if (null != hs && !"".equals(hs) && hs.size() > 0)
			{
				SocketChannel skt = hs.get(issue.getDid());
				if (null != skt && skt.isActive())
				{
					SetSocketSessionIssue(Constants.OUTER_GPRS,issue,skt);
					String data=String.format(DtuCommand.SEND_GPRS,issue.getData());
					byte[] send=data.getBytes();
					writeSocket(send,skt);
					rt = Constants.SUC;
				}
			}
			rt = Constants.SUC;
		}catch (Exception ex){
			LogUtil.error(ex.getMessage());
		}
		return rt;
	}

	/**
	 * 设置通信数据
	 * @param operateType
	 * @param issue
	 * @param socket
	 */
    public  static void SetSocketSessionIssue(String operateType,Issue issue, SocketChannel socket) throws Exception{
		Boolean temp=true;
		int i=0;
		while(temp&&i<2){
			temp= Constants.HM_QUENEN_DEVICE.get(issue.getDid());
			if(temp) Thread.sleep(5*1000);
			i++;
		}
		Constants.HM_QUENEN_DEVICE.put(issue.getDid(),true);
		Attribute<ChannelSession> attribute = socket.attr(Constants.ATTRIBUTEKEY);
		ChannelSession session=attribute.get();
		session.setOperateType(operateType);
		session.setIssue(issue);
	}

	/**
	 * 向socket写数据
	 * @param data
	 * @param socket
	 */
   public static  void writeSocket(byte[] data,SocketChannel socket){
	   ByteBuf buf = Unpooled.buffer(data.length);
	   /*for(byte b :data){
		   buf.writeByte(b&0xff);
	   }*/
	   buf.writeBytes(data);
	   socket.writeAndFlush(buf);

	   char start=(char)data[0];
	   String result=null;
	   if(start=='$'){//DTU-非数字
		   StringBuffer sb = new StringBuffer(data.length);
		   for (int i = 0; i < data.length; ++ i) {
			   if (data[i] < 0) throw new IllegalArgumentException();
			   sb.append((char) data[i]);
		   }
		   result=sb.toString().replace("\r\n","");
	   }else{
		   result=BytesUtil.byteTo16String(data);
	   }
	   LogUtil.info("send str:"+result);
   }
}
