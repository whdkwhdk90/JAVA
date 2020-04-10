package com.poly.silsub1.shape.model.vo;

public class Triangle implements IShape {

	private double base;
	private double height;
	
public Triangle(){
	base = 0;
	height = 0;
}

public Triangle(double base, double height) {
	this.base =base;
	this.height = height;
}
	
	
	@Override
	public double area() {
		System.out.print("삼각형의 ");
		return (base*height)/2;
	}
	
	public double getHypotenuse() {
		System.out.print("삼각형의 ");
		return (Math.sqrt(base*base + height*height));
	}
	
	
	@Override
	public double perimeter() {
		return ((Math.sqrt(base*base + height*height)) + base+height);
	}

}
