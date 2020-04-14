package com.test01;

public class Operator03 {

	
	public static void main(String[] args) {
		
		new Operator03().opTest();
		//한번 사용하고 끝 , 매번 사용할때마다 선언해줘야한다.
		
	}
	
	
	public void opTest() {
		
		int num1 = 10;
		int num2 = 3;
		
		System.out.println("num1 + num2 = "+(num1+num2));
		System.out.println("num1 - num2 = "+(num1-num2));
		System.out.println("num1 * num2 = "+(num1*num2));
		System.out.println("num1 / num2 = "+(num1/num2));
		System.out.println("num1 % num2 = "+(num1%num2));
			
		
	}
	
	
}
