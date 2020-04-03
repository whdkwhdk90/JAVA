package com.test01;

public class Variable01 {
	// 타입 변수명 = 값;
	// 타입 : 생성할 변수에 어떠한 종류의 값이 들어갈지 타입을 지정
	// 변수명 : 변수의 이름
	// 값 : 리터럴, 변수에 들어갈 데이터
	public static void main(String[] args) {
	
		
		Variable01 test = new Variable01();
		// 클래스명 변수명 = new 클래스명();
		
	  //  test.decVariable(); 
		test.initVariable();
		
		
	}
	
	public void decVariable() {
		//변수 선언---------------------------------------
		
		//정수형
		byte bnum;
		short snum;
		int inum;
		long lnum;
		
		//실수형
		float fnum;
		double dnum;
		
		//논리형
		boolean isTrue;
		
		//문자형
		char ch;
		
		//문자열(참조형)
		String str;
		
		
		//변수 초기화-------------------------------------
		bnum = 1;
		snum = 2;
		inum = 4;
		lnum = 8L;
		
		fnum = 4.0f;
		dnum = 8.0;
		
		isTrue = true;//or false 값만 저장 가능
		
		ch = 'A';
		str = "A";
		
		
		// 화면으로 출력--------------------------------------
		System.out.println("bnum의 값: " +bnum );
		System.out.println("snum의 값: " +snum );
		System.out.println("inum의 값: " +inum );
		System.out.println("lnum의 값: " +lnum );
		
		System.out.println("fnum의 값: " +fnum );
		System.out.println("dnum의 값: " +dnum );
		
		System.out.println("isTrue의 값: " +isTrue );
		
		System.out.println("ch의 값: " +ch );
		System.out.println("str의 값: " +str );
		
		
	}

	public void initVariable(){
		//변수 선언과 동시에 초기화-----------------------------
		
		
		//정수형
		byte bnum = 1;
		short snum = 2; 
		int inum = 4;
		long lnum = 8L;
		
		//실수형
		float fnum = 4.0f;
		double dnum = 8.0;
		
		//논리형
		boolean isTrue = false;
		
		//문자형
		char ch = 'A';
		
		//문자열
		String str = "안녕하십니까.";
		
		//변수 값 출력
		System.out.println(bnum);
		System.out.println(snum);
		System.out.println(inum);
		System.out.println(lnum);
		System.out.println(fnum);
		System.out.println(dnum);
		System.out.println(isTrue);
		System.out.println(ch);
		System.out.println(str);
		
		
		
	}
	
}
