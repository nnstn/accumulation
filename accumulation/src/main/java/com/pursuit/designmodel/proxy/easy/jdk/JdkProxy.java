package com.pursuit.designmodel.proxy.easy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.pursuit.designmodel.proxy.easy.DBQuery;

/**
 *  jdk 代理对象实现延时加载
 */
public class JdkProxy implements InvocationHandler{
	DBQuery real = null;
	
	public JdkProxy() {
		System.out.println("===========创建代理对象================");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if(real==null){
			real = new DBQuery();
			
		}
		return method.invoke(real, args);
	}

}
