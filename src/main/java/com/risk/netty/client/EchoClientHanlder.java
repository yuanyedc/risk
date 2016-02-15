package com.risk.netty.client;

import com.risk.bean.Risk;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class EchoClientHanlder extends ChannelHandlerAdapter {
	private static final String ECHQ_REQ = "yuanye@root$:$_";
	private int count = 0;

	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		for (int i = 0; i < 10; i++) {
			// ctx.writeAndFlush(Unpooled.copiedBuffer(ECHQ_REQ.getBytes()));
			ctx.write(risk(i));
		}
		ctx.flush();
	}

	private Risk risk(int level) {
		Risk risk = new Risk();
		risk.setHigh("A");
		risk.setLow("C");
		risk.setLevel(level);
		return risk;
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		count++;
		System.out.println("count:" + count + " body:" + msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.out.println("error:" + cause.getMessage());
		ctx.close();
	}
}
