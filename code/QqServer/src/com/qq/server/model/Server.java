/**
 * qq服务器，进行监听 等待客户端连接
 */
package com.qq.server.model;

import java.net.*;
import java.io.*;
import java.util.*;

import com.qq.commom.Message;
import com.qq.commom.User;

public class Server {
  
	public Server() {
		try {
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("服务器启动，在9999端口监听");
			while (true) {
				Socket s = ss.accept();//阻塞 等待连接
				//接受客户端的信息
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				User u = (User) ois.readObject();
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

				if (u.getPasswd().equals("123")) {
					//返回成功登录的信息
					Message m = new Message();
					m.setMessType("1");
					oos.writeObject(m);
					
					//单开一个线程，使之与客户端保持通讯
					SerConClientThread scct = new SerConClientThread(s);
					
					//把线程放进HashMap 进行存储
					ManageClientThread.addClientThread(u.getUserId(), scct);
					//启动该线程
					scct.start();
				
					scct.notifyOther(u.getUserId());
				} else {
					//返回登录失败的信息
					Message m = new Message();
					m.setMessType("2");
					oos.writeObject(m);
					//关闭连接
					oos.close();
					ois.close();
					s.close();
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
		
		}
	}
}
