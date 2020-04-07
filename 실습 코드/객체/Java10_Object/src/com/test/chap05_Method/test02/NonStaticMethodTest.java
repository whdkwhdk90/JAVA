package com.test.chap05_Method.test02;


//매개변수 유무와 반환값 유무에 따른 메소드 구분
public class NonStaticMethodTest {
		 // 1. 매개변수 없고 반환값 없는 메소드
		 	public void method1() {
		 		System.out.println("매개변수와 반환값이 둘 다 없는 메소드");
		 	}
		 
		 // 2. 매개변수 없고 반환값 있는 메소드
		 	public String method2() {
		 		return "매개변수가 없지만 반환값이 있는 메소드";
		 	}
		 	
		 //	3. 매개변수 있고 반환값 없는 메소드
		 	public void method3(int num1, int num2) {
		 		int sum = num1 + num2;
		 		System.out.println("sum의 값 :" +sum);
		 	}
		 // 4. 매개변수 있고 반환값 있는 메소드
		 	public int method4(int num1, int num2) {
		 		return num1+num2;   //return뒤에 연산처리까지 넣을 수 있음.
		 	}
}
