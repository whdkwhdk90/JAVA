package com.testchap03_field.test01;

public class kindsOfVariable2 {
	
	//전역변수
	public static int staticNum;
	
	//상수 필드 : static과 final 키워드를 함께 사용하는 것
	public final static int STATIC_NUM = 1;
	public static final  int STATIC_NUM2= 1;
	
	public void methodTest() {
	//	static int localStaticNum;
		//static은 시작될 때 사용하는데 non-static은 new연산자 사용할때 시작하기때문에
		//어불성설이다.
	
	}
	
}
