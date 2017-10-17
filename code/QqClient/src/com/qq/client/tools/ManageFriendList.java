package com.qq.client.tools;

import java.util.HashMap;

import com.qq.client.view.FriendList1;

public class ManageFriendList {
	private static HashMap<String, FriendList1> hm = new HashMap<String,FriendList1>();
	
	public static void addFriendList(String qqId,FriendList1 friendList) {
		hm.put(qqId, friendList);
		
	}
	public static FriendList1 getFriendList(String qqId) {
		return (FriendList1)hm.get(qqId);
	}
}
