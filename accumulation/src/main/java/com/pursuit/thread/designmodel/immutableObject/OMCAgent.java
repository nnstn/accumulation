package com.pursuit.thread.designmodel.immutableObject;

public class OMCAgent extends Thread {

	@Override
	public void run() {
		boolean isTableModificationMsg=false;
		String updateTableName=null;
		while(true){
			//省略其他代码
			if(isTableModificationMsg){
				if("MMSCInfo".equals(updateTableName)){
					MMSCRouter.setInstance(new MMSCRouter());
				}
			}
			//省略其他代码
		}
	}

}
