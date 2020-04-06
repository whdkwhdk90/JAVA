package com.test.chap01_encapsulation;

public class Main {
		public static void main(String[] args) {
			//객체 생성
			
		//	Account a = new Account();
		//	System.out.println(a.name);
		//	System.out.println(a.balance);
		//	a.name = "홍길동";
		//	a.balance = 1000000;
		//	System.out.println(a.name);
		//	System.out.println(a.balance);
			//필드에 바로 접근했는데 이러면 안됨. 캡슐화가 없었음.
			//account에있는 string을 다 private화 시키면 메인이 안됨.
			
			
			Account a = new Account();
			//100만원 입금
			a.deposit(1000000);
			a.displayBalance();
			//150추가 입금
			a.deposit(1500000);
			a.displayBalance();
			//50만원 출금
			a.withdraw(500000);
			a.displayBalance();
			
			//a.blance -= 2000000; 이런식으로는 안됨(초과를 해버림)
			
		}
}
