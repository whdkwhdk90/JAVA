package com.test01;

public class MethodTest02 {

	public static void main(String[] args) {
		
		//method 호출 방법
		//1. static : Class.method();
		MethodTest01.publicMethod();
		MethodTest01.protectedMethod();
		MethodTest01.defaultMethod();
	//	MethodTest01.privateMethod(); //MethodTest01 class에서만 적용됨!!!! 그래서 MethodTest02는 적용 불가!!
		
		
		
		
		
		//2. non static : Class 변수명 = new Class();   --참조형의 기본 선언형태. class도 비슷함. 주소값이 들어가있음.
		//				  변수명.Method();
		
		MethodTest01 MT = new MethodTest01();
		MT.NonstaticMethod();
		
		
	}
	
}
