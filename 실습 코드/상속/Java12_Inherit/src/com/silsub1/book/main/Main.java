package com.silsub1.book.main;

import com.silsub1.book.model.vo.Book;

public class Main {
	public static void main(String[] args) {
	
		
	//초기값을 부여한 두 개의 객체를 생성	
	Book bk1 = new Book("수학의 정석", "나수학",23000);
	Book bk2 = new Book("자바의 정석", "나자바",24000);
	
	//두 객체의 정보 출력 처리함
	System.out.println(bk1.toString());
	System.out.println(bk2.toString());
	
	
	/////////
	System.out.println("bk1과 bk2는 같은 객체 : ? "
			+bk1.equals(bk2));
	
	//얕은 복사
	Book bk3 = bk1;
	System.out.println("bk1과 bk3는 같은 객체 ? : "
			+ bk1.equals(bk3));
	
	
	
	Book bk4 = new Book("수학의 정석", "나수학",23000);
	//new라는 연산자를 이용해서 새로 만들었으니 같은 필드가 들어가도 다른객체가 되버림.
	System.out.println("bk1과 bk4는 같은 객체 ? :"+ bk1.equals(bk4));
	
	//주소값은 다르지만 안에 들어있는 data가 같기때문에 동등성을 확보하기위해 equals를 override를 함
	
	
	System.out.println("bk1의 hashcode : "+ bk1.hashCode());
	System.out.println("bk4의 hashcode : "+ bk4.hashCode());
	
	//당연히 다름
	
	
	
	
	}
}
