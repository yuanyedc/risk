package com.risk.bean;

import java.io.Serializable;

public class RiskResp implements Serializable {

	private static final long serialVersionUID = 1L;
	private int level;
	private String respCode;
	private String desc;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "{level:" + level + ",respCode:" + respCode + ",desc:" + desc + "}";
	}
}
