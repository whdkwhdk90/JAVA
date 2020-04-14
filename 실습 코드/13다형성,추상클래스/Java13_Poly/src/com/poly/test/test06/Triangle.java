package com.poly.test.test06;

import java.util.Scanner;

public class Triangle extends Areaimpl{

	
	@Override
	public void make() {
		Scanner sc = new Scanner(System.in);
		System.out.print("밑변 입력 : ");
		int x = sc.nextInt();
		System.out.print("높이 입력 : ");
		int y = sc.nextInt();
		
		
		double res = (double)x*y/2;
		setRes(String.format("삼각형의 면적 : %f", res));
		
	}

	
	
	
	
	
}
