package com.kh.inputTest;

import java.util.StringTokenizer;

public class TestCommandLine {
					
		public static void main(String[] test) {
	
			String[] str = new String[test.length];
				
			for(int i = 0;  i <test.length; i++) {
				str[i] = test[i];
					
			}
			String name = str[0];
			char gender = str[1].charAt(0);
			int age = Integer.parseInt(str[2]);
			double height = Double.parseDouble(str[3]);
			double weight = Double.parseDouble(str[4]);
			
			System.out.println("이름 : " +name);
			System.out.println("성별 : "+gender);
			System.out.println("나이 : "+age);
			System.out.println("키 : "+height);
			System.out.println("몸무게 : "+weight);
			
			
		}
}
