package com.fc.springmvc.modules.commerce.entity;

import java.sql.Date;

import com.baomidou.mybatisplus.annotation.TableField;

public class Good {
	// 主键
	private String id;
	// 商品名称
	private String name;
	// 价格
	private Double price;
	// 生产日期
	@TableField("productDate")
	private Date productDate;
	// 保质期，单位天
	private Integer expiration;
	// 厂商
	private String production;
	@TableField("goodTypeId")
	private String goodTypeId;

	public String getGoodTypeId() {
		return goodTypeId;
	}

	public void setGoodTypeId(String goodTypeId) {
		this.goodTypeId = goodTypeId;
	}

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public Integer getExpiration() {
		return expiration;
	}

	public void setExpiration(Integer expiration) {
		this.expiration = expiration;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

}
