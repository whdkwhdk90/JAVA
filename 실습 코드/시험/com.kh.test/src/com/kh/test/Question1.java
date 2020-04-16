package com.kh.test;

import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {

			Scanner sc= new Scanner(System.in);
			
			System.out.println("가위바위보 게임을 시작합니다.");
			
			
			do {
				System.out.print("가위 바위 보 중 택1 : ");
				String input = sc.nextLine();
				
				System.out.println(input);
				int random = (int)(Math.random()*3);
				boolean win = false;
				String computer = "";
				
				switch(random) {
				case 0 : computer = "가위"; 
				break;
				
				case 1 : computer = "바위";
				break;
				
				case 2 : computer = "보";
				break;
				
				}
				
				System.out.print("컴퓨터 : " + computer+"를 냈습니다.");
				System.out.println();
				
				if(computer.equals(input)) {
					System.out.println("비김");
					continue;
				}else {
						win = false;
				}
				
				if(computer.equals("가위")) {
					if(input.equals("바위")) {
						win = true;
					}
				}else if(computer.equals("바위")){
					if(input.equals("보")) {
						win = true;
					}
				}else {
					if(input.equals("가위")) {
						win =true;
					}
				}
			
				if(win) {
					System.out.println("이겼다");
					
				}else {
					System.out.println("졌다");
					
				}
					
			}while(true);
			
			
			
			
			
	}

}
