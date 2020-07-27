package com.test01;

public class Operator07 {

	//산술대입연산자: +=, -=, *=, /=, %=
	//다른 연산자와 대입연산자를 함께 사용하는 연산자를 말한다.
	
	public static void main(String[] args) {
	
		new Operator07().opTest();
	}

	public void opTest() {
		
		int res, num=10;		
		System.out.println("num: "+num);
		
		//3증가
		num = num +3;		
		System.out.println("num: "+num);
		
		num+=3;
		System.out.println("num: "+num);
		
		num-=5; //num = num-5;
		System.out.println("num: "+num);
		
		num*=2; //num = num*2;
		System.out.println("num: "+num);
		
		num/=2; //num = num/2;
		System.out.println("num: "+num);


	}
	
	
	
}
