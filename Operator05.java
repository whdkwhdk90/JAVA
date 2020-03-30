package com.test01;

import java.util.Scanner;

public class Operator05 {
	public static void main(String[] args) {
		
	Operator05 op = new Operator05();
	op.opTest1();
	
	}
	
	public void opTest1() {
		//&&(그리고, ~면서)   a && b(둘 다 true여만 true)
		//||(또는, ~거나) a || b   (둘 중 하나만 true여도 true)
		
		Scanner sc = new Scanner(System.in);
		
		// 1 ~100 사이 숫자인지 확인
	    // 1 <= 변수 <=100 (수학에서는)
		//    (1 <= 변수) && (변수 <= 100);   (자바에서는)
		
		System.out.print("정수를 입력하시오: ");
		int num = sc.nextInt();
		
		System.out.println("1부터 100사이 인지 확인: " + (1 <= num &&num <= 100));  //1부터 100 사이의 숫자라면 true, 아니면 false
		
		
		//영어 대문자냐? ㅡㅡ> 'A' <ㅡㅡ 문자변수 && <= 'Z'
		
		System.out.print("문자 하나 입력: ");
		char ch = sc.next().charAt(0);
		
		System.out.println("대문자 인지 확인: "  + (ch >= 'A' && ch <= 'Z') );   //소문자 인지 확인하려면 A대신 a, Z 대신 z 입력하면됨
		
		
		// || : 여러 값을 제시하고 그 중 하나라도 맞는게 있는지 물어 볼 때 사용
		// 입력한 문자가 대소문자 상관없이 'y', 'Y' 인지 물어볼 때
		//문자변수 == 'y' || 문자변수 =='Y'
		
		System.out.print("계속 하시려면 y혹은 Y를 입력하시오 : ");
		char ch2 = sc.next().charAt(0);
		
		System.out.println("영문자 y인지 확인 : " + (ch2 == 'y' || ch2 == 'Y')); //논리값이 들어가야 작동!
		
		
		
		
		
	}
	
	
}
