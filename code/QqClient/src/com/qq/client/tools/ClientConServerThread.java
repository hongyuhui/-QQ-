/**
 * 客户端与服务器保持通讯的线程
 */
package com.qq.client.tools;

import java.net.*;
import com.qq.client.view.Chat1;
import com.qq.client.view.FriendList1;
import com.qq.commom.Message;
import com.qq.commom.MessageType;

import java.io.*;
public class ClientConServerThread extends Thread{
	Socket s;
	public ClientConServerThread(Socket s) {
		super();
		this.s = s;
	}
	
	public void run() {
		//不停的读取从服务器发来的消息
		while(true) {
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Message m = (Message) ois.readObject();
				String info = m.getSendTime()+"  "+m.getSender()+" 对 "+m.getGetter()+" 说: "+"\r\n"+m.getCon()+"\r\n";
				System.out.println(info);
				if(m.getMessType().equals(MessageType.message_common)) {
					//把消息显示在聊天窗口
					Chat1 chat = ManageChat.getChat(m.getGetter()+" "+m.getSender());
					chat.showMessage(m);
				}else if(m.getMessType().equals(MessageType.message_return_onlineFriends) ){
					String getter = m.getGetter(); 
					FriendList1 friendList = ManageFriendList.getFriendList(getter);
					if(friendList != null) {
						friendList.updateonlinelist(m);
					}
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

	public Socket getS() {
		return s;
	}

	public void setS(Socket s) {
		this.s = s;
	}
	
}
