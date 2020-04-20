package com.test.chap01_runtimeException;

import java.util.Scanner;

public class RunExcepPrac {

	Scanner sc = new Scanner(System.in);	
	
	
	//RuntimeException -> ArithmeticException
	public void ArithEx() { //0으로 나눴을 때 발생하는 exception
		int ran = 0 ;
		double res =0.0;
		
		while(true) {
		ran = ((int)Math.random()*10)+1;
		System.out.print("나눌 수를 입력 : ");
		int no = sc.nextInt();
		
		if(no ==0) {
			System.out.println("0이 아닌 값 입력하세요!");
		}else {
			res = ran/(double)no;
			System.out.println(ran+"/"+no+"="+res);
			}	
		}		
	}
	
	
	public void ClassNArrayEx() {
		
//		//ClassCastException
//		Object obj = 'a';
//		System.out.println(obj);
		
		
		
//		//obj안에는 문자가 들어가있는데 string으로 형변환하려해서 에러 발생!!
//		String str =  (String)obj;
//		System.out.println(str);
		
		
		
		
		//ArrayIndexOutOfBoundsException
		// 배열에서 없는 방에 접근하려할때 발생
//		int[] arr = new int[2];
//		arr[0]  = 1;
//		arr[1] = 2;
//		
//		arr[4] = 3; //여기서 예외발생했기때문에 그 밑으로는 가지 않음.
//				//arr[4]에서 발생했기때문에 밑에 실행시키면 4라고출력됨.
//		System.out.println("출력문이 실행 될까요??");
		
		
		
		
//		try {
//		//NullPointerException
//		String str = null;
//		int len = str.length();
//		System.out.println(len);
//		}catch(NullPointerException e) {
//			System.out.println("널포인터 익셉션");
//			e.printStackTrace(); //에러가 났다는 것을 알려주기 위해 작성
//			//스택으로쌓여있는 애들을 출력하겠다.
//		}finally {
//			System.out.println("프로그램 종료");
//		}

		
		
		// 배열에서 없는 방에 접근하려할때 발생
		try {
		int[] arr = new int[2];
		arr[0]  = 1;
		arr[1] = 2;
		
		arr[4] = 3; //여기서 예외발생했기때문에 그 밑으로는 가지 않음.
				//arr[4]에서 발생했기때문에 밑에 실행시키면 4라고출력됨.
		System.out.println("출력문이 실행 될까요??");
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("ArrayIndexOutOfBoundsException 발생!!!");
//			e.printStackTrace();
		}catch(ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.out.println();
			e.printStackTrace();
		}finally {
			System.out.println("프로그램을 종료합니다.");
		}
		
		
		
		
		
		
		
	}
	
	
}
