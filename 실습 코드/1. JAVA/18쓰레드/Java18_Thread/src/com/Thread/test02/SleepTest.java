package com.Thread.test02;

public class SleepTest {

	public static void main(String[] args) {

		for(int i=0; i<50; i++) {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					System.out.print("★");
				}
			
			
			
			
		}
		
		
		
	}

}
