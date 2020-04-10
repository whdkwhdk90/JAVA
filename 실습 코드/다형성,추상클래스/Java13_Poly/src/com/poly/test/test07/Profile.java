package com.poly.test.test07;

public class Profile {
	private String name;
	private String phone;
	
	
	public Profile() {}
	public Profile(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
		
	}
	
	public void printProfile() {
		System.out.println("이름 : "+name);
		System.out.println("전화번호 : "+phone);
	}
	
	
	
	
}
