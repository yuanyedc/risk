package com.risk.netty.server;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import com.risk.bean.Risk;
import com.risk.bean.RiskResp;

public class EchoServerHandler extends ChannelHandlerAdapter {

	private int count;

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		Risk risk = (Risk) msg;
		count++;
		System.out.println("count:" + count + " body:[" + risk.toString() + "]");
		ctx.writeAndFlush(getResp(risk.getLevel()));
	}

	private RiskResp getResp(int level) {
		RiskResp resp = new RiskResp();
		resp.setLevel(level);
		resp.setRespCode("000000");
		resp.setDesc("成功");
		return resp;
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.out.println("==" + cause.getMessage());
		ctx.close();
	}
}
