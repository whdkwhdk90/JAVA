package com.test01.run;

import java.util.Scanner;

import com.test01.model.Book;

public class ObjectArrayTest {
		public static void main(String[] args) {
			//객체배열 선언 및 할당
//			Book[] bk = new Book[3];
			//초기화
//			bk[0] = new Book();
//			bk[1] = new Book();
//			bk[2] = new Book();  //정수나 문자열 넣으면 에러뜸. 선언을 book클래스로 했기 때문
//			
			//선언 및 할당과 동시에 초기화
			Book[] bk = {
					new Book("자바의 정석", "홍길동","나무", 27000),
					new Book("C언어의 정석", "이창진", "KH", 21000),
					new Book("프로그래밍", "이순신", "케이에이치", 3000)
				};
			
//			System.out.println(bk);
//			System.out.println(bk[0]);
//			System.out.println(bk[0].getTitle());
			//배열안에는 객체가 들어있음.
			//첫번째줄 결과는 대괄호로 나오는데 두번째줄부턴 괄호가 없음
			
			
			//도서 출력
			System.out.println("도서 갯수 : " +bk.length);
			//도서정보 출력
			for(int i = 0; i < bk.length; i++) {
				System.out.println(bk[i].info());
			}
			
			
			//도서 검색
			Scanner sc = new Scanner(System.in);
			System.out.print("검색할 책 제목 : ");
			String sTitle = sc.nextLine();
			
			
			for(int i =0; i<bk.length; i++) {
				if(bk[i].getTitle().equals(sTitle)) {
					System.out.println(bk[i].info());
				}
			}
			
			
			
		}
			
}

