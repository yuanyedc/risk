package com.risk.bean;

import java.io.Serializable;

public class Risk implements Serializable {

	private static final long serialVersionUID = 1L;

	private String high;
	private String low;
	private int level;

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "{high:" + high + ",low:" + low + ",level:" + level + "}";
	}
}
