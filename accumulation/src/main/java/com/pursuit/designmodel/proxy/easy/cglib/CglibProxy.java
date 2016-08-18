package com.pursuit.designmodel.proxy.easy.cglib;

import java.lang.reflect.Method;

import com.pursuit.designmodel.proxy.easy.DBQuery;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 *CGLib创建的动态代理对象性能比JDK创建的动态代理对象的性能高不少，
 *但是CGLib在创建代理对象时所花费的时间却比JDK多得多
 *所以对于单例的对象，因为无需频繁创建对象，用CGLib合适，
 *反之，使用JDK方式要更为合适一些。
 *同时，由于CGLib由于是采用动态创建子类的方法，对于final方法，无法进行代理。
 */
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
