package com.test01;

public class Operator02 {
	// ++ : 1증가의 의미, ++값 값++
	// -- :  1감소의 의미, --값, 값--
	
	public static void main(String[] args) {
		
		Operator02 op = new Operator02();
		// 클래스 변수 = new 클래스();
		
		//op.test1();
		op.test2();
		// 변수. 메소드();
		
		
		
	}
	public void test1() {
		int age = 19;
		
		//증감 연산자 계산
		
		System.out.println("현재 나이는? " + age);
		
		
		++age;
		System.out.println("++age결과는? " + age);
		
		age++;	
		System.out.println("age++결과는? " + age);
		
		
		--age;
		System.out.println("--age결과는? " + age);
		
		age--;
		System.out.println("age--결과는? " + age);
		
		//+=2  : 2씩 증가시킨다!!    ㅡ> age+=3 
		
		
		
		
	}
	
	public void test2() {
		int num1 = 20;
		//후위연산자
		//계산을 먼저 처리하고 난 뒤 증감처리 된다!!
		
		int res = num1++*3;
		//후위연산자라 곱하기 진행 후에 num1값만 증가  ㅡ> 60
		System.out.println("res : " +res);
		System.out.println("num1 : " +num1);
		
		int num2 = 20;
		int res2 = ++num2*3;
		// 전위연산자는 증가를 시키고 곱하기 진행  ㅡ> 63
		System.out.println("res2 : " +res2);
		System.out.println("num2 : " +num2);
		
		
		
		
	}

	
	
}
