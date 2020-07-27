package com.event.part02_howToUse;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class B_OtherClass extends JFrame{
	public B_OtherClass() {
		
		this.setSize(200,200);
		this.setTitle("OtherClass");
		
		JPanel panel = new JPanel();
		JButton button = new JButton("버튼을 눌러보세요");
		JLabel label = new JLabel("아직 버튼이...");
		
		button.addActionListener(new MyEvent(button, label));
		
		
		panel.add(button);
		panel.add(label);
		
		this.add(panel);
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
 }

}
