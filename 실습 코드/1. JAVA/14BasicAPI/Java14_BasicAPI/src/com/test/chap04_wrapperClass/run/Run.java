package com.test.chap04_wrapperClass.run;

public class Run {

	public static void main(String[] args) {

		//Boxing :  기본 자료형 --> wrapper 클래스 객체
		
		//UnBoxing :  wrapper 클래스 객체 --> 기본 자료형
		
		
		//Boxing
			Integer i = new Integer(10);
			Integer i2 = new Integer(15);
			Double d = new Double(10.0);
			
			System.out.println(i.equals(i2));
			System.out.println(i2);
			System.out.println(i.compareTo(i2));
			// 0 -> 같을때
			// 양수 -> i가 큰 수일 때
			// 음수 -> i가 작은 수일 때
		
		//AutoBoxing : 
			Short i3 = 10;
			Integer i4 = 5;
		
			
			
		//UnBoxing
		//wrapper 클래스 --> 기본자료형
			int pi = i.intValue();
			double pd = d.doubleValue();
			
		//AutoUnBoxing
			int a = i;
			int b = i2;
			System.out.println(a+b);
			
			abox(a+b);
			//int >> (autoboxing) >> integer >> 다형성 적용 >> object obj
			//>> 다시 int로 강제형변환해서 출력
		
	}
	
		public static void abox(Object obj) {
			//System.out.println((int)obj);
			System.out.println((Integer)obj);
		}
	
		
	

}
