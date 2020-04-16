package com.kh.test.shape.controller;

import java.util.Scanner;

import com.kh.test.shape.model.vo.Circle;
import com.kh.test.shape.model.vo.RectAngle;

public class ShapeMaker {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Circle[] cc  = new Circle[3];
		for(int i =0; i < cc.length; i++) {
			cc[i]= new Circle(i*10+20);
			cc[i].draw();
		}
		
		RectAngle[] ra= new RectAngle[2];
		for(int i =0; i < ra.length; i++) {
			ra[i]= new RectAngle((i+1)*10,(i+2)*10);
			ra[i].draw();
		}
		
		
		
		
		
	}
	
	
	
	
}
