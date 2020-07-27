package com.gui.part02_layout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class A_BorderLayout extends JFrame{

	public A_BorderLayout() {
		super("BorderLayout");
		
		//두가지는 거의 필수로 호출함
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
		
		this.setBounds(300,200,600,400);

	this.setLayout(new BorderLayout());  //기본값으로 적용되어있음(따로 설정은 하지 않아도 됨)
		System.out.println(this.getLayout());
		
		
		JButton north = new JButton("북");
		JButton south = new JButton("남");
		JButton west = new JButton("서");
		JButton east = new JButton("동");
		JButton center = new JButton("가운데");
		
		//레이아웃의 위치별로 컴포넌트 배치
		//대소문자에 유의(""안에 첫글자 대문자 안하면 오류뜸)
		this.add(north, "North");  
		this.add(south, "South");
		this.add(west, "West");
		this.add(east, "East");
		this.add(center, "Center");
		
		this.add(new JButton("북"), "North");
		this.add(new JButton("남"), "South");
		this.add(new JButton("서"), "West");
		this.add(new JButton("동"), "East");
		this.add(new JButton("가운데"), "Center");
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
