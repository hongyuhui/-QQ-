package com.qq.client.tools;

import java.util.HashMap;

import com.qq.client.view.Chat1;

public class ManageChat {
	private static HashMap<String, Chat1> hm = new HashMap<String, Chat1>();
	
	//加入
	public static void addChat(String ownAndFriend, Chat1 chat1) {
		hm.put(ownAndFriend, chat1);
	}
	//取出
	public static Chat1 getChat(String ownAndFriend) {
		return (Chat1)hm.get(ownAndFriend);
	}
}
