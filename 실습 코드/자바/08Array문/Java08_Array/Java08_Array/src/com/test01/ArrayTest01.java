package com.test01;

import java.util.Scanner;

public class ArrayTest01 {

	public void testArray() {
		//배열의 사용 이유
/*	int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		int num4 = 40;
		int num5 = 50;
		
		int sum = 0;
		
		sum += num1;
		sum += num2;
		sum += num3;
		sum += num4;
		sum += num5;
		
		*/
		
		//배열 선언 및 할당
		int[] arr = new int[5];
		
/*		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
////////////////////////////////////////////////////////
		for(int i = 0; i <arr.length; i++) {
			arr[i] = 10*i;
		}
		
		System.out.println("arr[0] : "  +arr[0]);
		System.out.println("arr[1] : "  +arr[1]);
		System.out.println("arr[2] : "  +arr[2]);
		System.out.println("arr[3] : "  +arr[3]);
		System.out.println("arr[4] : "  +arr[4]);
*/
		
		for(int i =0; i<arr.length; i++) {
			arr[i] = 10*i;
			System.out.println("arr ["+i+"] : " +arr[i]);
		}
	
		
		
	}
	
	public void testArray2() {
		//return;이 제일 끝에 숨겨져있는 애 : void(끝나도 반환값이 없음)
		
		//배열 선언
		//자료형[] 변수명;
		// 자료형 변수명[];
		
		//선언은 stack에 배열의 주소를 보관할 수 있는 공간을 만드는 것.
		// int[] iarr;
		// char carr[];
		
		//할당은 new 연산자를 이용하여 heap영역에 공간을 만드는 것.
		//iarr = new int[5];
		// carr = new char[3];
		
		//선언과 할당
		int[] iarr = new int[5];
		char carr[] = new char[10];
		
		System.out.println("iarr : " +iarr);
		System.out.println("carr : " +carr);
		
		//해쉬코드 : 실제주소값은 아니지만 주소값이라 생각해도 상관없다.
		// 실제 주소를 찾기 위한 key 역할
		
		System.out.println("iarr의 hashcode : " +iarr.hashCode());
		System.out.println("carr의 hashcode : " +carr.hashCode());
		
		//배열의 길이
		//String.length()   ---배열.length     ==> length() : 메서드 ,  length : 변수(필드)
		
		System.out.println("iarr의 길이 : " +iarr.length);
		System.out.println("carr의 길이 : " +carr.length);
		
		
		
		//스캐너로 입력받은 정수로 배열 길이 지정
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나를 입력하시오 : ");
		int size = sc.nextInt();
		
		double[] darr = new double[size];
//		int[] iarr2 = new int[sc.nextInt()];
		
		System.out.println("darr의 길이 : " + darr.length);
		System.out.println("darr의 hashcode : " +darr.hashCode());
		
		darr = new double[30];
		System.out.println("darr의 길이 : " + darr.length);
		System.out.println("darr의 hashcode : " +darr.hashCode());
		
		//삭제
		darr =null;
		System.out.println("삭제 후 darr의 길이 : "  +darr.length);
		//null이라는 특수한 값을 넣었을 때는 길이를 잴 수가 없음!! -- 오류발생(nullpointerException)

	}
	
	public void testArray3() {
		int[] iarr = new int[5];
		
		for(int i = 0; i < iarr.length; i++) {
			System.out.println("iarr["+i+"]의 값 : " + iarr[i]);
			
			//출력하면 배열에 0이라는 값 들어가있음. 이유는 ??
			//배열에 JVM이 지정한 초기값으로 들어감.
			
		}
			
			int[] iarr2 = {11,22,33,44,55,66,77,88};
			//int[] iarr2 = new int[]{11,22,33,44,55,66,77,88};
			System.out.println("iarr2의 길이 : " + iarr2.length);
			
			String[] sarr = {"apple", "banana", "orange"};
			for(int i = 0; i < sarr.length; i++) {
				System.out.println(sarr[i]);
				
			}
			
			
			
		
		
		
	}
	
	
	
	
	
}
