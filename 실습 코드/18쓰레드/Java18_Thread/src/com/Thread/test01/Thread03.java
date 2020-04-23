package com.Thread.test01;

public class Thread03 {

	public static void main(String[] args) {
		
		MyThread02 m1 = new MyThread02("야옹");
		MyThread02 m2 = new MyThread02("멍멍");
		
		long start_time = System.currentTimeMillis();	
		m1.start();
		
		
		//지정한 스레드가 실행되도록 도와줌.(m1을 먼저 다 실행시킬때까지 도와줌)
		//m1의 thread가 종료 될때까지 다른thread를 멈춤
		try {
			m1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		m2.start();
		long end_time = System.currentTimeMillis();
		System.out.println("실행시간: "+(end_time - start_time));
		
	}
	
}
