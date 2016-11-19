package com.pursuit.thread.designmodel.immutableObject;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 彩信中心路由规则管理器
 * 模式角色：immutableObject.ImmutableObject 
 */
public class MMSCRouter {
	//volatile 修饰保证多线程环境下变量的可见性
	private static volatile MMSCRouter instance = new MMSCRouter(); 
	//维护手机号前缀到彩信中心的映射中心
	private final Map<String, MMSCInfo> routeMap;
	
	public MMSCRouter(){
		//将数据库表中的数据加载到内存，存为map
		this.routeMap=this.retrieveRouteMapFromDB();
	}
	
	private static Map<String, MMSCInfo> retrieveRouteMapFromDB(){
		Map<String, MMSCInfo> map = new HashMap<String, MMSCInfo>();
		//省略其他代码
		return map;
	}
	public MMSCRouter getinstance(){
		return instance;
	}
	
	/**
	 * 将当前的MMSCRouter实例更新为指定的新实例
	 * @param newinstance
	 */
	public static void setInstance(MMSCRouter newinstance) {
		instance = newinstance;
	}

	/**
	 * 根据手机号前缀获取对应的彩信中心信息
	 * @param msisdnPrefix
	 */
	public MMSCInfo getMMSC(String msisdnPrefix){
		return routeMap.get(msisdnPrefix);
	}
	private static Map<String, MMSCInfo> deepCopy(Map<String, MMSCInfo> m){
		Map<String, MMSCInfo> result = new HashMap<String, MMSCInfo>(); 
		for (String key:m.keySet()) {
			result.put(key, new MMSCInfo(m.get(result)));
		}
		return result;
	}
	public Map<String, MMSCInfo> getRouteMap(){
		//做防御性复制
		return Collections.unmodifiableMap(deepCopy(routeMap));
	}
}
