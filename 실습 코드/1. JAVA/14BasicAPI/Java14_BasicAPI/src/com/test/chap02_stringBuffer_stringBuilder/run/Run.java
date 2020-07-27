package com.test.chap02_stringBuffer_stringBuilder.run;

public class Run {

	/*
	 * StringBuffer, StringBuilder의 특징
	 * -mutable클래스, 변경과 저장을 위한 메모리공간(버퍼)을 내부에 지닌다.
	 * -버퍼의 초기값 16개의 문자를 저장 가능하다. 자동으로 증가(캐퍼시티)
	 *(둘의 차이는 쓰레드 safety의 지원 여부 차이)
	 */

	public static void main(String[] args) {
		
//		Run.method1();
//		Run.method2();
		Run.method3();
	}

	
	public static void method1() {
		StringBuilder sb = new StringBuilder("내일만 나오면 휴일");
		System.out.println(sb.length());  //10
		System.out.println(sb.capacity());  //16(기본용량)+ 10
		
		StringBuilder sb1 = new StringBuilder(21); 
		System.out.println(sb1.capacity());  //기본용량 수정가능(21로 지정)
		
		System.out.println(sb);
		
	}
	
	
	public static void method2() {
	String str = "반가워! ";
	System.out.println("str 기존 : "+str+", 주소 : "+str.hashCode());
	str += "나는 String이라고 해";
	System.out.println("str 추가 후 : "+str+", 주소 : "+str.hashCode());
	//주소값이 달라짐.
	//string에선 append 사용 못함
	
	
	
	
	StringBuffer sbf = new StringBuffer("안녕! ");
	System.out.println("sbf 기존 : "+sbf+", 주소 : "+ sbf.hashCode());
	sbf.append("난 StringBuffer얌!");
	System.out.println("sbf 추가 후 : "+sbf+", 주소 : "+ sbf.hashCode());
	//주소값이 달라지지 않음.
	//append로 추가하면 주소값은 변경되지않는듯
	
	StringBuilder sbd = new StringBuilder("하이~ ");
	System.out.println(sbd+"의 주소 : "+sbd.hashCode());
	sbd.append("난 StringBuilder지");
	System.out.println(sbd+"의 변경 후 주소: "+sbd.hashCode());
	
	
	}
	
	
	public static void method3() {
		StringBuffer sb = new StringBuffer("저는 ");	
		//append
		sb.append("배가 불러요~ ");
		sb.append("~~!");
		System.out.println(sb);
		
		
		StringBuilder sb1 = new StringBuilder("나는 ");
		//append
//		sb1.append("배가 불러요~ ");
//		sb1.append("~~!");
		
		//메서드 체이닝(chaining) -마치 체인처럼 연결되서 작성하는 구조.
		sb1.append("배가 불러요~").append(" ~~!");
		System.out.println(sb1);
		
		//insert
		//insert안에 있는 숫자는 charAt처럼 문자열의 index처럼 생각하면됨.
		//그래서 0을 넣고 출력하면 맨앞에 뒤에 문자열이 출력하고 그다음 위에 문장 출력.
		sb.insert(0, "점심을 먹어서 ");
		System.out.println(sb);
		
		//delete 
		//delete는 substring처럼 2부터 9전까지 즉, 2부터 8위치까지 삭제함.
		sb.delete(2, 9);
		System.out.println(sb);
		
		//reverse 
		//reverse는 말그대로 역순 출력
		sb.reverse();
		System.out.println(sb);
		
		
		
	}
	
}
