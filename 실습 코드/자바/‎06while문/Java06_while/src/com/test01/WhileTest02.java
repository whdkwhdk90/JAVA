package com.test01;

import java.util.Scanner;

public class WhileTest02 {

	public static void main(String[] args) {
		
		
		//WhileTest02.testDoWhile();
		//WhileTest02.testDoWhile2();
		WhileTest02.testDoWhile3();
		
	}
	
	public static void testDoWhile() {
		
		int i = 1;
		
		do {
			System.out.println(i);
			i++;		
		}while(i<10);
		
		
	}
	public static void testDoWhile2() {
		
		Scanner sc = new Scanner(System.in);
		String str=null;
		
		do {
			System.out.print("문자열 입력: ");
			str = sc.next();
			System.out.println("str: "+str);
			//exit가 입력되면 반복문 종료
			
			
			
		}while(!str.equals("exit"));
		
	}
	
	
	
	public static void testDoWhile3() {
		
		Scanner sc = new Scanner(System.in);
		String str = null;
		
		do {
			System.out.print("문자열 입력: ");
			str = sc.next();
			if(str.equals("exit")) {
				System.out.println("종료!!");
				break;
			}
			System.out.println("str : "+str);
			
			
		}while(true);
		
	}
	
	
	
	
}
