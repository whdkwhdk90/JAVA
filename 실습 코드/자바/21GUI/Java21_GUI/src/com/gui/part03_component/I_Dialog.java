package com.gui.part03_component;

import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class I_Dialog {

	public static void main(String[] args) {

		JFrame mf = new JFrame();
//		mf.setSize(500,400);
				
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JButton button1 = new JButton("simple Dialog");
		//다이얼로그
		Dialog sd = new Dialog(mf,"Dialog");
		sd.setBounds(150,250,100,100);
		JButton button2 = new JButton("Close");
		sd.add(button2);
		
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sd.setVisible(true);
			}});
		
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sd.dispose();
				
			}});
		
		JButton button3 = new JButton("Input");
		panel.add(button3);
		
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String res = JOptionPane.showInputDialog("내용 입력: ");
				System.out.println(res);
			}});
		
		panel.add(button1);
		mf.add(panel);
		mf.pack();
		
		
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
		
		
	}

}
