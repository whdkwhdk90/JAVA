package com.silsub1.example;

import java.util.Scanner;

public class Munjae {
	public void test1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 성적을 입력하시오 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어 성적을 입력하시오 : ");
		int eng = sc.nextInt();
		
		System.out.print("수학 성적을 입력하시오 : ");
		int mat = sc.nextInt();
		
		int sum = kor + eng + mat;
		int avg = sum /3;
		
		if(kor >=40 && eng >= 40 && mat >= 40) {
					if(avg >= 60) {
						System.out.println("국어 : " + kor + ", 영어 : "  + eng + ", 수학 : " + mat );
						System.out.println("총점 : " + sum + ", 평균 : " + avg);
					} else {
						System.out.println("불합격");
					}
			
			
		}else {
			System.out.println("불합격");

		}
		
	}
	
	public void test2() {
		
		System.out.println("*** 초기 메뉴 ***");
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("7. 종료");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("메뉴번호 입력 : ");
		int num = sc.nextInt();
		
		switch(num) {
		case 1 : 
			System.out.print("입력메뉴가 선택되었습니다.");
			break;
			
		case 2 : 
			System.out.print("수정메뉴가 선택되었습니다.");
			break;
			
		case 3 : 
			System.out.print("조회메뉴가 선택되었습니다.");
			break;
			
		case 4 : 
			System.out.print("삭제메뉴가 선택되었습니다.");
			break;
			
		case 7 : 
			System.out.print("프로그램이 종료됩니다.");
			break;
			
		default : 
			System.out.println("번호가 잘못 입력되었습니다.");
			System.out.println("다시 입력하십시오.");
		}
		
	}
	
	public void test3() {
		
		Scanner sc =new Scanner(System.in);
		
		System.out.print("정수 하나를 입력하시오: ");
		int num = sc.nextInt();
		
		if(num >0) {
			System.out.println("양수다");
		}else {
			System.out.println("양수가 아니다");
		}
		
		
	}
	
	public void test4() {
		
		Scanner sc =new Scanner(System.in);
		
		System.out.print("양의 정수 하나를 입력하시오 : ");
		int num = sc.nextInt();
		String str ;
		if(num%2 ==0) {
			str = "짝수다";
		}else {
			str = "홀수다";
		}
		
		System.out.println("입력한 수는 " + str);
		
	}
	
	public void inputTest() {
		
		String name="";
		int age;
		double height;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하시오 : ");
		name = sc.nextLine();
		
		System.out.print("나이를 입력하시오 : ");
		age = sc.nextInt();
		
		System.out.print("키를 입력하시오 : ");
		height = sc.nextDouble();
		
		if(age > 0 && height >0 && name.length() != 0) {
	//	if(age > 0 && height >0 && name != null) 	 //이거는 왜 안되는가??
			
			System.out.println("이름 : " + name);
			System.out.println("나이 : " + age);
			System.out.println("키 : " + height);
			System.out.println("확인 : " + name + "의 나이는 " + age + "세이고, 키는 " + height + "cm 이다.");
		}
		
		
	}
	
	///문자열을 공백 방지는 어떻게해야하는가 ????
	
	
	public void test6() {
		
		int num1, num2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 하나를 입력하시오 : ");
		num1 = sc.nextInt();
		
		System.out.print("나머지 정수 하나를 입력하시오 : ");
		num2 = sc.nextInt();
		
		if(num1 >0 && num2>0) {
			System.out.println("첫번째 정수 : " + num1);
			System.out.println("두번째 정수 : " + num2);
			System.out.println(num1 + " + " + num2 + "= "+ (num1+num2));
			System.out.println(num1 + " - " + num2 + "= "+ (num1-num2));
			System.out.println(num1 + " * " + num2 + "= "+ (num1*num2));
			System.out.println(num1 + " / " + num2 + "= "+ (num1/num2));
			System.out.println(num1 + " % " + num2 + "= "+ (num1%num2));
		}
		
	}
	
	public void test7() {
		int num;
		char ch = ' ' ;

		Scanner sc  = new Scanner(System.in);
		
		System.out.print("점수를 입력하시오 : ");
		num = sc.nextInt();
		
		if( num > 0 )
		{
				if(num >=90) {
					ch = 'A';
				}else if(num >= 80) {
					ch = 'B';
				}else if(num >= 70) {
					ch = 'C';
				}else if(num >= 60) {
					ch = 'D';
				}else {
					ch = 'F';
				}
				System.out.println("점수 : " + num + ", 학점 : " +ch);
		}
		
		
		
	}
	
	
	
	}

	
	
