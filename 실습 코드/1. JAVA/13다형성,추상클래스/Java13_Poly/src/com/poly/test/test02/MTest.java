package com.poly.test.test02;

import java.util.Scanner;

public class MTest {

	public static void main(String[] args) {
		System.out.print("선택해 주세요[1: 고양이 2:멍멍이 3:송아지] :");

	

	Scanner sc = new Scanner(System.in);
	
	int select = sc.nextInt();
	
	Base base = null;
	
	switch(select) {
	
	case 1:
		base = new Cat();
		break;
	case 2:
		base = new Dog();
		break;
	case 3:
		base = new Cow();
		break;
	default:
	}
	base.start();
	base.stop();
	/*
	 * 동적 바인딩 - 실행시 메소드를 동적으로 연동하는 방식
	 */
	
	
	
	
	}	
	
}
