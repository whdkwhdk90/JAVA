package com.test01;

import java.util.Scanner;

public class ForTest02 {
	public static void main(String[] args) {
		
//		ForTest02.testFor1();
//		ForTest02.testFor2();
//		ForTest02.testFor3();
//		ForTest02.testFor4();
		ForTest02.testFor5();
	}
	
	public static void testFor1() {
		
		for(int i = 0; i <10; i++) {
			
							for(int j=0; j<10; j++) {
								
										System.out.println("i : " + i + " j : " +j);
							}
						System.out.println();
							
		}
		
		
	}
	
	public static void testFor2() {
		//구구단 2단부터 9단까지 출력
		
		for(int dan = 2; dan <= 9; dan++) {
					for(int num = 1; num <= 9; num++) {
						System.out.print(dan + " * "+num +" = " + (dan* num) );
				
						
						System.out.println();
					}
					
					
		}
		
	}
	
	public static void testFor3() {
		for(int hour = 0; hour < 24; hour++) {
			for(int min = 0; min < 60 ; min++) {
			
				System.out.println(hour + "시 " + min + "분");
		
			}
	
		}

	}
	
	public static void testFor4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("출력할 줄 수 : ");
		int row = sc.nextInt();
	for(int j = 1; j <=row; j++) {	
		for(int i = 1; i <6;  i++) {
			System.out.print("*");
			
		}
		System.out.println();
	}
		
		/* 3을 입력하면 3줄에 
		 *별 5개씩 찍기
		 * *****
		 * *****
		 * *****
		   
		 
		*/
		
		
		
	}

	public static void testFor5() {
		/* 한 줄에 별표문자를 입력된 줄수와 칸수 만큼 출력
		 * 
		 * 1*****
		 * *2****
		 * **3***
		 * ***4**
		 * ****5*
		 * *****6
		 */
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i = 1; i <= num; i++)
		{
			
				for(int j = 1; j <= num; j++)
					{
					
								if(i==j) {
									System.out.print(i);
								}else {
									System.out.print("*");
								}
								
					}
				
				
			System.out.println();
		}
					

		
				} 
			
			
	
	
	
	
		}
			
		
		
		
	
	

