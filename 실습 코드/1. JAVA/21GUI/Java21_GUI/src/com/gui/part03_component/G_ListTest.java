package com.gui.part03_component;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class G_ListTest {

	public static void main(String[] args) {

		
		JFrame mf = new JFrame();
		
		mf.setSize(300,200);
		
		JPanel listPanel = new JPanel();
		JPanel panel = new JPanel();
		
		String[] cities = {"서울", "대전", "대구", "부산", "경기", "강원","인천","광주","울산"};
		
		JList list = new JList(cities);	
		//리스트에 경계션 설정
		list.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
		
		//리스트에 스크롤바 추가
		JScrollPane scroller = new JScrollPane(list);
		//스크롤 패널 사이즈 지정
		//스크롤 패널의 사이즈를 지정하기 위해 Dimension타입의 객체를 인자로 넣어 주어야 한다.
		scroller.setPreferredSize(new Dimension(200,50));
		
		JLabel label = new JLabel("선택된 항목: ");
		JTextField selected = new JTextField(10);
		
		//readonly
		selected.setEditable(false);
		
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				selected.setText((String) list.getSelectedValue());
			}
		});
		
		
		listPanel.add(scroller);
		panel.add(label);
		panel.add(selected);
		
		mf.add(listPanel, "North");
		mf.add(panel, "South");
		
		
	//	mf.add(list,"North");
		
		
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
		
		
		
		
		
	}

}
