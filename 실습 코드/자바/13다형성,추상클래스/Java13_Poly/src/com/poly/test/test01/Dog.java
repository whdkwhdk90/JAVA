package com.poly.test.test01;

public class Dog extends Animal{

	
	@Override
	public void bark() {
		System.out.println("멍멍");
	}
	
//	@Override
	public void eat(String animal) {
		super.eat(animal);
		System.out.println("dog eat!!");
	}
	
	
	
}
