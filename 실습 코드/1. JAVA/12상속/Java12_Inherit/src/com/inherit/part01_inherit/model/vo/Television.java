package com.inherit.part01_inherit.model.vo;

import java.util.Date;

public class Television extends Product {
		//product 클래스 상속 받아 구현
	
	private int inchType;
	
	public Television() {
		//super(); 요친구가 생략되어있음. 부모클래스의 생성자
	}
	public Television(String brand, String productNumber, String productCode, String productName, int price, Date date, int inchType) {
		super(brand,productNumber,productCode,productName,price,date);
		this.inchType = inchType;
		System.out.println("Product를 상속받은 TV 클래스의 생성자 호출");
	}
	
	//getter & setter( alt+shift+s)
	
	public int getInchType() {
		return inchType;
	}
	public void setInchType(int inchType) {
		this.inchType = inchType;
	}
	
	@Override
	public String prnInfo() {
		return super.prnInfo()+", "+ this.inchType; //이미 부모클래스에서 선언해놓은거 가져와서 씀.
									//혹시 모르니 this.을 붙임.(혹시나하는마음에 정확히 명시)
	}
	
}
