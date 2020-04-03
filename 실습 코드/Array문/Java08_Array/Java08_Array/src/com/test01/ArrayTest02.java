package com.test01;

public class ArrayTest02 {
	public static void main(String[] args) {
		//1. a~z 일차원 배열 출력
		
		char[] ch = new char[26];
		
		for(int i = 0; i < ch.length; i++) {
			ch[i] =(char)((int)'a'+i);
			
		}	
//		ArrayTest02.prn(ch);
		
		//2. 1번에서 만든 배열을 거꾸로 출력
//		ArrayTest02.reverse(ch);
		
		//3. 1번에서 만든 배열을 대문자로 바꾸어 출력
		upper(ch);
		
		
	}
	
	public static void prn(char[] ch) {
		for(int i =0; i < ch.length; i++) {
			System.out.print(ch[i]+ " ");
				if(i%6 ==5) {
					System.out.println();
				}
		}
		System.out.println();
	}
	
	public static void reverse(char[] ch) {
		char re[] = new char[26];
		int temp =0;
		
		for(int i = re.length -1; i >=0 ; i--) {
			re[temp] = ch[i];
			temp ++;
			
		
		}ArrayTest02.prn(re);
		
		
		
	}
	
	public static void upper(char[] ch) {
		char re[] = new char[26];
		
		for(int i = 0; i< re.length; i++ )
		{
		  // ch[i]=   	(char)((int)ch[i]-32);
			// java.lang은 import하지 않아도 JVM이 자동으로 포함시켜 처리하는 패키지이다.  //touppercase : 소문자 ㅡ> 대문자
			  ch[i] = Character.toUpperCase(ch[i]);
		   
		}
		
		prn(re);
	}
	
	//얕은 복사 : 주소값만 복사(주소값만 복사했기때문에 heap은 공유)
	//깊은 복사 : 데이터값을 복사(데이터도 복사해서 heap을 공유하지않음)
	
	
	
	
}
