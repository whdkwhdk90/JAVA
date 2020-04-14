package com.test01;

public class SwitchTest01 {

	public void test() {
		
		int i = 1;
		
		switch(i) {
		case 1:
			System.out.println("1입니다.");
			break;
		case 2:
			System.out.println("2입니다.");
			break;
		case 3:
			System.out.println("3입니다.");
			break;
		default :
			System.out.println("다른 숫자 입니다.");
			
		}
		
	}
	
	public void test2() {
		
		char ch='b';
		
		switch(ch) {
		
		case 'a':
			System.out.println("a입니다.");
			break;
		case 'b':
			System.out.println("b입니다.");
			break;
		case 'c':
			System.out.println("c입니다.");
			break;
		default:
			System.out.println("다른 영어 입니다.");
			break;
	
		}
			
	}
	
	public void test3() {
		
		int i=2;
		switch(i) {
		
		case 1:
		case 3:
			System.out.println("홀수 입니다.");
			break;
			
		case 2:
		case 4:
			System.out.println("짝수 입니다.");
			break;
		default:
			System.out.println("다른 숫자 입니다.");
			
		}	
	}
	
	public void test4() {
		//java 7버전 이후 부터 문자열 사용 가능
		String s="한국";
		
		switch(s) {
		case "한국":
			System.out.println("korea");
			break;
		case "미국":
			System.out.println("usa");
			break;
		default:
			System.out.println("다른 나라 입니다.");
				
			
			
			
			
			
		}
		
		
	}
}
