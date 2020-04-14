package com.silsub2.book.model;

public class Book {
	//필드
	private String title;
	private String author;
	private String publisher;
	private int price;
	
	//생성자
	//기본생성자
	public Book() {}
	
	//매개변수생성자
	public Book(String title, String author, String publisher, int price) {
		
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;	
	}
	
		//getter / setter
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}   //외부의 정보를 필드에 저장
	
	
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}   //외부의 정보를 필드에 저장
	
	
	
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}   //외부의 정보를 필드에 저장
	
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}   //외부의 정보를 필드에 저장
	
	
	public String info() {
		return title+", "+ author +", "+publisher+", "+price;
	}
	
	
}
