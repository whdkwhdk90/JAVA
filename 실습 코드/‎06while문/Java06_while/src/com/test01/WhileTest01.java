package com.test01;

import java.util.Scanner;

public class WhileTest01 {

	public static void main(String[] args) {
		
		//WhileTest01.testWhile();  //클래스명.메소드명 (단, static 선언이 된 경우만 가능)
		//WhileTest01.testWhile2();
		//WhileTest01.testWhile3();
		//WhileTest01.testWhile4();
		WhileTest01.testWhile4_2();
		
	}
	
	public static void testWhile() {
		
		int i=1;
		while( i<10 ) {
			
			System.out.println(i+"번째 반복문 수행!");
			i++;
			
		}
		System.out.println("while이 종료된 후 i의 값: "+i);		
		
		
	}
	public static void testWhile2() {
		
		//문자열을 입력받아 인덱스 별로 문자를 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 입력: ");
		String str=sc.next();
		
//		System.out.println(str.charAt(0));
//		System.out.println(str.charAt(1));
//		System.out.println(str.charAt(2));
//		System.out.println(str.charAt(3));
//		System.out.println(str.charAt(4));
		
		int  i=0;
		//apple : 길이 5
		while(i<str.length()) {
			char ch = str.charAt(i);
			System.out.println(i+" : "+ch);
			i++;
		}
		
	}
	public static void testWhile3() {
		//1부터 입력받은 수 까지 정수들의 합
		//ex) 1+2+3+4+5
		
		int sum=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력: ");
		int num=sc.nextInt();
		
		int i=1;
		while(i<=num) {
			sum=sum+i;
			i++;		
		}
		System.out.println("sum: "+sum);

	}
	public static void testWhile4() {
		
		int i = 1;
		while(true) {
			System.out.println(i);
			i++;
			
			if(i==10) {
				break;
			}
			
		}
		
		
	}
	public static void testWhile4_2() {
		//키보드로 4를 입력 받을때 까지 반복,
		//4가 입력되면 while문 종료
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("숫자 입력: ");
			int i = sc.nextInt();
			
			if(i==4) {
				System.out.println("4입력!! 종료!!");
				break;
			}
			
		}

	}
	
	
	
	
	
	
	
}
