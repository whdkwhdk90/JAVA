package com.test01;

import java.util.Scanner;

public class WhileTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	WhileTest01.testWhile();
	//	WhileTest01.testWhile2();
	//	WhileTest01.testWhile3();
	//	WhileTest01.testWhile4();
		WhileTest01.testWhile4_2();
	}

	public static void testWhile() {
		int i = 1;
		while(i <10) {
			System.out.println(i+"번째 반복문 수행!");
			i++;
		}
		
		System.out.println("while이 종료된 i의 값 : " + i);
		
	}
	
	public static void testWhile2() {
		// 문자열을 입력받아 인덱스 별로 문자를 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 입력 : ");
		String str = sc.next();
		
/*		System.out.println(str.charAt(0));
		System.out.println(str.charAt(1));
		System.out.println(str.charAt(2));
		System.out.println(str.charAt(3));
		System.out.println(str.charAt(4));
*/		
		
		int i = 0;
		while(i <str.length()) {
			//str.length하면 길이를 되돌려받을 수 있음. (apple 입력하면
			// str. length는 5가 나옴. (그래서 i가 0부터 시작하니까 5번반복할 수 있음!)
			char ch = str.charAt(i);
			System.out.println(i+ " : " + ch);
			i++;
		}
		
		
		
	}
	
	public static void testWhile3() {
		//1부터 입력받은 수까지 정수들의 합
		//ex) 1+2+3+4+5
		
		int sum = 0;
		
		Scanner sc= new Scanner(System.in);
		
		System.out.print("정수 하나를 입력하시오 : ");
		int num = sc.nextInt();
		
		
		int i =1;
		
		while(i <= num) {
			
			sum = sum +i;
			i++;
		}
		System.out.println("1부터 입력한 정수까지의 합은 " +sum + "입니다. ");
		
		//while의 조건문은 true를 만족하면 계속 돈다. false나오면 그때 종료
		
	}
	
	public static void testWhile4() {
		int i=1;
		//무한루프
		while(true){
			System.out.println(i);
			i++;
			
			if(i==10) {
				break;
			}
			
		}
		
		
		
		
	}
	
	public static void testWhile4_2() {
		//키보드로 4를 입력 받을 때 까지 반복,
		//4가 입력되면 while문 종료
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("숫자를 입력하시오 : ");
			int num = sc.nextInt();
			
							if(num ==4) {
								System.out.println("4입력!! 종료!!");
								break;
							}
		}
		
		
		
	}
	
}
