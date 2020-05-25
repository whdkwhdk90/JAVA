package com.silsub2.point.model.vo;



public class Circle extends Point{

	private int radius;
	
	
public Circle() {}

public Circle(int x, int y, int radius) {
	super(x,y);
	this.radius = radius;
}
	

@Override
public void draw() {
	
	double Sum =radius*radius*(Math.PI);
	double Length = 2*(Math.PI)*radius;
	super.draw();
	System.out.print("원의 면적 : "+Math.round(Sum*10)/10.0);
	System.out.println(", 원의 둘레 : "+Math.round(Length*10)/10.0);
	//10곱하고 10.0 나누면 소수점 첫째자리까지 출력
	//100곱하고 100.0나누면 소수점 둘째자리까지 출력

	
	System.out.printf("%.1f", Sum);
	System.out.printf("%.1f", Length);
	
	
	
}


	
}
