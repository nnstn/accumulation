package com.pursuit.designmodel.vo;

public class OrderManagerImpl implements IOrderManager{

	@Override
	public Order getOrder() {
		Order order = new Order();
		order.setOrderid(1);
		order.setClientName("jack");
		order.setNumber(1);
		order.setProductName("product");
		return order;
	}

	@Override
	public String getclientName() {
		
		return "jack";
	}

	@Override
	public int getnumber() {
		return 0;
	}

	@Override
	public String getProductName() {
		return "produc";
	}

}
