package com.poly.test.test04;

public class Cat extends Animal {

	@Override
	public void bark() {
		System.out.println("야옹");
		
	}

	@Override
	public void eat(String feed) {
		System.out.println(feed+"먹는다. 야옹!");
	}
	
	
	
}
