package com.event.part02_howToUse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class B_Run {

	public static void main(String[] args) {
		new B_OtherClass();
	}

}

class MyEvent implements ActionListener{
	private JButton button;
	private JLabel label;
	public MyEvent() {}
	public MyEvent(JButton button, JLabel label) {
		button.addActionListener(this);
		this.label = label;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		label.setText("드디어 버튼이...");
	}
	
}


