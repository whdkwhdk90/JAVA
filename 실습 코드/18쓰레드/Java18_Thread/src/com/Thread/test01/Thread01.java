package com.Thread.test01;



class MyThread implements Runnable{

	@Override
	public void run() {
		for(int i =0; i<10; i++) {
			System.out.println("i= "+i);
		}
	}
	
}

public class Thread01 {

	public static void main(String[] args) {

		System.out.println("--- main start ---");
		
		//thread가 아니라 그냥 객체 생성 및 메서드 실행했을 뿐.
		MyThread mt = new MyThread();
//		mt.run();
	
		
		
		Thread t1 = new Thread(mt);
		t1.start();
		
		System.out.println("--- main stop ---");
		
		//실행 결과 메인을 다 실행하고 스레드가 실행되는 것을 알 수 있다.
		
		
	}

}
