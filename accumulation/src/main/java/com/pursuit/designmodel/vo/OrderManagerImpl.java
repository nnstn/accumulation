package com.pursuit.designmodel.vo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OrderManagerImpl extends UnicastRemoteObject implements IOrderManager{

	protected OrderManagerImpl() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public Order getOrder() throws RemoteException{
		Order order = new Order();
		order.setOrderid(1);
		order.setClientName("jack");
		order.setNumber(1);
		order.setProductName("product");
		return order;
	}

	@Override
	public String getclientName()  throws RemoteException {
		
		return "jack";
	}

	@Override
	public int getnumber() throws RemoteException {
		return 0;
	}

	@Override
	public String getProductName() throws RemoteException {
		return "produc";
	}

}
