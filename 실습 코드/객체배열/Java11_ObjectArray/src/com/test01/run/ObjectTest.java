package com.test01.run;

import java.util.Scanner;

import com.test01.model.Book;

public class ObjectTest {
	public static void main(String[] args) {
		
		//1. Book class 객체 3개 생성
		
		Book bk1 = new Book("자바의 정석", "홍길동", "나무", 27000);
		Book bk2 = new Book("C언어의 정석", "이창진", "KH", 13000);
		Book bk3 = new Book("프로그래밍", "이순신", "케이에이치", 5500);
		
		//출력
		System.out.println(bk1.info());
		System.out.println(bk2.info());
		System.out.println(bk3.info());
		
		
		//도서검색
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 제목 입력: ");
		String sTitle = sc.nextLine();  //띄어쓰기까지 포함시켰기때문에 띄어쓰기 유의
		
		
		if(bk1.getTitle().equals(sTitle)) {   //입력한 제목이랑 비교해서 같으면 출력
			System.out.println(bk1.info());
		} else if(bk2.getTitle().equals(sTitle)) {
			System.out.println(bk2.info());
		} else if(bk3.getTitle().equals(sTitle)) {
			System.out.println(bk3.info());
		}
	
	
	
	
	
	
	
	}
}
