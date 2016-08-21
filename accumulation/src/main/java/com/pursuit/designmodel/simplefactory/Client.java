package com.pursuit.designmodel.simplefactory;

/**
 * Client
 * API
 * Fatcory
 */
public class Client {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			API api = SimpleFactory.createAPI();
			api.concreteimpl();
		}
		
	}
}
