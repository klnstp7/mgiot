package com.migen.myiot.netty;

import com.migen.myiot.utils.LogUtil;
import com.migen.myiot.enums.Constants;
import com.migen.myiot.utils.DateUtils;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/6/3.
 */
public class NettyServer extends Thread{

    SocketChannel socketChannel;

    public void run()
    {
        EventLoopGroup boss=new NioEventLoopGroup();
        EventLoopGroup worker=new NioEventLoopGroup();
        ServerBootstrap bootstrap=new ServerBootstrap();
        bootstrap.group(boss,worker);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
        //通过NoDelay禁用Nagle,使消息立即发出去，不用等待到一定的数据量才发出去
       // bootstrap.option(ChannelOption.TCP_NODELAY, true);
        //保持长连接状态
        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelPipeline p = socketChannel.pipeline();
			/*	p.addLast(new ObjectEncoder());
				p.addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(null)));*/
                p.addLast("ping", new IdleStateHandler(30, 0, 0,TimeUnit.MINUTES));
                p.addLast(new NettyServerInHandler());
            }
        });
        try {
            //绑定本是异步操作,这里将其变为同步阻塞
            ChannelFuture cf = bootstrap.bind(Constants.SOCKETSERV_PORT).sync();
            if(cf.isSuccess()){
                LogUtil.info("server start success,datetime:"+ DateUtils.getDateTime(new Date()));
            }
            //promise模式，阻塞至channel关闭后才退出
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
            LogUtil.info("server start fail,datetime:"+ DateUtils.getDateTime(new Date())+",message:"+e.getMessage());
        } finally {
            //优雅退出，释放线程资源
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}
