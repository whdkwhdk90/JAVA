package com.test.chap02_throwPrac;

import java.io.IOException;

public class Run {

	public static void main(String[] args) {
		try {
			methodA();
		} catch (IOException e) {
			System.out.println("예외발생!!");
			e.printStackTrace();
		}
		System.out.println("프로그램종료");
		//methodA 실행하면 B,C까지갔다가 C가종료하면 C를 부른곳,
		//그다음 B,A,main으로 돌아와서 프로그램종료 실행
		
	}
	
	public static void methodA() throws IOException {
		methodB();
	}
	public static void methodB() throws IOException {
		methodC();
	}
	public static void methodC() throws IOException {
		throw new IOException();
		//예외처리방법에 문제생겨서 methodC옆에 throws 생김
	}
	
	
	
	
	
	
}
