package com.pursuit.thread.base;

public class TraditionalThread_1 {
	public static void main(String[] args) {
		
		//验证 thread 子类run方法会覆盖  
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run(){
				// Thread.sleep(1000);
				while (true) {
					System.out.println(11);
					
				}
			}
		}){
			@Override
			public void run() {
				while (true) {
					System.out.println(22);
					
				}
			}
		};
		thread.start();
	}
}
