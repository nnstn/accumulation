package com.pursuit.designmodel.observer.my;

public class ObsMain {
	public static void main(String[] args) {
		MyObservable obs = new MyObservable();
		obs.addObserver(new MyObserver());
		obs.addObserver(new IObserver() {
			
			@Override
			public void update(Object obj) {
				System.out.println("this is observer");
				
			}
		});
		obs.info();
		
	}
}
