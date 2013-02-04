package com.test01;

import java.util.Scanner;

public class IfTest02 {

	//if ~ else
	//둘 중 한 개를 선택하는 조건문, 조건이 참인 경우와 거짓인 경우에 수행하는 
	//명령을 따로 작성하는 경우 사용
	
	public void test() {
		
		int i = 3;
		
		if(i<10) {
			System.out.println(i+" 은 10 보다 작습니다.");
		}else {
			System.out.println(i+" 은 10 보다 크거나 같습니다.");
		}

	}
	public void testIfElse() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력: ");
		int num=sc.nextInt();
		
		if(num%2==0) {
			System.out.println("입력한 정수는 짝수!");
		}else {
			System.out.println("입력한 정수는 홀수!");
		}
		
		
	}
	public void testIfElse2_1() {
		
		//50보다 큰 수라면 짝수인지, 홀수 인지 출력
		//50보다 작은 수라면 "50보다 작은수" 라고 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("0보다 큰 정수 입력: ");
		int no = sc.nextInt();
		
		if(no>=50) {
			if(no%2==0) {
				System.out.println("50 보다 크면서 짝수이다.");
			}else {
				System.out.println("50 보다 크면서 홀수이다.");
			}
		}else {
			System.out.println("50 보다 작은 수");
		}
		
		
	}
	public void testIfElse2_2() {
		
		//숫자를 하나 입력 받아 양수인지 음수인지 출력
		//단, 0이면 "0입니다."라고 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력: ");
		int num =sc.nextInt();
		
		if(num !=0) {
			if(num>0) {
				System.out.println("양수입니다.");
			}else {
				System.out.println("음수입니다.");
			}
		}else {
			System.out.println("0입니다.");
		}
		
	}
	public void testIfElse3() {
		//정수 두개를 입력받아, 두수의 산술 연산을 처리해서 출력하세요.
		//단, 두 수 모두 반드시 1~100사이의 값이어야함.
		//입력 받은 두개의 숫자중 하나라도 범위에 속하지 않으면 
		//"값은 1부터 100사이어야 합니다."라고 출력.
		
		
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		System.out.print("첫번째 정수 입력: ");
		num1=sc.nextInt();
		System.out.print("두번째 정수 입력: ");
		num2=sc.nextInt();
		
//		if((num1>=1&&num1<=100)&&(num2>=1&&num2<=100)) {
//			System.out.println("두 수의 합 = "+ (num1+num2));
//			System.out.println("두 수의 차 = "+ (num1-num2));
//			System.out.println("두 수의 곱 = "+ (num1*num2));
//			System.out.println("두 수의 나누기 = "+ (num1/num2));
//			System.out.println("두 수의 나머지 = "+ (num1%num2));
//		}else {
//			System.out.println("값은 1부터 100사이어야 합니다.");
//		}
		
		if((num1>=1&&num1<=100)&&(num2>=1&&num2<=100)) {
			System.out.println(num1+"+"+num2+"="+(num1+num2));
			System.out.println(num1+"-"+num2+"="+(num1-num2));
			System.out.println(num1+"*"+num2+"="+(num1*num2));
			System.out.println(num1+"/"+num2+"="+(num1/num2));
			System.out.println(num1+"%"+num2+"="+(num1%num2));
	
		}else {
			System.out.println("두 수 모두 1~100사이의 값이어야 합니다.");
		}
		
		
		
		
	}
	
	
	
	
	
	
}
