package com.example;

import java.util.*;

public class Example {

	public void example1() {
		
	Scanner sc = new Scanner(System.in);
	
	System.out.println("첫번째 정수: ");
	int first = sc.nextInt();
	
	System.out.println("두번째 정수: ");
	int second = sc.nextInt();
		
	System.out.println("더하기 결과: "+(first +second));
	System.out.println("빼기 결과: "+(first -second));
	System.out.println("곱하기 결과: "+(first *second));
	System.out.println("나누기 결과: "+(first /second));
	System.out.println("나누기한 나머지 결과: "+(first %second));
	
	/*
		int a = 0,b = 0;
	
		BufferedReader br1 = new BufferedReader(InputStreamReader(System.in));
		System.out.print("첫번째 정수 입력하시오: ");
		
		BufferedReader br2 = new BufferedReader(InputStreamReader(System.in));
		System.out.print("두번째 정수 입력하시오: ");
		
		
		
		try {
			a = br1.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			b = br2.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println("더하기 결과: "+(a+b));
		System.out.println("빼기 결과: "+(a-b));
		System.out.println("곱하기 결과: "+(a*b));
		System.out.println("나누기 결과: "+(a/b));
		System.out.println("나누기한 나머지 결과: "+(a%b));
	
		
		
	}

	private Reader InputStreamReader(InputStream in) {
		// TODO Auto-generated method stub
		return null;   */
	}
	
	
	public void example2() {
		
		Scanner ac = new Scanner(System.in);
		
		System.out.print("가로를 입력하시오: ");
		double ga = ac.nextDouble();
		
		System.out.print("세로를 입력하시오: ");
		double se = ac.nextDouble();
		
		double sum =0, dul = 0;
		sum = (ga * se);
		dul = (ga+se) *2;
		
		//sum이랑 dul을 굳이 선언하지 않고 출력에서 (ga*se), (ga+se)*2를 해주는게 더 좋다(굳이 또 변수를 만드는건 지저분함)
		
		
		System.out.println("면적: "+sum);
		System.out.println("둘레: "+dul);
		
	}
	
	
	public void example3() {
		
		String fst;
		
		Scanner sc1 = new Scanner(System.in);
		

		System.out.print("문자열을 입력하시오: ");
		fst = sc1.next();
	
		
		System.out.println("첫번째 문자: "+fst.charAt(0));
		System.out.println("두번째 문자: "+fst.charAt(1));
		System.out.println("세번째 문자: "+fst.charAt(2));
	
	}
}


