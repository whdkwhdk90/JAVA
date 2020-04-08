package com.silsub2.person.controller;

import java.util.Scanner;
import com.silsub2.person.model.vo.Person;

public class TestPersonArray {
	public static void main(String[] args) {
		
		Person[] ps = new Person[5];
		Scanner sc= new Scanner(System.in);
		
		
//		public Person(String name, int age, char gender, double height, double weight)	
		
		
		//1번 내용
		for(int i=0; i<ps.length;i++) {
			ps[i]=new Person();
		}												//객체들의 초기화
												
		//2번 내용
		for(int i = 0; i < ps.length; i++) {
			System.out.print("이름을 입력하시오 : ");
			String name = sc.next();
			ps[i].setName(name);
			
			System.out.print("나이를 입력하시오 : ");
			int age = sc.nextInt();
			ps[i].setAge(age);
			
			System.out.print("성별을 입력하시오 : ");
			char gender = sc.next().charAt(0);
			ps[i].setGender(gender);
			
			System.out.print("키를 입력하시오 : ");
			double height = sc.nextDouble();
			ps[i].setHeight(height);
			
			System.out.print("몸무게를 입력하시오 : ");
			double weight = sc.nextDouble();
			ps[i].setWeight(weight);		
		}	
		
		//3번내용
		for(int i = 0 ; i < ps.length; i++) {
			System.out.println(ps[i].personInfo());
		}
		
		//4번내용
		double Sum =0, Avg = 0;
		
		for(int i = 0 ; i < ps.length; i++) {
			Sum += ps[i].getAge();
		}
		System.out.println("나이의 평균 : "+(Sum/ps.length));
		
		Sum =0; Avg =0;
		
		for(int i = 0 ; i < ps.length; i++) {
			Sum += ps[i].getHeight();
		}
		System.out.println("키의 평균 : "+(Sum/ps.length));
		
		Sum =0; Avg =0;
		
		for(int i = 0 ; i < ps.length; i++) {
			Sum += ps[i].getWeight();
		}
		System.out.println("몸무게의 평균 : "+(Sum/ps.length));
		
		
		
		
		
		
		
		
		
		
		
	}
}
