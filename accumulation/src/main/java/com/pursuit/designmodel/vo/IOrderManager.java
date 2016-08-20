package com.pursuit.designmodel.vo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOrderManager extends Remote{
	public Order getOrder() throws RemoteException;
	public String getclientName() throws RemoteException;
	public int getnumber() throws RemoteException;
	public String getProductName() throws RemoteException;
}
