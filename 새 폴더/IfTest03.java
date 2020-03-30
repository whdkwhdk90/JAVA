package com.test01;

import java.util.Scanner;

public class IfTest03 {
	public void test() {
		//if, else if 구문은 다중 조건을 줄 수 있는 문법
		
		int i =10, j =20;
		
		if( i > j) {
			System.out.println(i + "은 " + j + "보다 큽니다.");
		} else if ( i == j) {
			System.out.println(i + "은 " + j + "와 같습니다.");
		} else {
			System.out.println(i + "은 " + j + "보다 작습니다.");
		}
		
	}
	
	
	public void testIfElseIf() {
		//정수를 하나 입력받아 등급을 나누어 점수와 등급을 출력
		// 90점 이상 = A, 80점이상 90점미만 = B, 70점이상 80점미만 = C, 60점 이상 70점 미만 = D, 60점 미만 =F
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수를 입력하시오: ");
		short num = sc.nextShort();
		char grade;
		if( num >= 90) {
			grade = 'A';
			
		} else if( num >= 80 && num < 90) {
			grade = 'B';
			
		} else if( num >= 70 && num < 80) {
			grade = 'C';
			
		} else if( num >= 60 && num < 70) {
			grade = 'D';
			
		} else {
			grade = 'F';	
		}
		System.out.printf("당신의 점수는 %d 이고, 등급은 %c입니다. \n", num, grade);
		System.out.println("점수 : " +num + ", 등급 : " + grade);
		
	}
	
	
}
