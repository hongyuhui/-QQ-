/**
 * 管理客户端与服务器保持通讯的线程类
 */
package com.qq.client.tools;

import java.util.HashMap;

public class ManageCCST {
	public static HashMap<String, ClientConServerThread> hm = new HashMap<String,ClientConServerThread>();
	
	//把创建好的ClientConServerThread添加到hm
	public static void addClientConServerThread (String ownid,ClientConServerThread ccst) {
		hm.put(ownid, ccst);
	}
	//通过 ownid 从 hm 获取该ClientConServerThread
	public static ClientConServerThread getClientConServerThread(String ownid) {
		return (ClientConServerThread)hm.get(ownid);
	}
	
	
}
