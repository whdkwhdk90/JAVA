package example.copy;

import java.util.Scanner;


//field 선언 !!
//메소드랑 필드(변수)로 구성되어있다!!


public class ForWhile {

	
	Scanner sc = new Scanner(System.in);
	// 요 친구는 클래스 안에서 사용 가능하다
	//클래스 안에서 선언했기때문에!!
	
	
	
	public void printStar1() {
			
		int num = sc.nextInt();
		
/*		if( num >0 ) {
						for(int i = 1; i <= num; i++) {
							
									for(int j = 1; j <= num; j++) {
												 
												if(i ==j) {
													System.out.print(i);
												}
												
												if( i < j) {
													System.out.println();
													break;
												}
												
											 if(i != j) {	System.out.print("*");
											 }
												}
								
									}
						}
			
		else {
			System.out.println("양수가 아닙니다");
		}
		
		
	*/
	
	if(num > 0) {
		for(int i = 1; i <= num; i++) {
				for(int j = 1; j <= i; j++) {
					if( i ==j) {
						System.out.print(i);
					}else {
						System.out.print("*");
					}
				}System.out.println();
			
			
		}
		

	} else {
		System.out.println("양수가 아닙니다");
	}
		
		
		
	
	
	
	}	
	
	public void printStar2() {
		
		int num = sc.nextInt();
		
		if( num > 0) {
			for(int i = 1; i <= num; i++) {
					for(int j = 1; j <= i; j++) {
						
					System.out.print("*");
						
					}System.out.println();			
		}

		} else if( num <0) {
			 
			for(int i = 1; i <= -num; i++) {
				for(int j = -num; j >= i; j--) {
					
				System.out.print("*");
					
				}System.out.println();			
	}
			
	
		} else {
			System.out.println("출력 기능이 없습니다.");
		}
		
	}
	
	public void selectMenu() {
		
		String answer = "";
		String menu = "";
		String str = "";
		int sum =0;
		int total = 0;
		int count = 0;
		int price =0;
		
		do {
			System.out.println("*** 메뉴를 선택하세요 ***");
			System.out.println();
			System.out.println("햄버거 *******************");
			System.out.println("1. 불고기버거      3500원");
			System.out.println("2. 치킨버거         3200원");
			System.out.println("추가  *********************");
			System.out.println("3. 감자튀김         1000원");
			System.out.println("4. 치즈스틱          400원");
			System.out.println("5. 샐러드            2000원");
			System.out.println("5. 샐러드            2000원");
			System.out.println("음료수 ********************");
			System.out.println("6. 콜라                 700원");
			System.out.println("7. 에이드            1200원");
			System.out.println("8. 커피               1000원");
			System.out.print("메뉴 선택 : ");
			int num1 = sc.nextInt();
			
			switch(num1) {
			case 1:
				menu = "불고기버거";
				str += "불고기버거";
				price = 3500;
				break;
			case 2:
				menu = "치킨버거";
				str += "치킨버거";
				price = 3200;
				break;
			case 3:
				menu = "감자튀김";
				str += "감자튀김";
				price = 1000;
				break;
			case 4:
				menu = "치즈스틱";
				str += "치즈스틱";
				price = 400;
				break;
			case 5:
				menu = "샐러드";
				str += "샐러드";
				price = 2000;
				break;
			case 6:
				menu = "콜라";
				str += "콜라";
				price = 700;
				break;
			case 7:
				menu = "에이드";
				str += "에이드";
				price = 1200;
				break;
			case 8:
				menu = "커피";
				str += "커피";
				price = 1000;
				break;
			}
			
			System.out.println(menu + "를(을) 선택하셨습니다.");
			System.out.print("수량은? : ");
			count = sc.nextInt();
			System.out.println(count + "개 주문하셨습니다. " );
			sum = price*count;
			
			str += " : " +count + "개-  " + sum + "원" + "\n";
			total += sum;
			
			System.out.println();
			System.out.print("계속 주문하시겠습니까?(y/n)  : ");
			answer = sc.next();
			
		}while(answer.contentEquals("Y") || answer.equals("y"));
		
		System.out.println("주문하신 정보는 다음과 같습니다.");
		System.out.println("--------------------------------------");
		System.out.println(str);
		System.out.println("--------------------------------------");
		System.out.println("총 가격 : "+ total);
		
	}
	
	
	
	public void countInputCharacter() {
		char ch = ' ';
		boolean bo = false;
		
		int count = 0;
					
		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();
		int num =  str.length();
		
	//(str.charAt(i) < 'a' && str.charAt(i) > 'z') || (str.charAt(i) < 'A' && str.charAt(i) > 'Z')
		
for(int i =0; i < num; i++)
	
	{	
		if(!(str.charAt(i)>'A'&&str.charAt(i)<='z')) 
		{
			System.out.println("영문자가 아닙니다.");
			bo = true;
			break;
	
		}
		
		
	}
			

while(bo != true)
	{System.out.print("문자 입력: ");
    ch = sc.next().charAt(0);
    
	
    
	

			for(int j =0; j < num; j++)
			{
				
			 if(ch == str.charAt(j))
			 {
					count++;
			 }	
								
			}
			
	System.out.println("포함된 갯수 : " +count + "개");
			
			
				break;	
		}
		
	}
}

