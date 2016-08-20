package com.pursuit.performance;

import java.util.ArrayList;
import java.util.List;

public class StringSub {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 100000; i++) {
			HugeStr h = new HugeStr();
			list.add(h.getSubString(1, 5));
		}
	}
	
	static class HugeStr{
		private String str =  new String (new char[10000000]);
		public String getSubString(int begin,int end){
			return str.substring(begin, end);
		}
	}
	static class ImproveHugeStr{
		private String str =  new String (new char[100000]);
		public String getSubString(int begin,int end){
			return new String(str.substring(begin, end));
		}
	}
}
