package com.test01;

//형변환
//자동형변환(작은 형에서 큰 형으로 변환) 강제형변환(데이터 loss가 생길 수 있음)
public class Variable06 {

	public static void main(String[] args) {
		
		Variable06 test = new Variable06();
		
//		test.rule1();
//		test.rule2();
		test.rule3();
		
	}
	
	public void rule1() {
		
		//자동형변환(문자타입 ㅡ> int 타입으로 형변환) - 작은 타입은 큰타입으로 형변환하여 계산 or 저장. 묵시적형변환, upcasting.
		int num = 'a';
		System.out.println("num: " + num);
		
		//강제형변환(큰변수 타입은 작은 변수 타입으로 자동형변환이 되지 않기 때문에 강제로 함.명시적형변환, downcasting.
		char ch = 97;
		System.out.println("ch: " + ch);
		
		//char ch2 = -97; 에러 발생.
		
		//int 자료형 변수의 값임.(정수로 되어있는게 아니라 정수를 가지고 있는 자료형임. 그래서 char로 강제 형변환 해야함)
		char ch2 = (char)num; 
		System.out.println("ch2: " + ch2);
		
		// char로 강제 형변환하여 강제로 바뀌긴했지만 -97에 대응하는 문자가 없음.
		int num2 = -97;
		char ch3 = (char)num2;
		System.out.println("ch3: " + ch3);
		
		
		
		
	}
	
	
	public void rule2() {
		
		//다른 자료형끼리 연산 (큰 자료형으로 바뀜)
		int inum = 10;
		long lnum = 100;
		
		// int isum = inum + lnum;(int 타입과 long타입을 계산하면 long타입이 되어야함. int타입으로 정의하면 들어가지 않음.
		
		// 방법1. 수행결과를 int로 강제 형변환 한다.
		int isum = (int)(inum+lnum);
		System.out.println("isum: " + isum);
		
		
		//방법2. long형 값을 int로 강제 형변환한다.	
		int isum2 = inum + (int)lnum;
		System.out.println("isum2: " + isum2);
		
		
		//방법3. long형 변수로 받는다.
		long lsum = inum + lnum;
		System.out.println("lsum: " + lsum);
		
		
		
		
		
	}
	
	
	public void rule3() {
		
		//정수는 실수로 자동형변환이 된다
		long lnum = 100;
		float fnum = lnum;
		
		System.out.println("fnum: " + fnum);
		
		//변수는 데이터 저장(정보), 메서드는 기능
		//실수는 정수로 변경할 때 강제형변환 해줘야함.
		
		double dnum = 10.5;
		int inum = (int)dnum;
		
		System.out.println("dnum: " + dnum);
		System.out.println("inum: " + inum);
		System.out.println("(double)inum: " + (double)inum);
		
		
		
	}
	
}
