package com.event.part01_mouserAndKey;

import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class KeyEvent extends JFrame implements KeyListener{

	
	public KeyEvent() {
		this.setTitle("Key event");
		this.setSize(300,300);
		JTextField tf = new JTextField(30);
		tf.addKeyListener(this);
		this.add(tf);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	
	public static void main(String[] args) {
		new KeyEvent();
		
		
		
		
	}


	public void display(String s, java.awt.event.KeyEvent e) {
		
		//컨트롤 쉬프트 알트
		String str = e.isAltDown()+":"+e.isControlDown()+":"+e.isShiftDown();
		System.out.println(s+" "+e.getKeyChar()+str);
		
	}


	@Override
	public void keyTyped(java.awt.event.KeyEvent e) {
		this.display("Key Typed", e);
	}




	@Override
	public void keyPressed(java.awt.event.KeyEvent e) {
		this.display("Key Pressed", e);
		
	}




	@Override
	public void keyReleased(java.awt.event.KeyEvent e) {
		this.display("key Released", e);
	}

}
