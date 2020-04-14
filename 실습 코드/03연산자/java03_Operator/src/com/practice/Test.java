package com.practice;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Test test = new Test();
		//test.sample1();
		//test.sample2();
		//test.sample3();
		//test.sample4();
	}
	
	
	public void sample1() {
		
		//[연습문제1]
		int kor, eng, math, sum;
		double avg;
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("국어: ");
		kor=sc.nextInt();
		System.out.print("영어: ");
		eng=sc.nextInt();
		System.out.print("수학: ");
		math=sc.nextInt();
		
		sum = kor+eng+math;
		avg = sum/3.0;
		
		//System.out.println("합격 여부: "+ (kor>=40?(eng>=40?(math>=40?(avg>=60?"합격":"불합격"):"불합격"):"불합격"):"불합격" ));
		System.out.println("합격 여부: "+(kor>=40&&eng>=40&&math>=40&&avg>=60?"합격":"불합격"));
	}
	public void sample2() {
		//[연습문제2]	
		Scanner sc = new Scanner(System.in);
		String name;
		int hac, ban, num;
		char gen;
		double num2;
		
		System.out.print("이름: ");
		name = sc.next();
		System.out.print("학년: ");
		hac = sc.nextInt();
		System.out.print("반: ");
		ban = sc.nextInt();
		System.out.print("번호: ");
		num = sc.nextInt();
		System.out.print("성별: ");
		gen = sc.next().charAt(0);
		System.out.print("성적(소수점 둘째자리까지 입력): ");
		num2 = sc.nextDouble();
		
		String str = (gen=='M'||gen=='m'?"남학생 ":"여학생 ");
		
		System.out.println(hac+"학년 "+ban+"반 "+num+"번 "+str+" "+name+"은 성적이 "+num2+"이다.");
		
		
		
		//System.out.printf("%d학년 %d반 %d번 %s %s은 성적이  %.2f이다. ", hac,ban,num,(gen=='M'||gen=='m'?"남학생 ":"여학생 "),name,num2);
			
	}
	public void sample3() {
		//[연습문제3]
		int a;
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력: ");
		a= sc.nextInt();
		System.out.println("입력 받은 정수는 "+(a>0?"양수다.":"양수가 아니다."));
		
	}
	public void sample4() {
		//[연습문제4]
		int a;
		String res;
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력: ");
		a=sc.nextInt();
		res=(a%2==0?"짝수다.":"홀수다.");
		
		System.out.println(res);
		
	}
	
	
}
