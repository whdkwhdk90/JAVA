package com.test01;

import java.util.Scanner;

public class ForTest02 {

	public static void main(String[] args) {
		
		//ForTest02.testFor1();
		//ForTest02.testFor2();
		//ForTest02.testFor3();
		//ForTest02.testFor4();
		ForTest02.testFor5();
		
	}
	
	public static void testFor1() {
		
		for(int i=0;i<10;i++) {
			
			for (int j=0;j<10;j++) {
				
				System.out.println("i= "+i+", j= "+j);
				
			}
			System.out.println();
		}
		

	}
	
	public static void testFor2() {
		
		//구구단 2단부터 9단 까지 출력
		
		for(int dan=2;dan<10;dan++) {
			for(int su=1;su<10;su++) {
				System.out.println(dan+" * "+su+" = "+(dan*su));
			}
			System.out.println();
		}
	}
	
	public static void testFor3() {
		
		for(int hour=0; hour < 24; hour++) {
			for(int min = 0; min<60 ; min++) {
				System.out.println(hour+"시 "+min+"분");
			}
		}
	}

	public static void testFor4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("출력할 줄 수: ");
		int row = sc.nextInt();
		/* (3입력시)이런 형식의 출력 값을 구현할 것임.
		 	*****
		 	*****
		 	*****  
		 */
		
		for(int r=1;r<=row;r++) {
			for(int c=1;c<=5;c++) {
				System.out.print("*");
			}
			System.out.println();			
		}
		
	}
	public static void testFor5() {
		
		/*한 줄에 별표문자를 입력된 줄수와 칸수 만큼 출력
		
			1*****
			*2****
			**3***
			***4**
			****5*
			*****6
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("줄 수: ");
		int row =sc.nextInt();
		System.out.print("칸 수: ");
		int col =sc.nextInt();
		
		for(int r=1;r<=row;r++) {
			for(int c=1;c<=col;c++) {
				if(r==c) {
					System.out.print(r);
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		
		
	}
	
	
	
	
	
	
	
}
