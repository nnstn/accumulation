package com.pursuit.designmodel.observer.jdk;

public class JDKMain {
	public static void main(String[] args) {
		MySubject observale = new MySubject();
		observale.addObserver(new MyObserver());
		
		observale.setSujectContent("test");
	}
}
