package com.Thread.test01;


class MyThread02 extends Thread{
	public MyThread02() {}
	public MyThread02(String name) {
		super(name);
	}
	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println(this.getName()+"="+i);
		}	
		System.out.println(this.getName()+"끝!!!");
	}
}

public class Thread02 {
	
	public static void main(String[] args) {
		
		MyThread02 m1 = new MyThread02("멍멍");
		MyThread02 m2 = new MyThread02("야옹");
		
		//thread scheduling 
		//1.우선순위(priority) 2. 순환 할당(round-robin) -jvm이 지정하기에 개발자가 지정 불가
		
		//<1.priority>
		m1.setPriority(1);
		m2.setPriority(10);
		
		
		
		m1.start();
		m2.start();
	}
	
}
