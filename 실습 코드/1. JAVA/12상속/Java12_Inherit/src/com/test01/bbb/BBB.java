package com.test01.bbb;

import com.test01.aaa.AAA;

public class BBB extends AAA{	//AAA에 선언되어있는 필드 메소드를
								//BBB가 내것처럼 사용 가능!!!!
	
	private int b;
	
	
	
	public BBB() {
	//	super(); //부모의 생성자 --> AAA()
	//  기본생성자에서 super()는 생략가능하다.
		System.out.println("BBB 생성");
	}
	
	public BBB(int b) {
		super(3);  //=> super(b);라고 되어있으면 입력한 b와 
		//abc에도 b의 값이 들어가서 b=3일때, sum = 3+3 = 6이 됨
		//super()는 맨 위에 있어야함. 그리고 얘도 생략되어있음
		this.b = b;
		System.out.println("BBB 생성(b 받아서 생성)");
	}
	
	public BBB(int abc, int b) {
		super(abc);
		//만약 abc가 없이 그냥 super()면 abc는 초기화가 되지 않으므로 0으로 고정.
		this.b = b;
		System.out.println("BBB 생성(abc, b 받아서 생성)");
	}
	
	//getter & setter
	
	public int getB() {
		return b;
	}
	
	public void setB(int b) {
		this.b = b;
	}
	
	public int getSum() {
		int sum =  super.getAbc()+this.getB();
		return sum;
	}
	
	@Override
	public void prn() {
		super.prn();
		System.out.println("BBB class의 prn()");
	}
	
	
	
	
	
}
