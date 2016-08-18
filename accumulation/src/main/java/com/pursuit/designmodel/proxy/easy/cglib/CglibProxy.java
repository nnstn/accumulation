package com.pursuit.designmodel.proxy.easy.cglib;

import java.lang.reflect.Method;

import com.pursuit.designmodel.proxy.easy.DBQuery;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	DBQuery real = null;
	public CglibProxy() {
		System.out.println("===========创建代理对象================");
	}
    public Object createProxy(Class clazz) {
        Enhancer enhancer = new Enhancer();
        //设置需要创建子类的类  
        enhancer.setSuperclass(clazz);  
        enhancer.setCallback(this);// 设置回调
        return enhancer.create();
    }

	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("===========进入代理方法内部 1===========");
		if(real==null){
			new DBQuery();
		}
		System.out.println("===========进入代理方法内部 2===========");
		//通过代理类调用父类中的方法  
		
		Object result = proxy.invokeSuper(obj, args);  
		return result;
	}


}
