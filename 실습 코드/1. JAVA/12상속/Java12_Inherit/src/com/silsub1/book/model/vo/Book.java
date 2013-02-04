package com.silsub1.book.model.vo;


public class Book {

	private String title;
	private String author;
	private int price;
	
	
public Book() {
	
}

public Book(String title, String author, int price) {
	this.title = title;
	this.author = author;
	this.price = price;
}



public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}
	

@Override
public String toString() {
	return "책의 제목 : "+title+", 책의 저자 : "+author+", 책의 가격 : "+price;
}



//equals()
//두 객체의 주소값을 비교하여 같으면 true, 다르면 false를 return;
//객체가 가진 값까지 비교하기 위한 목적으로 overriding(동등성 확보 목적)
@Override
public boolean equals(Object obj) {   //obj에 담기는거 bk4
	
	if(this == obj) {  //this : bk1의 주소값, obj : bk4의 주소값  
						//주소가 같으면 같은 객체
		return true;
	}
	
	//전달받은 객체가 null인 경우 무조건 다른 객체
	if(obj == null) {
		return false;
	}
	////////////////////////////////////
	//전달받은 객체를 형변환하여 각 필드별로 비교 시작
	//(오브젝트가 각각의 객체보다 더 큰 단위 이기에 형변환을 시켜줌)
	Book other = (Book)obj;
	
	if(title == null) {
		if(other.title != null) {
			return false;
		}
		}
	else if(!title.equals(other.title)) {
			return false;		
	}
	
	if(author == null) {
		if(other.author != null) {
			return false;
		}
		
	}
	else if(!author.equals(other.author)) {
		return false;	
		}
	
	//기본 자료형의 경우 값만 일치하는지 비교
	if(price != other.price) {
		return false;
	}
	
	//모든 조건을 통과하면 두 객체는 같은 객체
		return true;
}


// hashcode()
	@Override
	public int hashCode() {
		return(author+price+title).hashCode();
		
		//이렇게되면 똑같은 해쉬코드값을 받을 수 있음
		
		
}

	
}
