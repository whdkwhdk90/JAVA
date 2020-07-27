package com.test01;

public class Variable04 {

	public static void main(String[] args) {
		
		//상수
		int age;
		final int AGE;
		
		age = 20;
		AGE = 20;
		
		System.out.println("age: "+age);
		System.out.println("AGE: "+AGE);
		
		//변수값 변경
		
		age = 30;
		//AGE = 30; //상수를 변경하려면 코드상으로 에러 발생. 상수값은 변경 불가!!
		
		System.out.println("변경 후 age: "+age);
		System.out.println("변경 후 AGE: "+AGE);
	}
	
	
	
}
