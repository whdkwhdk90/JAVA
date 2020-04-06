package com.test.chap01_encapsulation;


//객체 15쪽
public class Account {
	//필드
	private String name = "이창진";
	private String accNo = "01033334444";
	private String pw ="1234";
	private int bankcode = 20;
	private int balance = 0;
	
	//메소드
	//생성자(constructor)
	public Account() {}
	
	//입금을 위한 메소드
	public void deposit(int money) {
		if(money >0) {
			balance += money;
			System.out.println(name+"님의 계좌에 "+money+"원 입금!");
		}else {
			System.out.println("잘못된 금액입력!");
		}
	}
	
	//출금을 위한 메소드
	public void withdraw(int money) {
		if(money <=balance) {
			balance -= money;
			System.out.println(name+"님의 계좌에 "+money+"원 출금!");
		}else {
			System.out.println("잔액이 부족합니다.");
		}
	}
	
	//잔액 조회를 위한 메소드
	public void displayBalance() {
		System.out.println(name+"님의 잔액은 "+balance+"원 입니다.");
		
		
	}
	
	
	
	
}
