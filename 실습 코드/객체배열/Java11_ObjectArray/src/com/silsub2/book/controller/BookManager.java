package com.silsub2.book.controller;

import java.util.Scanner;

import com.silsub2.book.model.Book;

public class BookManager {
	
	private Book[] bar = null;	
	Scanner sc = new Scanner(System.in);
	private static int count =0;
	
	
public BookManager() {
	bar = new Book[10];
	for(int i = 0; i< bar.length; i++) {
		bar[i]= new Book();
	}
}



public void menu() {
		char answer = ' ';
		
do {
	System.out.println("***** 도서 관리 메뉴 *****");
	System.out.println();
	System.out.println("1.도서 정보 추가                   "); //선택시 bookinput() 메서드 실행함
	System.out.println("2.모두 출력                          "); //선택시 bookAllOutput()메서드 실행함
	System.out.println("7.끝내기                              "); //main()으로 return함
	int num = sc.nextInt();
	switch(num) {
	case 1:
		bookInput();
		break;
	case 2:
		bookAllOutput();
		break;
	case 7:
		return;
	default : 
		System.out.print("잘못된 숫자 입력!!");
	}
	System.out.print("계속 하시겠습니까?('y'|'Y') : ");
	answer = sc.next().charAt(0);
}while((answer == 'Y') || (answer == 'y'));
}
	

public void bookInput() {
	
	System.out.print("책 제목 : ");
	String title = sc.next();
	System.out.print("저자  : ");
	String author = sc.next();
	System.out.print("출판사 명 : ");
	String publisher = sc.next();
	System.out.print("책 가격 : ");
	int price = sc.nextInt();
	
	bar[count] = new Book(title,author,publisher,price);
	count++;
	
}	
	
public void bookAllOutput() {
	for(int i = 0; i < count; i++) {
		System.out.println("저자: "+bar[i].info());
	}
}




	
}
