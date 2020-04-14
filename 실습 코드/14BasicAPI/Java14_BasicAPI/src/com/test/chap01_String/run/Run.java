package com.test.chap01_String.run;

public class Run {
	//String
	//immutable(불변), 변경은 적고, 읽기가 많은 경우 사용 적합
	
	public static void main(String[] args) {
//		Run.method1();
		Run.method2();
		
	}

	public static void method1() {
		//1. 문자열을 리터럴로 생성
		String str = "abc";
		String str1 = "abc";
		System.out.println(str);
		System.out.println(str1);
		System.out.println(str.hashCode());
		System.out.println(str1.hashCode());
		//해쉬코드가 같은걸 알 수 있음.
		
		//처음에 abc를 초기화하고 두번째 abc초기화 하기 전에
		//String Pool에 abc라는 값이 있나 검색을 하고 초기화하게 됨.
		
		//abc라는게 이미 있기 때문에 추가적으로 공간 할당을 안하게됨(두개가 같은 abc를 지목함)
		
		//JVM이 String Pool에 등록시키고 리터럴로 문자열 생성할 때
		//동일한 값이 다시 호출될 때에는 String Pool에 등록된 값을 리턴.
		System.out.println();
		//2. 생성자를 통한 문자열 생성
		String str2 = new String("abc");
		String str3 = new String("abc");
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		//같은 abc에 대해서 hashcode가 override되서 해쉬코드 값이 같게 나옴.
		
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		//그러나 실제의 hashcode값은 다름.(new 연산자에 의해서)
		
		System.out.println(System.identityHashCode(str));
		System.out.println(System.identityHashCode(str1));
		//str과 str1은 new연산자를 이용해서 한게 아니기에 실제 주소값이 같음.
		
		
		
	}
	
	
	public static void method2() {
	//charAt(index)
		String str = "abc";
		System.out.println(str.charAt(1));
		
		//concat() : 합치기
		System.out.println(str.concat("def"));
		
		//contains() : 포함 여부
		//ac라는 값 있나?  :없으면 false
		System.out.println(str.contains("ac"));
		
		//equals() : 비교
		//str이랑 괄호안이 같냐? : 맞으면 true
		System.out.println(str.equals("abc"));
		
		//length() : 길이
		System.out.println(str.length());
		
		//split()  vs.  Stringtokenizer
		//스플릿은 잘라서 배열안에 넣어두는게 특징!!
		String str1 = "a,b,c,def";
		String[] strArr = str1.split(",");
		//,를 기준으로 각각의 문자들을 잘라서 배열에 들어가게 함.
		for(int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
		//향상된 for문  (for each문)
		//strArr의 첫번째 값을 arr에 넣어둠. 그다음 출력
		//처음부터 끝까지 계속 그런식으로 반복.
		//**주의 할 것 : 모든 타입이 같으면 상관없지만 다르면 안되기에 신경써서 할 것.
		for(String arr : strArr) {
			System.out.println(arr);	
		}
		
		//toUpperCase() : 대문자로 바꿔줌
		System.out.println(str.toUpperCase());
		
		//substring() : 잘라내기( substring(2,5) : 2,3,4위치까지 구간 커트)
		System.out.println(str1.substring(2,5));
		
		//trim() : 공백제거
		//trim()을 이용하면 문자와 문자 사이 중간 공백은 사라지지 않지만 그 외의 부분은 사라짐.
		String str2 = "     ab c  ";
		System.out.println(str2.trim());
		
		//앞의 " "를 뒤에 ""로 바꾸겠다.(즉, 공백을 없애겠다)
		System.out.println(str2.replaceAll(" ",""));
		
		
		
		
	}
	
	
	
}
