package com.test01.aaa;

public class AAA {
		private int abc;
		
		
		//
	public AAA() {
		System.out.println("AAA 생성");
	}
		
	//매개변수생성자
	public AAA(int abc) {
		System.out.println("AAA 생성(abc 받아서)");
		this.abc = abc;
	}
	//getter & setter
	
	public int getAbc() {
		return abc;
	}
	
	public void setAbc(int abc) {
		this.abc= abc;
	}
	
	public void prn() {
		System.out.println("AAA의 prn 메소드");
	}
	
	
	
	
}
