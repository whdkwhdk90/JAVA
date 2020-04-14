package com.silsub1.example;

import java.util.Scanner;

public class ForWhile {

	Scanner sc = new Scanner(System.in);
	
	
	public void printStar1() {
		
		System.out.print("정수를 입력: ");
		int row=sc.nextInt();
		
		if(row>0) {
			
			for(int r=1;r<=row;r++) {
				for(int c=1; c<=r ;c++) {
					if(r==c) {
						System.out.print(r);
					}else {
						System.out.print("*");
					}
				}
				System.out.println();
			}
		}else {
			System.out.println("양수가 아닙니다.");
		}

	}
	public void printStar2() {
		
		System.out.print("정수 하나 입력:");
		int num=sc.nextInt();
		if(num>0) {
			
			for(int r=1;r<=num;r++) {
				for(int c=1;c<=num;c++) {
					System.out.print("*");
					if(r==c) {
						break;
					}
				}
				System.out.println();
			}
		}else if(num==0) {
			
			System.out.println("출력 기능이 없습니다.");
			
		}else {
			for(int r=1;r<=Math.abs(num);r++) {
				for(int c=Math.abs(num);c>=1;c--) {
					System.out.print("*");
					if(r==c) {
						break;
					}
				}
				System.out.println();
			}	
		}

	}
	
	public void selectMenu() {
		//내가 해본 코딩
		System.out.println("***메뉴를 선택하세요***");
		System.out.println();
		System.out.println("햄버거 ***************");
		System.out.println("1. 불고기버거	3500원");
		System.out.println("2. 치킨버거	3200원");
		System.out.println("추가 ****************");
		System.out.println("3. 감자튀김	1000원");
		System.out.println("4. 치즈스틱	400원");
		System.out.println("5. 샐러드		2000원");
		System.out.println("음료수 ***************");
		System.out.println("6. 콜라		700원");
		System.out.println("7. 에이드		1200원");
		System.out.println("8. 커피		1000원");
		System.out.println("********************");
		
		
		int sum=0;
		int total=0;
		String res ="";
		String name="";
		int count=0;
		
		String again="";
		for(;;) {
						
			System.out.print("메뉴 선택 : ");
			int choose =sc.nextInt();
			switch(choose) {
				case 1:
					name="불고기 버거";
					System.out.println(name+"를(을) 선택하셨습니다.");
					System.out.print("수량은 ? ");
					count=sc.nextInt();
					sum = count*3500;
					total+=sum;
					res+= name+" : "+count+"개 - "+sum+"원\n";
					
					break;
				case 2:
					name="치킨 버거";
					System.out.println(name+"를(을) 선택하셨습니다.");
					System.out.print("수량은 ? ");
					count=sc.nextInt();
					sum = count*3200;
					total+=sum;
					res+= name+" : "+count+"개 - "+sum+"원\n";
					
					break;
				case 3:
					name="감자튀김";
					System.out.println(name+"를(을) 선택하셨습니다.");
					System.out.print("수량은 ? ");
					count=sc.nextInt();
					sum = count*1000;
					total+=sum;
					res+= name+" : "+count+"개 - "+sum+"원\n";
					break;
				case 4:
					name="치즈스틱";
					System.out.println(name+"를(을) 선택하셨습니다.");
					System.out.print("수량은 ? ");
					count=sc.nextInt();
					sum = count*400;
					total+=sum;
					res+= name+" : "+count+"개 - "+sum+"원\n";
					break;				
				case 5:
					name="샐러드";
					System.out.println(name+"를(을) 선택하셨습니다.");
					System.out.print("수량은 ? ");
					count=sc.nextInt();
					sum = count*2000;
					total+=sum;
					res+= name+" : "+count+"개 - "+sum+"원\n";
					break;
				case 6:
					name="콜라";
					System.out.println(name+"를(을) 선택하셨습니다.");
					System.out.print("수량은 ? ");
					count=sc.nextInt();
					sum = count*700;
					total+=sum;
					res+= name+" : "+count+"개 - "+sum+"원\n";
					break;
				case 7:
					name="에이드";
					System.out.println(name+"를(을) 선택하셨습니다.");
					System.out.print("수량은 ? ");
					count=sc.nextInt();
					sum = count*1200;
					total+=sum;
					res+= name+" : "+count+"개 - "+sum+"원\n";
					
					break;
				case 8:
					name="커피";
					System.out.println(name+"를(을) 선택하셨습니다.");
					System.out.print("수량은 ? ");
					count=sc.nextInt();
					sum = count*1000;
					total+=sum;
					res+= name+" : "+count+"개 - "+sum+"원\n";
					break;
				default:
					System.out.println("입력을 잘못하셨습니다.");
					
			}
			System.out.print("추가로 주문하시겠습니까?(y/n) : ");
			again=sc.next();
			if(again.equals("y")||again.equals("Y")) {
				continue;
			}else {
				break;
			}
			
		}
		System.out.println("------------------------");
		System.out.println(res);
		System.out.println("------------------------");
		System.out.println("총 가격 : "+total+"원");
		
	}
	
	public void selectMenu2() {
		// 강사님의 코딩
		String answer="";
		String menu="";
		String str="";
		int sum=0;
		int total=0;
		int count=0;
		int price=0;
		
		do {
			System.out.println("***메뉴를 선택하세요***");
			System.out.println();
			System.out.println("");
			System.out.println("햄버거 ***************");
			System.out.println("1. 불고기버거	3500원");
			System.out.println("2. 치킨버거	3200원");
			System.out.println("추가 ****************");
			System.out.println("3. 감자튀김	1000원");
			System.out.println("4. 치즈스틱	400원");
			System.out.println("5. 샐러드		2000원");
			System.out.println("음료수 ***************");
			System.out.println("6. 콜라		700원");
			System.out.println("7. 에이드		1200원");
			System.out.println("8. 커피		1000원");
			System.out.println("********************");
			System.out.print("메뉴 선택 (번호로 입력): ");
			int num1 = sc.nextInt();
			switch(num1) {
			case 1:
				menu="불고기 버거";
				str+="불고기 버거";
				price=3500;
				break;
			case 2:
				menu="치킨 버거";
				str+="치킨 버거";
				price=3200;
				break;
			case 3:
				menu="감자튀김";
				str+="감자튀김";
				price=1000;
				break;
			case 4:
				menu="치즈스틱";
				str+="치즈스틱";
				price=400;
				break;
			case 5:
				menu="샐러드";
				str+="샐러드";
				price=2000;
				break;
			case 6:
				menu="콜라";
				str+="콜라";
				price=700;
				break;
			case 7:
				menu="에이드";
				str+="에이드";
				price=1200;
				break;
			case 8:
				menu="커피";
				str+="커피";
				price=1000;
				break;
				
			}
			System.out.println(menu+"를(을) 선택하셨습니다.");
			System.out.print("수량은? : ");
			count=sc.nextInt();
			System.out.println(count+"개 주문하셨습니다.");
			
			sum=price*count;
			
			str += " : " + count + "개 - "+sum+"원"+"\n";
			total+=sum;
			System.out.println();
			System.out.print("계속 주문하시겠습니까?(y/n) : ");
			answer=sc.next();
			
		}while(answer.equals("Y")||answer.equals("y"));
		
		
		System.out.println("* 주문하신 정보는 다음과 같습니다. *");
		System.out.println("---------------------------------");
		System.out.println(str);
		System.out.println("---------------------------------");
		System.out.println("총 가격 : "+total+"원");
		
	}
	
	public void countInputCharacter() {
		
		System.out.print("문자열 입력: ");
		String str=sc.nextLine();
		System.out.print("문자 입력: ");
		char str2=sc.next().charAt(0);
		
		int count=0;
		boolean off = false;
		
		for(int i=0; i<str.length();i++) {
			if(str.charAt(i)>='A' && str.charAt(i)<='z') {
				char str3 = str.charAt(i);
				if(str3==str2) {
					count++;
				}
			}else {
				System.out.println("영문자가 아닙니다.");
				off=true;
				break;
			}
			
		}
		if(off==false) {
			System.out.println("포함된 갯수 : "+count+"개");
		}

		
	}
	
	public void countInputCharacter2() {
		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();

		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);

			if (!(temp >= 'a' && temp <= 'z' || temp >= 'A' && temp <= 'Z')) {
				System.out.println("영문자가 아닙니다.");
				return;
			}
		}

		System.out.print("문자 입력 : ");
		char ch = sc.next().charAt(0);

		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (ch == str.charAt(i)) {
				count++;
			}
		}

		System.out.println("포함된 갯수 : " + count + "개");
		
		
	}
}
