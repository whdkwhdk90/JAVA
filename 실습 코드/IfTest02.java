package com.test01;

import java.util.Scanner;

public class IfTest02 {
	
	
	public void test() {
		int i = 20;
		
		if(i<10) {
			System.out.println(i+ "은 10보다 작습니다.");	
		}
		
		else {
			System.out.println(i + "은 10보다 크거나 같습니다");
		}
		
	} 
	
	public void testIfElse() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하시오: ");
		int num = sc.nextInt();
		
		if ( num%2 ==0) {
			System.out.println("입력하신 정수는 짝수입니다.");
		}else {
			System.out.println("입력하신 정수는 홀수입니다.");
		}
		
		
	}

	public void testIfElse2_1() {
		//50보다 큰 수라면 "50보다 큰 수 "   ㅡㅡ> 50보다 큰 수라면 홀수인지 짝수인지 출력
		//50보다 작은 수라면 "50보다 작은 수"라고 출력
		
		Scanner sc= new Scanner(System.in);
		
		System.out.print("정수를 입력하시오: ");
		int num = sc.nextInt();
		
		if (num >= 50) {
			if(num%2 ==0) {
				System.out.println("입력하신 정수는 50보다 크거나 같으면서 짝수입니다.");
			}else {
				System.out.println("입력하신 정수는 50보다 크거나 같으면서 홀수입니다.");
			}
			
		}else {
			System.out.println("입력하신 정수는 50보다 작은 수 입니다.");
		}
		
		
	}
	
	public void testIfElse2_2() {
		//숫자를 하나 입력 받아 양수인지 음수인지 출력
		//단, 0이면 "0입니다"라고 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하시오 : ");
		int num = sc.nextInt();
		
		if( num != 0 )
		{
			if(num > 0)	{	System.out.println("입력하신 숫자는 양수입니다.");
			}
		
		else {
			System.out.println("입력하신 숫자는 음수입니다.");
		}
			
		}
		else {
			System.out.println("입력하신 숫자는 0입니다.");
		}
		
			
		
		
	}

	public void testIfElse3() {
		//정수 두개를 입력받아, 두 수의 산술연산을 처리해서 출력하세요.
		// 단, 두 수 모두 반드시 1~ 100사이의 값이어야함
		//입력받은 두개의 숫자 중 하나라도 범위에 속하지 않으면
		// "값은 1부터 100사이어야합니다." 라고 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 값 하나를 입력하시오 : ");
		short a = sc.nextShort();
		System.out.print("나머지 하나 입력하시오 : ");
		short b= sc.nextShort();
		
		if( ( a>=1 && a<= 100)  && (b >=1 && b <= 100)  )   //굳이 true안해도 들어감. true가 되기만하면 if문 들어갈 수 있나??
		{
			System.out.println("두 수의 덧셈의 값 : " + (a+b));
			System.out.println("두 수의 뺄셈의 값 : " + (a-b));
			System.out.println("두 수의 곱셈의 값 : " + (a*b));
			System.out.println("두 수의 나눗셈의 값 : " + (a/b));
			System.out.println("두 수의 나눗셈의 나머지의 값 : " + (a%b));
		}
		else {
			System.out.println("두 수 모두 1부터 100사이어야 합니다.");
		}
		
	}




}
