package com.test01;

public class Operator07 {
	public static void main(String[] args) {
		
	Operator07 op = new Operator07();	
		op.opTest();
	}
	
	//산술대입연산자 : +=, -=, *=, /=, %=
	//다른 연산자와 대입연산자를 함께 사용하는 연산자를 말한다.
	// (a = a+3;)   ==  (a+=3;)
	
	
	public void opTest() {
		int num =10;
		
		System.out.println("num : " +num);
		
		//3증가(2가지의 방법)
		num = num +3;
		System.out.println("num : " +num);
		
		num += 3; //num의 값에서 3을 증가시키겠다
		System.out.println("num : " +num);
		
		num -= 5; //num의 값에서 5를 감소시키겠다
		System.out.println("num : " +num);
		
		num *= 2; //num의 값에서 2배를 하겠다
		System.out.println("num : " +num);
		
		num /= 2; //num의 값에서 2를 나누겠다
		System.out.println("num : " +num);
		
		num %= 2; //num의 값에서 2를 나눠서 나머지를 출력하겠다
		System.out.println("num : " +num);
		
		
	}
	
	
	
}
