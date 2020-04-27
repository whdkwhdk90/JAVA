package com.gui.part01_container;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class JFrameTest extends JFrame{
	//프레임을 생성하는 방법1
	//생성자에 프레임에 대한 설정
	
	public JFrameTest() {
	//프레임의 크기 지정
//		this.setLocation(300,200);
//		this.setSize(800,600);
		this.setBounds(300,200,800,600);
		
		
		
		this.setVisible(true);
		
		//닫기 버튼을 눌러도 프로세스는 진행중
		//프로그램 종료시 프로세스도 정상종료될 수 있게 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//프레임 상단에 타이틀 설정
		this.setTitle("MyFrame");
		
		try {
			this.setIconImage(ImageIO.read(new File("images/icon.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//프레임 사이즈 조정 비활성화
		this.setResizable(false);
		//true : 사이즈 조정 가능, 기본값
		
		
		
	}
	
	
	
	
	
	
	
	
}
