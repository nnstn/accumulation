package com.pursuit.designmodel.proxy.easy.jdk;

import java.lang.reflect.Proxy;
import com.pursuit.designmodel.proxy.easy.IDBQuery;

public class JdkProxyMain{
	public static void main(String[] args) {
		IDBQuery query = (IDBQuery) Proxy.newProxyInstance(
				IDBQuery.class.getClassLoader(),
				new Class<?>[]{IDBQuery.class},
				//DBQuery.class.getInterfaces(), 
				new JdkProxy());
		System.out.println("======================================");
		query.request();
	}

}
