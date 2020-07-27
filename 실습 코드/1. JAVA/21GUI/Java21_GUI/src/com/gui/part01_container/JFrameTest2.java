package com.gui.part01_container;

import java.awt.Rectangle;

import javax.swing.JFrame;

public class JFrameTest2 {
	//프레임 생성하는 방법2
	//JFrame 클래스 객체 생성
	public void showMainFrame() {
		//JFrame 객체 생성
//		JFrame mainFrame = new JFrame();
//		mainFrame.setTitle("MyFrame2");
//		mainFrame.setVisible(true);
		
		JFrame mainFrame = new JFrame("MyFrame2");
		
		mainFrame.setVisible(true);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//java.awt.Rectangle 객체를 활용한 사이즈 설정
		
		Rectangle r = new Rectangle(300,200,800,500);
		mainFrame.setBounds(r);
		
		
		
		
	}
	
	
}
