package com.gui.part02_layout;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JFrame;

public class C_GridLayout extends JFrame{

	public C_GridLayout() {
		//기본 프레임 설정
//		super("GridLayout");
//		this.setVisible(true); //화면 보여지는 것 여부
//		this.setBounds(300,200,600,400); //화면 크기
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //화면 종료시 콘솔 종료
//		
//		//GridLayout
//		//위에서 아래, 왼쪽에서 오른쪽으로 배치
//		//가로,세로,가로갭,세로갭(크기 : 5x5)
//		this.setLayout(new GridLayout(5,5/*,10,20*/));
//	
		
//		for(int i=0;i<26;i++) {
//			String str = new Integer(i).toString();
//			this.add(new JButton(str));
//		}
//		
		
		
		
		
		//set을 이용해 중복 제거하여 랜덤으로 빙고판 만들기
//		Set set  = new LinkedHashSet();
		
//		while(set.size() <25) {
//		set.add(new Random().nextInt(25)+1);
//		}
//		System.out.println(set);
//		
//		Object[] obj = set.toArray();
//		
//		for(int i=0;i<obj.length;i++) {
//			String str = new Integer((int)obj[i]).toString();
//			this.add(new JButton(str));
//		}
		
		Set set = new HashSet();
		int size = 0;
		Iterator setIt = set.iterator();
		while(set.size() <25) {
			int num = (int)(Math.random()*25+1);
			set.add(num);
		}
		
		while(setIt.hasNext()) {
			System.out.print(setIt.next()+" ");
		}
		
		
		
		
		
	}
}
