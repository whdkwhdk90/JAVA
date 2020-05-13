package com.gui.part02_layout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class D_CardLayout extends JFrame {

	public D_CardLayout() {
		super("CardLayout");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300,200,600,400);
		
		
		//CardLayout
		CardLayout card = new CardLayout();
		this.setLayout(card);
		
//		this.setLayout(new CardLayout());
		
		//패널 만들기(컴포넌트의 일종) - 다른 컴포넌트를 포함할 수 있음
		JPanel card1 = new JPanel();
		JPanel card2 = new JPanel();
		JPanel card3 = new JPanel();
		
		//패널에 라벨 추가
		card1.add(new JLabel("Card1"),"1");
		card2.add(new JLabel("Card2"),"2");
		card3.add(new JLabel("Card3"),"3");
		
		//배경색 추가
		card1.setBackground(Color.DARK_GRAY);
		card2.setBackground(Color.YELLOW);
		card3.setBackground(Color.ORANGE);
		
		
		
		//메인 프레임에 추가
		this.add(card1);
		this.add(card2);
		this.add(card3);
		
		//패널에 이벤트 추가
		card1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getButton());
				if(e.getButton() == 1) {
					card.next(card1.getParent());
				}
			}
			
			
		});
		//마우스 왼쪽 클릭 : 1, 휠 클릭 : 2, 오른쪽 클릭 : 3
		card2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getButton());
				if(e.getButton() == 1) {
					card.next(card2.getParent());
				}
			}
			
			
		});
		
		
		
		
		
		
	}
	
	
	
	
	
}
