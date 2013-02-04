package com.test01;

import java.util.Scanner;

public class Operator05 {

	//&&(그리고, ~면서)  a && b
	//||(또는, ~거나)  a || b
	
	public static void main(String[] args) {
		
		
		Operator05 op = new Operator05();
		op.opTest1();
		
		
	}

	public void opTest1() {
		
		Scanner sc = new Scanner(System.in);
		
		//1 ~ 100 사이의 숫자인지 확인
		//1<= 변수 <= 100 이렇게 사용 못함 --> 1<=변수 && 변수 <=100;
		
		System.out.print("정수 하나 입력: ");
		int num = sc.nextInt();
		
		System.out.println("1부터 100사이인지 확인: "+ (1<=num && num<=100));
		
		//영어 대문자냐? --> 'A' <= 문자변수 && 문자변수 <='Z' 
		System.out.print("문자 하나 입력: ");
		char ch = sc.next().charAt(0); //"A" -> 'A' 으로 가지고 오겠다.
		System.out.println("영어 대문자 인지 확인: " + ('A'<=ch && ch<='Z'));
		
		
		// || : 여러 값을 제시하고 그 중 하나라도 맞는게 있는지 물어 볼때 사용.
		// 입력한 문자가 대소문자 상관없이 'y' 'Y' 인지 물어볼때.
		// 문자변수 == 'y' || 문자변수 =='Y'
		System.out.print("계속 하시려면  y 혹은 Y 를 입력하세요: ");
		char ch2 = sc.next().charAt(0);
		System.out.println("영문자 y인지 확인: "+ (ch2=='y'||ch2=='Y'));
		
		
	}
	
	
}
