package com.test02;

public class Student {
	public static void main(String[] args) {
		
		String name = "이창진";
		int kor = 100;
		int eng = 40;
		int mat = 84;
		
		Score sc = new Score();
		double avg = sc.getAvg(kor, eng, mat);
		//순서뿐 아니라 타입까지도 동일하게 맞춰줘야됨 !!
		
	//system.out.println(avg);
		
		
		String res = sc.getGrade(avg);
		
		System.out.println(name + "님의 등급은 " + res + " 입니다.");
		
		
		//while문은 증감식이 안에 있어야됨. 아니면 계속 돈다.
		
		
		
	}
}
