package com.pursuit.designmodel.observer.my;

public class MyObserver implements IObserver {

	@Override
	public void update(Object obj) {
		System.out.println(obj);
	}

}
