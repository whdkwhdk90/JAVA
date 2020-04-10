package com.poly.test.test01;

public abstract class Animal {	//추상클래스 선언방법(클래스 옆에 선언)
	//추상 메소드 -> 상속받는 class가 반드시! 구현
	
	public abstract void bark();
	
	public void eat(String animal) {
		System.out.println(animal+"먹는다.");
	}
									
}
