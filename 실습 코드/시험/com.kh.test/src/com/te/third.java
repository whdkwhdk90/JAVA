package com.te;

public class third{
	public static void main(String[] args) {
		
		Object[] sarr = new String[4];
		Object obh = new Object();
	//	sarr[0] = new String("123");
	//	sarr[1] = String.valueOf(new Integer(456));
		sarr[2] = (String)obh;
	//	sarr[3] = String.valueOf(789);
		
		for(Object obj : sarr) {
			System.out.println(obj); 
		}
		
		
	}
}
