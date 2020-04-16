package com.silsub2.point.model.vo;

public class Rectangle extends Point{
	
	private int width;
	private int height;
	
	
public Rectangle() {}

public Rectangle(int x , int y, int width, int height) {
	super(x,y);
	this.width = width;
	this.height = height;
	
}

public int getWidth() {
	return width;
}

public void setWidth(int width) {
	this.width = width;
}

public int getHeight() {
	return height;
}

public void setHeight(int height) {
	this.height = height;
}

@Override
public void draw() {
	int Sum = getWidth()*this.height;
	int Length = 2*(this.width+this.height);
	
	super.draw();
	System.out.print("("+this.x + ","+this.y+"), ");
	System.out.print("("+this.x+","+(this.height+this.y)+"), ");
	System.out.print("("+(this.width+this.x)+","+this.y+"), ");
	System.out.print("("+(this.width+this.x)+","+(this.height+this.y)+") \n ");
	System.out.println("사각형의 면적 : "+Math.round(Sum*10)/10.0+
					", 사각형의 둘레 : "+Math.round(Length*10)/10.0+".");
}


	
	
}
