package com.test.chap05_Method.test01;

public class overloadingTest {
		public int test() {
			return 0;
		}
		
		//오버로딩을 이용하여 같은 이름의 메소드를 만든다.
		public int test(int a) {
			return 0;
		}
		public int test(int a, int b) {
			return 0;
		}
		
		public int test(int a, String s) {
			return 0;
										//매개변수의 타입이 달라도 오버로딩 가능
		}
		
/*		public int test(int b, int a) {
			return 0;
										//매개변수명은 상관없이 자료형의 갯수와 순서, 종류가 다르게 작성되어야 한다.
										//밖에서 볼 때는 그냥 인트 2개를 매개변수로 가지는 메소드일뿐임.(위에 12번줄 메소드와 중복된다.)
		}
*/		
		public int test(String s, int a) {
			return 0;					//자료형이 다를 때 순서가 다르면 오버로딩이 가능(16번째줄 메소드와 비교)
		}
		
		public String test(int a, int b, String s) {
			return null;
		}
		
/*		public int test(int a, int b, String s) {
			return 0;	
										//return 타입은 아무런 상관이 없음.(리턴 타입이 다르다고 오버로딩이 적용되지 않는다.)
		}
*/		
/*		private String test(int a, int b, String s) {
			return null;
										//접근제한자가 다르다고 오버로딩이 적용되는건 아님.
		}
*/		
		
}

