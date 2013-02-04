package com.test01;



//오버플로우

public class Variable05 {

	public static void main(String[] args) {
		
	Variable05 test = new Variable05();
	test.testOverflow();
	
	}
	
	
	public void testOverflow() {
		//byte bnum
		//byte bnum = 128; byte는 127이 한계. 범위를 벗어났음
		
		//계산과정에서 범위를 벗어나면 오버플로우 처리됨.
		byte bnum = 127;
		bnum =(byte)(bnum + 1); //byte + int ㅡ> int
		
		System.out.println("bnum: "+ bnum);
		
		
		
		
	}
	
	
	
	
}
