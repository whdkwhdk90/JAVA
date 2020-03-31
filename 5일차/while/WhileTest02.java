package com.test01;

import java.util.Scanner;

public class WhileTest02 {
	public static void main(String[] args) {
		
		//WhileTest02.testDoWhile();
	   // WhileTest02.testDoWhile2();
		   WhileTest02.testDoWhile3();
		   
		   
	}
	
	public static void testDoWhile() {
		int i = 9; //do 조건은 일단 한번 실행 됨. 그다음 조건식이랑 비교 !!
		
		do {
			System.out.println(i);
			i++;
		}while(i < 10);
	}
	
	public static void testDoWhile2() {
		
		Scanner sc = new Scanner(System.in);
		
		String str = null;
		
		do {
			System.out.print("문자열 입력 : ");
			str = sc.next();
			System.out.println("str : " +str);
			//exit가 입력되면 반복문 종료
		}while(!str.equals("exit")); //문자열끼린 비교를 못함 !!!!!!
		// equals는 exit라는 단어가 들어왔을때 true값을 반환. (우리가 원하는건
		// exit가 나오지 않았을때 돌아가는것을 원하기때문에 !를 붙여줌.)
		
	}
	
	public static void testDoWhile3() {
		
		Scanner sc = new Scanner(System.in);
		String str = null;
		
		do {
			System.out.print("문자열을 입력하시오 : ");
			str = sc.next();
			
				if(str.equals("exit")) {
					System.out.println("종료!!");
					break;
				} System.out.println("str : " + str);
			
		}while(true);
		
	}
	
	
	
	
	
}
