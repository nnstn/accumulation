package com.pursuit.designmodel.vo;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
	public static void main(String[] args) throws Exception {
		LocateRegistry.createRegistry(1099);
		IOrderManager ordermanager = new OrderManagerImpl();
		Naming.rebind("ordermanager", ordermanager);
		System.out.println("system is ready");
	}
}
