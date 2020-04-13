package com.test.chap03_stringTokenizer.run;

import java.util.StringTokenizer;

public class Run {
	public static void main(String[] args) {
		String str = "이창진,19,서울 서초,남";
		
		
		StringTokenizer st = new StringTokenizer(str,",");
		System.out.println(st.countTokens());
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		
		
		
	}
	
	
	
	
	
	
	
}
