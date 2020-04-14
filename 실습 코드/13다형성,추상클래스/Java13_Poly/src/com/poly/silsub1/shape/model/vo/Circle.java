package com.poly.silsub1.shape.model.vo;

public class Circle extends Shape implements IShape{

	private final double PI = Math.PI;
	private double radius;
	
 public Circle(){
		
		
		radius = 0;
	}
	
	
 public Circle(double radius){
	this.radius = radius;
}	 
	 
	 
	 
	
	@Override
	public double area() {
		System.out.print("원의 ");
		return this.PI*this.radius*this.radius;
	}

	@Override
	public double perimeter() {
		System.out.print("원의 ");
		return 2*this.PI*this.radius;
	}



	
	
	
	public double getRadius() {
		return radius;
	}



	public void setRadius(double radius) {
		this.radius = radius;
	}



	public double getPI() {
		return PI;
	}

	
	
	
	
	
}
