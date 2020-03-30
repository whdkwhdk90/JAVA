package com.test01;

public class Operator03 {
	public static void main(String[] args) {
	
	//	Operator03 op = new Operator03();
		
	//	op.opTest();    //계속 사용 가능
		
		new Operator03().opTest();  //이렇게 작성하면 한번사용하면 끝 
		// (위에 방식은 변수에 준비시키는것이고 이건 바로 준비)
		
		
	}
	
	public void opTest() {
		int num1 = 10;
		int num2 = 3;
		
		System.out.println("num1 + num2 : " + (num1+num2));
		System.out.println("num1 - num2 : " + (num1-num2));
		System.out.println("num1 * num2 : " + (num1*num2));
		System.out.println("num1 / num2 : " + (num1/num2));
		System.out.println("num1 % num2 : " + (num1%num2));
	}
	
	
	
	
	
	
	
	
	
}
