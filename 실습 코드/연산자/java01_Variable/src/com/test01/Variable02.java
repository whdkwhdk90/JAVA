package com.test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;





public class Variable02 {
	//java.io 패키지에서 제공되는 클래스를 이용해서 키보드 입력 테스트
	
	
	
	
	public static void main(String[] args) {
			
	Variable02 test = new Variable02();
	//클래스명 변수명 = new 클래스명();
	
//	test.inputTest1();
	//변수명.메소드명();
	
	
	test.inputTest2();
	
	}
	
	
	public void inputTest1() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in) ); // 시스템안에 inputstreamreader라는 함수를 통해서 bufferedreader의 br에 저장
	

		System.out.print("정수 한 개 입력: "); //정수 입력 받기
		
		try {
			String value = br.readLine(); //br이라는 곳에서 받은 값을 value에 입력
			
			int number = Integer.parseInt(value); //value라는 값을  int화 시켜서 number에 초기화
			System.out.println(number*3); //number에 3곱해서 출력
			
			
		//	System.out.println("입력 받은 값: " +value); //입력받은 값을 출력
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//bufferedreader는 readline, scanner는 next0000를 씀
		
		
	}

	public void inputTest2() {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("나이: ");
		int age = sc.nextInt();
		System.out.print("키: ");
		double height = sc.nextDouble();
		
		System.out.println("이름 : "+name+", 나이: "+age+", 키:  "+height+".");
		
	}
}
