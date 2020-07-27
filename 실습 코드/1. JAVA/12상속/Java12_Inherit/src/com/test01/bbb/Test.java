package com.test01.bbb;

import com.test01.aaa.AAA;

public class Test {
	public static void main(String[] args) {
		BBB  b1 = new BBB();
		b1.setAbc(1);
		b1.setB(2);
		System.out.println(b1.getAbc()+"+"+b1.getB()+"="+b1.getSum());
		
		BBB b2 = new BBB(3);
		b2.setB(4); // BBB에 3이라는걸로 초기화 시킨다음
		//b부분에 4라고 다시 초기화 =>즉 7
		System.out.println(b2.getAbc()+"+"+b2.getB()+"="+b2.getSum());
		//BBB의 생성자안의 super() => 즉, AAA의 생성자가 생성되고 
		//그다음 BBB의 생성자가 생성
		
		
//		BBB b3 = new BBB(5,6);
//		System.out.println(b3.getAbc()+"+"+b3.getB()+"="+b3.getSum());
		
		BBB b3 = new BBB(5,6);
		b3.setAbc(4);   //위의 경우는 abc= 5, b =6 을 넣어주는데
						//b3.setAbc(4)라는 걸 통해서 abc에 다시 4로 초기화해줌.
						//따라서 4+6 =10
		System.out.println(b3.getAbc()+"+"+b3.getB()+"="+b3.getSum());
		
		
		System.out.println("----------------------------------------");
		AAA a = new AAA();
		BBB b = new BBB();
		
		
		a.prn();
		b.prn();
		//둘다 AAA의 안에 있는 식으로 실행 -> 결과값이 같다
		//BBB에 override로 prn메소드 재정의하고 쓰면 다른 결과값으로 나옴.
		
		//BBB에서 super.prn();이라고 위에 한 줄 더 적었을 때 부모꺼도 한번 실행하고 본인꺼 출력
		//
		
	}
}
