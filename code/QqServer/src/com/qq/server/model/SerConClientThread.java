/**
 *  服务器连接客户端的通信线程
 */
package com.qq.server.model;
import java.net.*;
import java.util.HashMap;
import java.util.Iterator;

import com.qq.commom.Message;
import com.qq.commom.MessageType;

import java.io.*;

public class SerConClientThread extends Thread{
	Socket s ;
	public SerConClientThread(Socket s ) {
		//把服务器和该客服端的连接赋给s
		this.s=s;
	}
	
	public void notifyOther(String myId) {
		HashMap<String, SerConClientThread> hm = ManageClientThread.hm;
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()) {
			Message m3 = new Message();
			m3.setCon(myId);
			m3.setMessType(MessageType.message_return_onlineFriends);
			String onlineUser = it.next().toString();
			try {
				ObjectOutputStream oos3 = new ObjectOutputStream(ManageClientThread.getClientThread(onlineUser).s.getOutputStream());
				m3.setGetter(onlineUser);
				oos3.writeObject(m3);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void run() {
		while(true) {
			try {
				//接受客户端的消息
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Message m=(Message)ois.readObject();
				System.out.println(m.getSender()+"给"+m.getGetter()+"说"+m.getCon());
				
//实现消息转发功能
				if(m.getMessType().equals(MessageType.message_common)) {
					//获取接收人的通信线程
					SerConClientThread scct = ManageClientThread.getClientThread(m.getGetter());
					ObjectOutputStream oos = new ObjectOutputStream(scct.s.getOutputStream());
					oos.writeObject(m);
				}else if (m.getMessType().equals(MessageType.message_get_onlineFriends)) {
					String res = ManageClientThread.getonlinelist();
					Message m2 = new Message();
					m2.setMessType(MessageType.message_return_onlineFriends);
					m2.setCon(res);
					m2.setGetter(m.getSender());
					ObjectOutputStream oos2 = new ObjectOutputStream(s.getOutputStream());
					oos2.writeObject(m2);
					
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	
	
	
}
