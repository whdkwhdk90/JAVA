package com.test.chap05_Method.test02;

public class StaticMethodTest {
		public static void staticMethod1() {
			int num = 10;
			int num2 = 30;
			System.out.println("10과 30의 합은 "+(num+num2)+"입니다.");
		}
		
		public static int staticMethod2() {
			int num = 10;
			int num2 = 25;
			return num+num2;
		}
		
		public static void staticMethod3(String name) {
			System.out.println(name + "님의 방문을 환영합니다.");
		}
		
		public static String staticMethod4(String name) {
			return name+"님의 방문을 환영합니다.";
		}
		
		
}
