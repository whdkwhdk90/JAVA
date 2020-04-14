package com.test01;

import java.util.Scanner;

public class IfTest03 {

	//if else if 구문은 다중 조건을 줄 수 있는 문법.
	
	
	public void test() {
		
		int i = 10, j =20;
		if(i>j) {
			System.out.println(i +"은 "+j+" 보다 큽니다.");		
		}else if(i==j) {
			System.out.println(i +"은 "+j+" 와 같습니다.");
		}else {
			System.out.println(i +"은 "+j+" 보다 작습니다.");
		}
		
	}
	public void testIfElseIf() {
		
		//점수를 하나 입력받아 등급을 나누어 점수와 등급을 출력
		//90점 이상은 A등급
		//90점 미만 80점 이상은 B등급
		//80점 미만 70점 이상은 C등급
		//70점 미만 60점 이상은 D등급
		//60점 미만은 F등급으로 나눈다.
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 입력: ");
		int point = sc.nextInt();
		char grade=' ';
		
		if(point >=90) {
			grade='A';
		}else if(point<90 && point>=80) {
			grade='B';
		}else if(point<80 && point>=70) {
			grade='C';
		}else if(point<70 && point>=60) {
			grade='D';
		}else {
			grade='F';
		}
		
		
		System.out.printf("당신의 점수는 %d 이고, 등급은 %c입니다. ", point,grade);
		
		
		
		
	}
	/*포맷문자
	 * %d : 정수
	 * %o : 8진수
	 * %x : 16진수
	 * %f : 실수
	 * %c : 문자
	 * %s : 문자열
	 * %b : 논리형
	 * 
	 * %5d : 5칸을 확보하고 오른쪽 정렬
	 * %-5d : 5칸을 확보하고 왼쪽 정렬
	 * %.2f : 소수점 아래 2자리까지만 표현
	 */
	public void testIfElseIf2() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요: ");
		int point = sc.nextInt();
		String grade=""; //"a+"
		
		if(point>=90) {
			grade="A";
			if(point>=95) {
				grade+="+";
				//grade = grade + "+";
			}
		}else if(point>=80) {
			grade="B";
			if(point>=85) {
				grade+="+";
			}
		}else if(point>=70) {
			grade="C";
			if(point>=75) {
				grade+="+";
			}
		}else if(point>=60) {
			grade="D";
			if(point>=65) {
				grade+="+";
			}
		}else {
			grade="F";
		}
		
		System.out.printf("당신의 \t점수는 %-7d이고, \n 등급은 %s입니다.",point,grade);
		
	}
	/*
	 * 특수문자
	 * tab : \t 	  정해진 공간만큼 띄어쓰기
	 * newLine : \n  출력을 하고 다음 라인으로 옮김, 줄바꿈
	 * 역슬래쉬 : \\	  특수문자(\) 사용
	 * 작은따옴표 : \' 	 
	 * 큰따옴표 : \"
	 */
	
	
	
	
	
	
	
	
}
