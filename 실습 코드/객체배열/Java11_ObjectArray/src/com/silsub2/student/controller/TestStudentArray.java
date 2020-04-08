package com.silsub2.student.controller;

import java.util.Scanner;

import com.silsub2.student.vo.Student;

public class TestStudentArray {
	public static void main(String[] args) {
		
		Student[] st = new Student[10];
		
		Scanner sc = new Scanner(System.in);
		
//		public Student(int grade, int baan, String name,
//		int kor, int eng, int mat)	
		int count =0;
		
		//1번내용
		for(int i = 0; i <st.length; i++) {
			st[i] = new Student();
		}
		
		
		//2번내용
		System.out.print("학년을 입력하시오 : ");
		int grade = sc.nextInt();
		st[0].setGrade(grade);
		
		System.out.print("반을 입력하시오 : ");
		int baan = sc.nextInt();
		st[0].setBaan(baan);
		
		System.out.print("이름을 입력하시오 : ");
		String name = sc.next();
		st[0].setName(name);
		
		System.out.print("국어점수를 입력하시오 : ");
		int kor = sc.nextInt();
		st[0].setKor(kor);
		
		System.out.print("영어점수를 입력하시오 : ");
		int eng = sc.nextInt();
		st[0].setEng(eng);		
		
		System.out.print("수학점수를 입력하시오 : ");
		int mat = sc.nextInt();
		st[0].setMat(mat);
		
		count++;
		int i = 1;
		System.out.print("계속 입력하시겠습니까?(y / Y) : ");
		char ch = sc.next().charAt(0);
		while(((ch =='y') || (ch=='Y')) && (i<st.length)) {
			
			System.out.print("학년을 입력하시오 : ");
			int grade1 = sc.nextInt();
			st[i].setGrade(grade1);
			
			System.out.print("반을 입력하시오 : ");
			int baan1 = sc.nextInt();
			st[i].setBaan(baan1);
			
			System.out.print("이름을 입력하시오 : ");
			String name1 = sc.next();
			st[i].setName(name1);
			
			System.out.print("국어점수를 입력하시오 : ");
			int kor1 = sc.nextInt();
			st[i].setKor(kor1);
			
			System.out.print("영어점수를 입력하시오 : ");
			int eng1 = sc.nextInt();
			st[i].setEng(eng1);		
			
			System.out.print("수학점수를 입력하시오 : ");
			int mat1 = sc.nextInt();
			st[i].setMat(mat1);
			
			count++;
			i++;
			System.out.print("계속 입력하시겠습니까?(y / Y) : ");
			ch = sc.next().charAt(0);
		}
		
		//3번 내용
		double Sum =0;
				
				for(int j= 0 ; j < i; j++) {
					Sum += st[j].getKor();
					Sum += st[j].getEng();
					Sum += st[j].getMat();
				}
				System.out.println("점수의 평균 : "+(Sum/3*i));
		
		//4번 내용
		for(int k =0; k<i; k++) {
			System.out.println(st[k].prnInfo());
		}
				
				
	}
}
