package com.inherit.part01_inherit.model.vo;

import java.util.Date;

public class Run {

	public static void main(String[] args) {
		Television t = new Television("삼성","03","T-123","삼성TV",5000000, new Date(), 46);
			System.out.println(t.prnInfo());	
	
		   Desktop d = new Desktop("삼성", "03", "S-0122","매직스테이션2",1000000, new Date(), "intel", 500, 8, "window7", false);
		    System.out.println(d.prnInfo());	
	
		    SmartPhone s = new SmartPhone("애플","12","I-333","아이폰8플러스",960000,new Date(), "a12",256,6,"IOS","KT");
		    System.out.println(s.prninfo());
	
		    System.out.println(s.getBrand());
	
	}
	
		
	
			
	
}
