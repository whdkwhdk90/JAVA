package com.test01;

public class Operator04 {
	
	//비교연산자(관계연산자
	//두 개의 변수의 관계를 따지는 연산자
	//비교 연산자는 조건을 만족하면 true, 만족하지 못하면 false를 반환
	
	
	public static void main(String[] args) {
		
		Operator04 op = new Operator04();
		op.opTest();
		
	}
	
	public void opTest() {
		int a = 10, b = 20;
		boolean res1, res2, res3;
		
		res1 = (a==b); // res1= (a!=b); : a랑 b와 다른가??
		res2 = (a<=b);
		res3 = (a>b);
		
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
		
	}
	
	
	
	
	
	
	
}
