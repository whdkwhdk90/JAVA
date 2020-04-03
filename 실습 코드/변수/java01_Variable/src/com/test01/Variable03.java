package com.test01;

import java.util.Scanner;


public class Variable03 {

	public static void main(String[] args) {
		
		//public은 어디든 공유한다는 의미.????????????
		//static 그 클래스 안에서만 사용하겠다는 의미.?????????????
		
		
	 Variable03 test = new Variable03();
	 //클래스명 변수명 = new 클래스명();
	 
	 
	 test.changeValue();
		//변수명.메소드명();
	}
	
	//메서드는 기능
	
	
	//string은 heap 영역에 데이터가 들어가고 stack에서는 그 데이터의 주소를 가짐.
	
	
	
	
	public void changeValue() {
		
		//변수선언(스택영역에 할당)
		String name;
		char gender;
		int age;
		double height;
		
		
		//변수 초기화
		name = "이창진";
		gender = 'M';
		age = 19;
		height = 202.8;
		
		
		System.out.println(name+"님의 정보");
		System.out.println("성별: "+gender);
		System.out.println("나이: "+age);
		System.out.println("키: "+height);
		
		
		//키보드로 입력받아 변수에 저장된 값 변경
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름: ");
		name = sc.nextLine();
		
		System.out.print("성별: ");
		gender = sc.next().charAt(0);
		//문자를 읽는 메소드는 제공하지 않음, 그래서 charAt() 사용 !!   charAt(0)이면 가나다가 들어왔을때 '가'를 잘라서 가져감. charAt(1)이면 '나'를 잘라서 가져감. charAt(2)는 '다'를 잘라서 가져감.
		//nextline이랑 next는 둘다 문자열 입력받음(둘이 무슨 차이??) --next() : 한 문자나 한 단어 형식으로 받음(공백이 있으면 오류가 뜸). nextline()은 한 문장 전체를 받음(공백 상관없음).
		//패키지 안에 다른 클래스 선언해서 사용이 가능.
		
		
		System.out.print("나이: ");
		age = sc.nextInt();
		
		System.out.print("키: ");
		height = sc.nextDouble();
		
		System.out.println(name+"님의 정보");
		System.out.println("성별: "+gender);
		System.out.println("나이: "+age);
		System.out.println("키: "+height);
		
		
		
		
		
		
		
	}
	
	
	
}
