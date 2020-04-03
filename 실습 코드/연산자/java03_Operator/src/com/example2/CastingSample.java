package com.example2;

import java.util.Scanner;

public class CastingSample {

	public void printUnicode() {
		
		Scanner sc = new Scanner(System.in);
		char sc1;
		int sc2;
		
		
		System.out.print("문자하나를 입력하시오: ");
		sc1 = sc.next().charAt(0);
		sc2 = (int)sc1;
	
		System.out.println(sc1 + " is unicode: "+ sc2);
		
		
	}



	public void calculatorScore() {
		
		Scanner sc = new Scanner(System.in);
		int kor, math, eng;
		System.out.print("국어 성적을 입력하시오: ");
		kor = (int)(sc.nextDouble());
		
		System.out.print("영어 성적을 입력하시오: ");
		eng = (int)(sc.nextDouble());
		
		System.out.print("수학 성적을 입력하시오: ");
		math = (int)(sc.nextDouble());
		
		System.out.println("세 과목의 총점은 " + (kor + eng + math) + " 이며, 평균은 " + (kor + eng + math)/3 + " 입니다.");
		
		
		
		
	}


	
	
	
	
	
}

	