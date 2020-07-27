package com.event.part01_mouserAndKey;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseEvent extends JFrame implements MouseListener, MouseMotionListener{

	public MouseEvent() {
		this.setTitle("Mouse Event");
		this.setSize(300,200);
		
		
		JPanel panel = new JPanel();
		
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		
		
		
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		
		new MouseEvent();
		
	}

	public void display(String s, java.awt.event.MouseEvent e) 	
	{
		System.out.println(s+" X= "+e.getX()+" Y= "+e.getY());
	}
	
	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {
		this.display("Mouse dragged", e);
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {
		this.display("Mouse Moved", e);
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		this.display("Mouse Clicked(cliecks: "+e.getClickCount()+")", e);
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		this.display("Mouse Pressed", e);
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		this.display("Mouse Released", e);
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		this.display("Mouse Entered", e);
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		this.display("Mouse Exited", e);
	}
	
	
	
	
	
	
	
}
