package com.silsub2.point.main;

import com.silsub2.point.model.vo.Circle;
import com.silsub2.point.model.vo.Rectangle;

public class Main {

	public static void main(String[] args) {
		
		Circle cc1 = new Circle(4,4,3);
		Circle cc2 = new Circle(3,3,2);
		Circle cc3 = new Circle(5,5,2);

		cc1.draw();
		cc2.draw();
		cc3.draw();
		System.out.println();
		
		Rectangle rt1 = new Rectangle(4,4,3,3);
		Rectangle rt2 = new Rectangle(5,5,2,5);
		Rectangle rt3 = new Rectangle(6,6,7,7);
		
		rt1.draw();
		rt2.draw();
		rt3.draw();
		
		
		
		
		
		
	}

}
