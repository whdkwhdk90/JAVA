package com.test01;

import java.util.Scanner;

public class IfTest01 {

	public void testif() {
		
		//if문
		//조건식의 결과 값이 참이면 { } 안에 있는 코드 실행, 
		//조건식의 결과 값이 거짓이면 { } 안에 있는 코드 무시하고 넘어감.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 한개 입력: ");
		int num = sc.nextInt();
		
		//짝수인지 조건을 확인.
		if(num%2==0) {
			//결과가 참일때 수행.
			System.out.println("입력한 숫자는 짝수 입니다.");
		}
		//짝수가 아닌 조건을 확인
		if(num%2 !=0) {
			System.out.println("입력한 숫자는 홀수 입니다.");
		}
		
		System.out.println("프로그램 종료");
		
	}
	
}
