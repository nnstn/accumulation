package com.pursuit.webdist;
public class TransCode {
	public static void main(String[] args) throws Exception {
		String pathFrom = "E:/研磨设计模式/designpattern/src/cn/javass/dp/visitor/example6/PrintStructVisitor.java";
		String pathTo ="";
		
		String readFile = FileUtils.readFile(pathFrom,"GBK");
		
		System.out.println(readFile);
		
	}
}
