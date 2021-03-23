package com.nettyTest.NettyServer;
import com.nettyTest.nettyStart;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;


@Component
public class nettyServer {
    private static final Logger log = LoggerFactory.getLogger(nettyServer.class);

    /**
     * boss 线程组用于处理连接工作
     */
    private static final EventLoopGroup boss = new NioEventLoopGroup();

    /**
     * work 线程组用于数据处理
     */
    private static final EventLoopGroup work = new NioEventLoopGroup();

    @Value("${netty.port}")
    private Integer port;

    @PostConstruct
    public  void  start() throws InterruptedException{
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss,work)
                //指定Channel
                .channel(NioServerSocketChannel.class)
                //使用指定的端口设置套接字地址
                .localAddress(new InetSocketAddress(port))
                //服务端可连接队列数,对应TCP/IP协议listen函数中backlog参数
                .option(ChannelOption.SO_BACKLOG,1024)
                //设置TCP长连接,一般如果两个小时内没有数据的通信时,TCP会自动发送一个活动探测数据报文
                .childOption(ChannelOption.SO_KEEPALIVE,true)
                //将小的数据包包装成更大的帧进行传送，提高网络的负载,即TCP延迟传输
                .childOption(ChannelOption.TCP_NODELAY,true)
                .childHandler(new ServerInitializer());

        try {
            //绑定端口 同步等待成功
            ChannelFuture f = bootstrap.bind(port).sync();
            //等待服务端监听端口关闭
//            f.channel().closeFuture().sync();
            log.info("启动netty服务端成功");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
//            work.shutdownGracefully();
//            boss.shutdownGracefully();
        }
    }


    @PreDestroy
    public void destory() throws InterruptedException {
        boss.shutdownGracefully().sync();
        work.shutdownGracefully().sync();
        log.info("关闭netty!!!");
    }
}
