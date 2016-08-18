package com.pursuit.designmodel.vo;

import java.io.Serializable;
import java.rmi.Remote;

public interface IOrderManager extends Remote,Serializable{
	public Order getOrder();
	public String getclientName();
	public int getnumber();
	public String getProductName();
}
