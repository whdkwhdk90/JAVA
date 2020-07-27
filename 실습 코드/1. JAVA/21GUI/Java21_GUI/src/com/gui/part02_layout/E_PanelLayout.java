package com.gui.part02_layout;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class E_PanelLayout extends JFrame{
	public E_PanelLayout() {
		super("PanelLayout");
		this.setBounds(200,200,500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		//현재 레이아웃 출력
		System.out.println(this.getLayout());
		
		JLabel lb = new JLabel("이름: ");
		lb.setLocation(50,100);
		lb.setSize(150,50);
		
		JTextField tf = new JTextField(20);
		tf.setLocation(110,100);
		tf.setSize(200,50);
		
		JButton btn = new JButton("추가");
		btn.setLocation(350,100);
		btn.setSize(100,50);
		
		
		//패널 추가
		JPanel panel = new JPanel();
		panel.setSize(500,500);
		
		System.out.println(panel.getLayout());
		
		//패널에 레이아웃 설정하지 않으면 기본이flowLayout의 center
		panel.setLayout(null);
		panel.add(lb);
		panel.add(tf);
		panel.add(btn);
		panel.setBackground(Color.pink);
		
		
		
		
		
		this.add(panel);
		this.setVisible(true);
		
		
	}
	
}
