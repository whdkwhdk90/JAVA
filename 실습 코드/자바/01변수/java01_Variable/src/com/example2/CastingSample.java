package com.example2;

import java.util.Scanner;

public class CastingSample {

	public void printUniCode() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 하나를 입력하시오 : ");
		char ch = sc.next().charAt(0);
		System.out.println((int)ch);
	}
	
	public void calculatorScore() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 성적을 입력하시오 : ");
		double kor = sc.nextDouble();
		System.out.print("영어 성적을 입력하시오 : ");
		double eng = sc.nextDouble();
		System.out.print("수학 성적을 입력하시오 : ");
		double mat = sc.nextDouble();
		
		System.out.println("총점 : "+ (int)(kor+eng+mat));
		System.out.println("평균 : "+(int)((kor+eng+mat)/3));
		
		
	}
	
	
	
}
