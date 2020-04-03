package com.test01;

import java.util.Scanner;

public class ForTest01 {
	public static void main(String[] args) {
		
//		ForTest01.testFor();
//		ForTest01.testFor2();
//		ForTest01.testFor2_2();
//		ForTest01.testFor2_3();
//		ForTest01.testFor3();
		
		ForTest01 ft = new ForTest01();
//		ft.testFor4();
		ft.testFor5();
		
	}
	
	public static void testFor() {
		
		//0 ~ 10 출력
		for(int i = 0; i <= 10; i ++)
		{	System.out.println(i);
		}
	}
	
	public static void testFor2() {
		//1부터 100까지 역순 출력
		for(int i = 100; i >= 1; i--) {
			System.out.println(i);
		}
		//100부터 1까지 역순 출력하되 10단위로 줄바꿈
		for(int i = 100; i >= 1; i--)
		{	System.out.print(i + " ");
					if((i -1)%10 ==0) {
						System.out.print("\n");
					}
					}
		
		
		
	}
	
	public static void testFor2_2() {
		
		//증감식을 2씩 증가
		for(int i =1; i <10; i+=2) {
			System.out.println(i);
		}
	
		//초기식과 증감식은 1개 이상 기입 가능
		for(int i =0, j =10;  i<10 && j>0 ;i++, j--) {
			System.out.println(i+ "번째 i 출력");
			System.out.println(j+ "번째 j 출력");
		}
		
		//int가 아닌 char 초기값 설정
		for(char ch = 'a'; ch <= 'z' ; ch++) {
			System.out.println(ch);
		}
		
		
		
		
	}
	
	public static void testFor2_3() {

		
		
/*	int i = 1;
		while(i <10) {
			System.out.println(i+"번째 반복문 수행!");
			i++;
		}
*/
		// 주석처리된 것을 for문으로 작성!!
		int i = 1;
		for( ; ; ) {		
			System.out.println(i);
			i++;
				if(i ==10) {
					break;
				}
			
		}
		
		
	}

	public static void testFor3() {
		
		//정수를 하나 입력 받아 그 수가 양수 일때만 그 수의 구구단을 출력,
		//양수가 아니면 "반드시 1~9사이의 양수를 입력!!" 이라고 출력
			
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나를 입력하시오(1~9) : ");
		int dan = sc.nextInt();
		
		if(dan>0 && dan >= 1 && dan <= 9) {
						
					for(int i = 1 ; i <= 9; i++) {
							System.out.println(dan*i);
						}
						
	
		} else {
			System.out.println("반드시 1~9사이의 양수 입력!!");
		}
		
		
		
	}
	
	public  void testFor4() {
		//1~100사이 임의의 난수까지 정수들의 합계를 구하여 출력
		//random메소드는 0.000000 ~ 0.999999 까지라서
		// *100하고 int 화 시키면 0 ~ 99까지를 받게된다.
		//그래서 +1하면 1 ~ 100의 범위를 가지게 된다.
		
		//lang패키지는 굳이 import하지않아도 사용가능.
		//대표적인 예 : String
		
		int random = (int)(Math.random()*100);
		int sum = 0;
		
		for(int i = 1; i <= random; i++)
		{
			sum = sum + i;
			
		}
		System.out.println("1부터 " + random + "까지의 정수들의 합계 : " + sum);
		
	}
	
	public void testFor5() {
		
		//정수 두개 입력 후
		//작은 수 ~ 큰 수 까지의 합
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int max;
		int min;
		
		System.out.println("정수 한개를 입력하시오 : ");
		int num1 = sc.nextInt();
		
		System.out.println("나머지 정수 한개를 입력하시오 : ");
		int num2 = sc.nextInt();
		
		if(num1 > num2) {
			 max = num1;
			 min = num2;
		} else if(num1 < num2) {
			max = num2;
			min = num1;
		}else{
				max = num1;
				min = num2;
			}
						
		for (int i = min ; i  <= max; i++) {
			
			sum = sum +i;
			
		}
		System.out.println(min + "에서 " + max + "까지의 정수들의 합 : " + sum);
		
	}
	
}

