package com.poly.test.test04;

public class Eagle extends Animal implements Bird{

	@Override
	public void fly() {
		System.out.println("파닥파닥");
		
	}

	@Override
	public void bark() {
		System.out.println("독수독수");
		
	}
	//추상클래스랑 인터페이스를 상속받음		
	
	
	
	
	
}
