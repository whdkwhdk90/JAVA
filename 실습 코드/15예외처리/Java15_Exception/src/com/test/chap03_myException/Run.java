package com.test.chap03_myException;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력 : ");
		
		try {
			checkNum(sc.nextInt());
		} catch (MyException e) {
			System.out.println("마이익셉션 예외 발생!!");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	
	public static void checkNum(int num) throws MyException  {
		if(num< 10) {
//			MyException me = new MyException();
//			throw me;
			
			throw new MyException(num+"은 10보다 작은수잖아~!!!");
			
			
		}else {
			System.out.println(num+"은 10보다 크거나 같은 수!!");
		}
	}
	
}
