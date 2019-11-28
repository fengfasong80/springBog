package com.fc.springmvc.modules.commerce.entity;

import java.io.Serializable;

public class GoodType implements Serializable{
	private static final long serialVersionUID = 1L;
	// 主键
	private String id;
	// 商品类型名称
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
