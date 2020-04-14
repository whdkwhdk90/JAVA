package com.test01;

import java.util.Scanner;

public class ForTest01 {

	public static void main(String[] args) {
		
		//ForTest01.testFor();
		//ForTest01.testFor2();
		//ForTest01.testFor2_2();
		//ForTest01.testFor2_3();
		//ForTest01.testFor3();
		ForTest01 ft01= new ForTest01();
		//ft01.testFor4();
		ft01.testFor5();
		
	}
	
	
	public static void testFor() {
		
		//0~10 출력
		
		for(int i=0; i<=10 ; i++) {
		
			//System.out.println(i+" 번째 출력");
			System.out.println("i= "+i);
		}

	}
	
	public static void testFor2() {
		//1~100 역순으로 출력
		
		for(int i=100;i>=1;i--) {
			if(i%10==0) {
				System.out.println();
			}
			//System.out.println("i= "+i);
			System.out.print(i+" ");
//			if(i%10==1) {
//				System.out.println();
//			}
		}
		
		
	}
	
	public static void testFor2_2() {
		
		//증감식을 2씩 증가
//		for(int i=1;i<10;i+=2) {
//			System.out.println(i+" 번째 출력");
//		}
//		System.out.println("==================");
//		//초기식과 증감식은 1개 이상 기입 가능
//		for(int i=0,j=10;i<10 && j>0;i++,j--) {
//			System.out.println(i+"번째 i 출력");
//			System.out.println(j+"번째 j 출력");
//
//		}
//		
//		System.out.println("==================");
		//int가 아닌 char 초기값 설정
		for(char ch='a';ch<='z';ch++) {
			System.out.println(ch);
		}
		
	}
	
	public static void testFor2_3() {
		
//		int i=0;
//		while( i<10 ) {
//			
//			System.out.println(i+"번째 반복문 수행!");
//			i++;
//			
//		}
		
		//위와 형식이 같게 for문으로 구현할것임.
		int i=1;
		for(;;) {
			System.out.print(i+" ");
			i++;
			if(i==10) {
				break;
			}
		}
	}

	public static void testFor3() {
		
		//정수를 하나 입력 받아 그 수가 양수 일때만 그 수의 구구단을 출력,
		//양수가 아니면 "반드시 1~9 사이의 양수를 입력!!"이라고 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1~9까지의 양수를 하나 입력하세요: ");
		int dan = sc.nextInt();
		
		if(dan>0 && dan>=1 && dan<=9) { // dan>0 (생략가능)
			for(int su=1;su<10;su++) {
				System.out.println(dan+" * "+su+" = "+(dan*su));
			}
		}else {
			System.out.println("반드시 1~9 사이의 양수를 입력!!");
		}
		
	}
	
	public void testFor4() {
		
		//1~100사이 임의의 난수까지 정수들의 합계를 구하여 출력
		
		int random = (int)(Math.random()*100) + 1;
		int sum=0;
		for(int i=0; i<=random;i++) {
			
			sum+=i;			
		}
		System.out.println("1부터 "+random+"까지의 정수들의 합계: "+sum);

	}
	
	public void testFor5() {
		
		//정수 두개 입력후
		//작은수 ~ 큰수 까지의 합
		
		Scanner sc = new Scanner(System.in);
		int sum=0;
		int max;
		int min;
		
		System.out.print("정수1 입력: ");
		int num1 = sc.nextInt();
		System.out.print("정수2 입력: ");
		int num2 = sc.nextInt();
		
//		max = Math.max(num1, num2);
//		min = Math.min(num1, num2);
		
		if(num1>num2) {
			max=num1;
			min=num2;
		}else {
			max=num2;
			min=num1;
		}
		
		for(int i=min;i<=max;i++) {
			
			sum+=i;	
			
		}
		System.out.println(min+"에서  "+max+"까지의 정수들의 합: "+sum);		
				
				
	}

}
