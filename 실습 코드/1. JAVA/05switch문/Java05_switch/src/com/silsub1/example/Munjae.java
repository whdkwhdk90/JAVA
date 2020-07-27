package com.silsub1.example;

import java.util.Scanner;

public class Munjae {

	public void test1() {
		Scanner sc = new Scanner(System.in);
		
		int kor,eng,mat;
		System.out.print("국어: ");
		kor= sc.nextInt();
		System.out.print("영어: ");
		eng= sc.nextInt();
		System.out.print("수학: ");
		mat= sc.nextInt();
		
		int sum=(kor+eng+mat);
		double avg=sum/3.0;
		if(kor>=40 && eng>=40 && mat>=40 && avg>=60) {
			System.out.println("국어:"+kor+", 영어:"+eng+", 수학:"+mat+", 평균:"+avg+" 합격 입니다.");
			
		}else {
			System.out.println("불합격 입니다.");
		}

	}
	public void test2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("*** 초기 메뉴 ***");
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("7. 종료");
		System.out.print("메뉴번호 입력 : ");
		int input = sc.nextInt();
		
		switch(input) {
		
		case 1:
			System.out.println("입력메뉴가 선택되었습니다.");
			break;
		case 2:
			System.out.println("수정메뉴가 선택되었습니다.");
			break;
		case 3:
			System.out.println("조회메뉴가 선택되었습니다.");
			break;
		case 4:
			System.out.println("삭제메뉴가 선택되었습니다.");
			break;
		case 7:
			System.out.println("프로그램이 종료됩니다.");
			break;
			
		default:
			System.out.println("번호가 잘못 입력되었습니다.");
			System.out.println("다시 입력하십시오.");

		}
		
	}
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력:");
		int num = sc.nextInt();
		
		if(num>0) {
			System.out.println("양수다.");
		}else {
			System.out.println("양수가 아니다.");
		}
		
	}
	public void test4() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력: ");
		int num =sc.nextInt();
		String str="";
		
		if(num>0) {
		
			if(num%2==0) {
				str="짝수다.";
				System.out.println(str);
			}else {
				str="홀수다.";
				System.out.println(str);
			}
		}else {
			System.out.println("양수가 아니다.");
		}
		
		
		
	}
	public void inputTest() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름: ");
		String name=sc.nextLine();
		System.out.print("나이: ");
		int age=sc.nextInt();
		System.out.print("키: ");
		double height=sc.nextDouble();
		char m = name.charAt(0);
		
		//isempty  -> 변수가 비어있는지 확인하는 메소드.
		//name != null && name.length() > 0
		if((name.isEmpty() != true) && age>0 && height>0) {
			System.out.println(name+"의 나이는 "+age+"세이고, 키는 "+height+"cm 이다.");
		}else {
			System.out.println("입력 값이 잘못되었습니다.");
		}
		
		
		
	}
	public void test6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 정수 입력: ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 입력: ");
		int num2 = sc.nextInt();
		
		if(num1>0 && num2>0) {
			System.out.println(num1+" + "+num2+" = "+(num1+num2));
			System.out.println(num1+" - "+num2+" = "+(num1-num2));
			System.out.println(num1+" * "+num2+" = "+(num1*num2));
			System.out.println(num1+" / "+num2+" = "+(num1/num2));
			System.out.println(num1+" % "+num2+" = "+(num1%num2));
			
		}else {
			System.out.println("두 수가 양수가 아니다.");
		}
		
	}
	public void test7() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력해 주세요: ");
		int point =sc.nextInt();
		char grade=' ';
		
		if(point>0) {
			if(point>=90) {
				grade = 'A';
			}else if(point>=80) {
				grade = 'B';
			}else if(point>=70) {
				grade = 'C';
			}else if(point>=60) {
				grade = 'D';
			}else{
				grade = 'F';
			}
			System.out.println("점수: "+point+", 학점: "+grade+" 입니다.");
		}else {
			System.out.println("점수를 다시 입력해주세요.");
		}

		
	}
}
