package com.kh.test.shape.model.vo;

public class Circle {
	public final double PI = Math.PI;
	private int radius;
	
	
	public Circle() {}
	public Circle(int radius) {
		this.radius = radius;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public double getPI() {
		return PI;
	}
	
	public void draw() {
		System.out.println("반지름 "+ radius + "cm인 원을 그립니다.");
		
	}
	
	
}
