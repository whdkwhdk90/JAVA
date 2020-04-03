package com.test01;

import java.util.Scanner;

public class WhileTest03 {
	public static void main(String[] args) {
	
		WhileTest03.prn01();
//		WhileTest03.prn02();
//		WhileTest03.prn03();
		
	}
	
	public static void prn01(){
		// 1. 1~100까지의 숫자를 역순으로 출력
		
		Scanner sc = new Scanner(System.in);
		int i = 0;   // i = 100부터 시작해서 감소 시켜도 됨!!!!
		
		System.out.print("숫자를 입력하시오 : ");
		int num = sc.nextInt();
		
		while( i < num ) {
			System.out.println(num-i);
			i++;
			
			/* int i =100;
			* while(i >0 ){
		    *System.out.println(i);	
		    *  i--;
		    }    */
			
			
		}
		
		
	}
	
	public static void prn02(){
		// 2.  1 ~100까지의 숫자 중, 2의 배수만 출력
		
		Scanner sc = new Scanner(System.in);
		int i = 1;
		
		System.out.print("숫자를 입력하시오 : ");
		int num = sc.nextInt();
		
		while( i <= num )
		{
				if(i%2== 0) {
						System.out.println(i);
				}
			i++;
		}
		
		
	}
	
	public static void prn03(){
		// 3. 1 ~ 100까지의 숫자 중 , 7의 배수의 갯수와 총 합을 출력
		
		Scanner sc = new Scanner(System.in);
		int i = 1;
		int sum = 0;
		int count = 0;
		System.out.print("숫자를 입력하시오 : ");
		int num = sc.nextInt();
		
		while( i <= num ) {
			if(i%7==0) {
				sum = sum + i;
				count ++;
			}
			i++;
		}
		System.out.println("7의배수 갯수: " +count + ",총 합 : " + sum);
		
	}
	
	
}
