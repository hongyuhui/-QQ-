/**
 * 服务器端界面
 * 1.启动和关闭服务器
 * 2.管理和监控用户
 */
package com.qq.server.view;

import javax.swing.JFrame;

import com.qq.server.model.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ServerFrame extends JFrame implements ActionListener{
	JPanel jp;
	JButton jb1,jb2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerFrame sf= new ServerFrame();
	}
	public ServerFrame() {
		jp = new JPanel();	
		jb1 = new JButton("启动服务器");
		jb1.addActionListener(this);
		jb2 = new JButton("关闭服务器");
		jp.add(jb1);
		jp.add(jb2);
			
		this.add(jp);
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1) {
			 new Server();
		}
	}
}
