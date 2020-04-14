package com.test01;

import java.util.Scanner;

public class Operator01 {

	public static void main(String[] args) {
		
		Operator01.testMethod();
		
		
	}
	
	public static void testMethod() {
		System.out.println("true의 부정: "+ !true);
		System.out.println("false의 부정: "+ !false);
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 하나 입력: ");
		int no = sc.nextInt();
		
		System.out.println("입력한 정수가 짝수? "+ ( no%2==0?"짝수":"홀수") );
		System.out.println("입력한 정수가 양수? "+ ( !(no<0) ));   //no<0?"음수":"양수"
		
		
	}
	
	
	
	
	
}
