package com.poly.test.test02;

public class Cow extends Base{

	@Override
	public void start() {
		System.out.println("송아지 걷는다");
	}
	
	@Override
	public void stop() {
		System.out.println("송아지 멈췄다");
	}
	
}
