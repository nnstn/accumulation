package com.pursuit.designmodel.vo;

import java.rmi.Naming;

public class Client {
	public static void main(String[] args) throws Exception {
		IOrderManager manager = (IOrderManager) Naming.lookup("ordermanager");
		Order order = manager.getOrder();
		System.out.println(order);
		System.out.println( manager.getclientName());
	}
	
}
