package com.event.part02_howToUse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class A_AnoClass {

	public static void main(String[] args) {
		/*
		 * 익명 클래스(Anonymous Class)
		 * 이름이 없는 클래스, 클래스 선언과 객체의 생성을 동시에 하므로 한번만 사용 가능
		 * 오직 하나의 객체만 생성하여 사용하는 일회용 클래스
		 */
		
		JFrame mf = new JFrame("익명클래스");
		mf.setSize(300,300);
		
		
		JPanel panel = new JPanel();
		JButton button = new JButton("버튼을 눌러요");
		JLabel label = new JLabel("아직 버튼이...");
		
		panel.add(button);
		panel.add(label);
		mf.add(panel);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("드디어.....");
			}});
		
		
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
		
		
	}
	
	
}
