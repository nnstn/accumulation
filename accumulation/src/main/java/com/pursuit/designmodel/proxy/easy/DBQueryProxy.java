package com.pursuit.designmodel.proxy.easy;

public class DBQueryProxy implements IDBQuery {
	DBQuery real = null;
	@Override
	public void request() {
		if(real==null){
			real = new DBQuery();
		}
		real.request();
	}

}
