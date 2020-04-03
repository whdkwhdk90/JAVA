package com.test01;

import java.util.Scanner;

public class Operator06 {
	public static void main(String[] args) {
		
	Operator06 op = new Operator06();
	op.opTest();
		
	}
	
	
	//삼항연산자
	//(조건식)? 참일때 : 거짓일때 ; - 조건식이 true아니면 false형식으로 나와야 작동이 됨!!
	
	
	public void opTest() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력 : ");
		int num = sc.nextInt();
		
		String res = (num >0)?"양수다":( (num == 0)? "0이다" : "음수다") ; //삼항연산자는 문자열??인듯??
		//삼항연산자 안에 또 삼항연산자를 설치
		System.out.println(res);
		
		
	}
	
	
}
