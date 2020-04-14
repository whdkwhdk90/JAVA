package com.poly.test.test06;

import java.util.Scanner;

public class Circle extends Areaimpl{


	@Override
	public void make() {
		Scanner sc = new Scanner(System.in);
		System.out.print("반지름을 입력해 주세요 : ");
		int r = sc.nextInt();
		
		double res = r*r*Math.PI;
		setRes(String.format("%f", res));
							//실수값을 문자열로 변경					
	}

	@Override
	public void print() {
		System.out.print("원의 ");
		super.print();
	}
	
	
}
