package com.qq.server.model;

import java.util.HashMap;
import java.util.Iterator;

public class ManageClientThread {
	public static HashMap<String, SerConClientThread> hm = new HashMap<String , SerConClientThread >();
	
	public static void addClientThread(String uid,SerConClientThread ct) {
		hm.put(uid, ct);
	} 
	
	public static SerConClientThread getClientThread(String uid) {
		return (SerConClientThread)hm.get(uid);
		
	}
	//返回在线好友的情况
	public static String getonlinelist() {
		Iterator<String> it = hm.keySet().iterator();
		String res = "";
		while(it.hasNext()) {
			res += it.next().toString()+" ";
		}
		return res;
	}
}
