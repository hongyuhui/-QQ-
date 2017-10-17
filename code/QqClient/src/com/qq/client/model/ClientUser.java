package com.qq.client.model;

import com.qq.commom.User;

public class ClientUser {

	public boolean checkUser(User u) {
		return new ClientConServer().sendLoginInfo(u); 
	}
}
