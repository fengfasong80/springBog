package com.fc.springmvc.modules.commerce.vo;

import com.fc.springmvc.modules.commerce.entity.Good;

public class GoodVo extends Good {

	private String goodTypeName;

	public String getGoodTypeName() {
		return goodTypeName;
	}

	public void setGoodTypeName(String goodTypeName) {
		this.goodTypeName = goodTypeName;
	}

}
