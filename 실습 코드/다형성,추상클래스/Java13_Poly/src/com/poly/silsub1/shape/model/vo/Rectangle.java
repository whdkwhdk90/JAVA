package com.poly.silsub1.shape.model.vo;

public class Rectangle implements IShape {

	private double width;
	private double height;
	
	
	
 public Rectangle(){
	width = 0;
	height = 0;
}

public Rectangle(double width, double height){
	this.width = width;
	this.height = height;
}	
 
 
 
	
	@Override
	public double area() {
		System.out.print("사각형의 ");
		return (this.width*this.height);
	}

	@Override
	public double perimeter() {
		System.out.print("사각형의 ");
		return 2*(this.width+this.height);
	}

	
	
	
	
	
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	
	
	
	
	
	
	
	
	
	
}
