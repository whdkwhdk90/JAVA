package com.practice;

import java.util.Scanner;

public class Example {

	public void sample1() {
		double avg;
		int math, eng, kor, sum;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수학성적을 입력하시오 : ");
		math = sc.nextInt();
		System.out.print("영어성적을 입력하시오 : ");
		eng = sc.nextInt();
		System.out.print("국어성적을 입력하시오 : ");
		kor = sc.nextInt();
		
		sum = kor + eng + math;
		avg = (sum/3.0);
		  
		String res = (math>=40 && eng >= 40 && kor >= 40 && avg >=60)?   "합격입니다"  :   "불합격입니다";
		
		System.out.println(res);
		
		
	}
	
	public void sample2() {
		
		Scanner sc = new Scanner(System.in);
		
	System.out.print("학생이름 : ");
	String name = sc.next();
	
	System.out.print("학년 : ");
	int grade = sc.nextInt();
	
	System.out.print("반 : ");
	int Class = sc.nextInt();
		
	System.out.print("번호  : ");
	int num  = sc.nextInt();

	System.out.print("성별 : ");
	char ch =sc.next().charAt(0);
	
	String res = (ch == 'M')? "남학생" : "여학생" ;
	
	System.out.print("성적 : ");
	double score =sc.nextDouble();
	
	System.out.println(grade + "학년 "+Class + "반 "+ num + "번 " + res + " " + name + "은(는)  성적이 " + score + "이다.");
	
	
	
	
		
		
		
		
		
	}
	
	public void sample3() {
		
		int num;
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("정수를 입력하시오: " );
		num=sc.nextInt();
		
		String res = (num >0)?  "양수다" : "양수가 아니다" ;
		
		System.out.println(res);
	}
	
	public void sample4() {
		int num;
		String res;
		
		Scanner sc  = new Scanner(System.in);	
		
		System.out.print("정수를 입력하시오 : ");
		num =sc.nextInt();
		
		res = ((num%2) ==0)? "짝수다" : "홀수다" ; 
		
		System.out.println(res);
		
		
	}


}