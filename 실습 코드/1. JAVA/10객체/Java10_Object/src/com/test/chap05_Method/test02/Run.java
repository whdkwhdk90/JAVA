package com.test.chap05_Method.test02;

//nonstaticMethod와 staticMethod 받아옴.


public class Run {
		public static void main(String[] args) {
			NonStaticMethodTest test = new NonStaticMethodTest();
			//매개변수와 반환값이 둘 다 없는 메소드
			test.method1();
			
			//매개변수가 없고 반환값이 있는 메소드
			String res = test.method2();
			System.out.println(res);
			//  ==System.out.println(test.method2());
			
			
			//매개변수가 있고 반환값이 없는 메소드
			test.method3(10,20);
			
			//매개변수와 반환값이 둘 다 있는 메소드
			int num = test.method4(3, 4);
			System.out.println("sum의 값 : "+num);
			
			
			StaticMethodTest.staticMethod1();
			System.out.println("10과 25의 합 : " +StaticMethodTest.staticMethod2());
			StaticMethodTest.staticMethod3("홍길동");
			System.out.println(StaticMethodTest.staticMethod4("홍길동"));
			
			
			
		}
}
