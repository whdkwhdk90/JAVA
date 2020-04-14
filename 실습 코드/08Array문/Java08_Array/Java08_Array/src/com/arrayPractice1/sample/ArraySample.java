package com.arrayPractice1.sample;

import java.util.Random;
import java.util.Scanner;

public class ArraySample {
	
	public void test1() {
		/*10개의 int 배열 선언하고 할당함
		 * 각 방에 1~100사이의 임의의 난수를 기록함
		 * java.util.Random클래스 사용함
		 * 10개의 정수들의 합계를 구하여 출력함
		 * 
		 * 
		 */
		
		int[] iarr = new int[10];
		int num;
		int sum = 0;
		Random rand = new Random();
		
		
		for(int i = 0; i < iarr.length; i++)
		{
			num = rand.nextInt(100) +1;        //nextint()안에 숫자를 넣으면 0~1사이로 고정. 안넣으면 -값도 나옴.
			//ar[i] = r.nextInt(100)+1; //1 ~100사이의 난수
			// sum += ar[i];
			// System.out.println(i+"방 값 :  " + ar[i]);
			
			System.out.println("num의 값은 " +num);
			iarr[i] = num;
		   sum += num;
		   
		}
		System.out.println(" sum :  " + sum);
		
		
	
		
	}
	
	public void test2() {
		int[] iarr = new int[10];
		int max=1;
		int min=0;;
		int num1;
	
		for(int i = 0; i < iarr.length; i++) {
			iarr[i] = (int)(Math.random()*100 +1);
			num1 = iarr[i];
			if(i==0) {
				max = num1;
				min = num1;
			}else {
								if(iarr[i] >= max) {
									max = iarr[i];
								}else {
									if(iarr[i] <= min) 
									{min = iarr[i];
											}
								}
				
				
			}
			
	}  System.out.println("제일 큰 수 : " +max + ", 제일 작은 수 : " +min);
		
	
	
	}
	
	public void test3() {

		byte[] barr = new byte[10];
		Random rand = new Random();
		int sum =0;
		
	for(int i = 0; i < barr.length; i++) {
		int num = rand.nextInt(140)+1;
		 barr[i] = (byte)num;
		 if(barr[i]%2 == 0) {
			 sum += barr[i];
		 }
		 
	} System.out.println("짝수들의 합 : " + sum);
	
	}
		
	public void test4() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;

		System.out.print("문자열 입력: ");
		String str = sc.nextLine();
		
		for( int i = 0; i < str.length();i++) {
			sum +=   Integer.parseInt(str.substring(i,i+1));
			//i부터 뒤에 숫자는 포함안됨.
		}
		System.out.println("합계: "+sum);
		
	}

	public void test5() {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String str = sc.next();
		int sum = 0;		
		int num;
		for(int i = 0 ; i <str.length(); i++) {
			//num = str.charAt(i) - '0'; //유니코드 값을 계산해서 
			num = Character.getNumericValue(str.charAt(i));  //character.getnumericvalue는 문자를 숫자로 형태 변환!!!
			sum += num;
		}
		System.out.println("합계 : " + sum);
		
	}


}
