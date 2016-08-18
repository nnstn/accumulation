package com.pursuit.designmodel.vo;

import java.io.Serializable;

/**
 * VO就是DTO(Data Transfer Object)，是一种设计模式，主要用于减少数据传送次数，
 * 写VO的时候，要实现Serializable接口
 *
 */
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int orderid;
	private String clientName;
	private int number;
	private String productName;
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", clientName=" + clientName
				+ ", number=" + number + ", productName=" + productName + "]";
	}
	
}
