package com.poly.silsub1.shape.controller;

import com.poly.silsub1.shape.model.vo.Circle;
import com.poly.silsub1.shape.model.vo.IShape;
import com.poly.silsub1.shape.model.vo.Rectangle;
import com.poly.silsub1.shape.model.vo.Triangle;

public class ShapeManager {

	
	
//	public void calcShape() {
//		
//		
//		
//	Shape s = new Circle(15.5);
//	System.out.println("면적  : "+s.area());
//	System.out.println("둘레 : "+s.perimeter());
//	
//	s = new Rectangle(34.5,42.7);
//	System.out.println("면적 : "+s.area());
//	System.out.println("둘레 : "+s.perimeter());
//	
//	
//	
//	
//	
//	}
//	
	
	
	
	public void calcShapeArray() {
		
		
		IShape[] iarr = new IShape[5];
		
		iarr[0] = new Circle(15);
		iarr[1] = new Circle(13);
		iarr[2] = new Rectangle(27,26);
		iarr[3] = new Rectangle(20,17);
		iarr[4] = new Triangle(10,5);
		
		for(int i = 0; i <5; i++) {
			System.out.println("면적 : " + iarr[i].area());
			System.out.println("둘레 : " +iarr[i].perimeter());
			if(iarr[i] instanceof Triangle) {
				System.out.println("빗변의 길이 : "+((Triangle)iarr[i]).getHypotenuse());
			}

		}
		
		
		
		
		
		
	}
	
	
	
	
	
}
