package com.gui.part02_layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class B_FlowLayout extends JFrame{

	public B_FlowLayout() {
	
		super("FlowLayout");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setBounds(300,200,600,400);
		
		
		//FlowLayout
//		this.setLayout(new FlowLayout());
		
		
		//추가 레이아웃 설정
//		this.setLayout(new FlowLayout(FlowLayout.CENTER)); //기본값(가운데 정렬)
//		this.setLayout(new FlowLayout(FlowLayout.LEFT)); //왼쪽 정렬
		this.setLayout(new FlowLayout(FlowLayout.RIGHT)); //오른쪽 정렬
		
		
		
		
		
		this.add(new JButton("1번"));
		this.add(new JButton("2번"));
		this.add(new JButton("3번"));
		this.add(new JButton("4번"));
		this.add(new JButton("5번"));
		this.add(new JButton("6번"));
		this.add(new JButton("7번"));
		this.add(new JButton("8번"));
		this.add(new JButton("9번"));
		this.add(new JButton("10번"));
		this.add(new JButton("11번"));
		this.add(new JButton("12번"));
		this.add(new JButton("13번"));
		this.add(new JButton("14번"));
		this.add(new JButton("15번"));
		
		
		
		
		
	}
	
	
	
}
