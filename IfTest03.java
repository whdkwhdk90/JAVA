package com.test01;

import java.util.Scanner;

public class IfTest03 {
	public void test() {
		//if, else if 구문은 다중 조건을 줄 수 있는 문법
		
		int i =10, j =20;
		
		if( i > j) {
			System.out.println(i + "은 " + j + "보다 큽니다.");
		} else if ( i == j) {
			System.out.println(i + "은 " + j + "와 같습니다.");
		} else {
			System.out.println(i + "은 " + j + "보다 작습니다.");
		}
		
	}
	
	
	public void testIfElseIf() {
		//정수를 하나 입력받아 등급을 나누어 점수와 등급을 출력
		// 90점 이상 = A, 80점이상 90점미만 = B, 70점이상 80점미만 = C, 60점 이상 70점 미만 = D, 60점 미만 =F
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수를 입력하시오: ");
		short num = sc.nextShort();
		char grade;
		if( num >= 90) {
			grade = 'A';
			
		} else if( num >= 80 && num < 90) {
			grade = 'B';
			
		} else if( num >= 70 && num < 80) {
			grade = 'C';
			
		} else if( num >= 60 && num < 70) {
			grade = 'D';
			
		} else {
			grade = 'F';	
		}
		System.out.printf("당신의 점수는 %d 이고, 등급은 %c입니다. \n", num, grade);
		System.out.println("점수 : " +num + ", 등급 : " + grade);
		
	}
	
	/* 포맷문자
	 * 
	 *printf에 관한 포맷문자!!!!
		%d : 정수
		%o : 8진수
 		%x : 16진수
		%f : 실수
		%c : 문자
		%s : 문자열
		%b : 논리형
		
		%5d :5칸을 확보하고 오른쪽 정렬
		%-5d : 5칸을 확보하고 왼쪽정렬
		%.2f : 소수점2자리 까지만 표현
		
	*/
	
	public void testIfElseIf2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하시오: ");
		int point = sc.nextInt();
		String grade = " "; //a+같이 +도 붙일꺼라서 문자열로 함
		
		if(point >= 90) {
			grade = "A";
					if( point >= 95) {
						grade += "+";
					}
					
		} else if(point >= 80) {
			grade = "B";
					if(point >= 85) {
						grade += "+";
					}
					
		} else if(point >= 70) {
			grade = "C";
					if(point >= 75) {
						grade += "+";
					}
					
		} else if(point >= 60) {
			grade = "D";
					if(point >= 65) {
						grade += "+";
					}
					
		}else {
			grade = "F";
		}
		
		System.out.printf("점수는 \t %-7d 이고, \n 등급은 %s 입니다.", point, grade);
		
	}
	
/* 
 * 		특수문자(escape 문자)
 * 		tab : \t  정해진 공간만큼 띄어쓰기
 * 		newLine : \n		출력을 하고 다음라인으로 옮김, ==줄바꿈
 * 		역슬레시 : \\   특수문자(\) 사용
 * 		작은따옴표 : \' 
 * 		큰따옴표 : \"
 * 
 */
	
	
	
}
