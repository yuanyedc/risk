package com.risk.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;

public class EchoClient {

	public void bind(String host, int port) {
		EventLoopGroup group = new NioEventLoopGroup();
		Bootstrap b = new Bootstrap();
		b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true).handler(new ChannelInitializer<SocketChannel>() {

			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ByteBuf delimitier = Unpooled.copiedBuffer("$_".getBytes());
				// ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimitier));
				ch.pipeline().addLast(new ObjectDecoder(1024 * 1024, ClassResolvers.cacheDisabled(this.getClass().getClassLoader())));
				ch.pipeline().addLast(new ObjectEncoder());
				// ch.pipeline().addLast(new StringDecoder());
				ch.pipeline().addLast(new EchoClientHanlder());
			}
		});
		try {
			ChannelFuture cf = b.connect(host, port).sync();
			cf.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			group.shutdownGracefully();
		}
	}

	public static void main(String[] args) {
		int port = 9180;
		if (args != null && args.length > 0) {
			port = Integer.valueOf(args[0]);
		}
		new EchoClient().bind("127.0.0.1", port);
	}
}
