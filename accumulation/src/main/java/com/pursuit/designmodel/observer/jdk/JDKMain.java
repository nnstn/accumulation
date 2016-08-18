package com.pursuit.designmodel.observer.jdk;

/**
 * 观察者模式可以让多线程监控问题，以单线程的方式完成处理
 *
 */
public class JDKMain {
	public static void main(String[] args) {
		MySubject observale = new MySubject();
		observale.addObserver(new MyObserver());
		
		observale.setSujectContent("test");
	}
}
