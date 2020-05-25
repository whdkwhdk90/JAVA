package com.test01;

public class MethodTest01 {

	public static void main(String[] args) {
	
	//static method 사용
	//1. 클래스명.메소드명(); -이렇게 사용하는게 더 좋음.(위치를 알 수 있음)
		
	MethodTest01.publicMethod();
	MethodTest01.protectedMethod();
	MethodTest01.defaultMethod();
	MethodTest01.privateMethod();
		
	//2. 메소드명();
	defaultMethod();
	privateMethod();
		
	
	//3. non static 불러오기
	MethodTest01 MT = new MethodTest01();
	
	MT.NonstaticMethod();
	// MT.privateMethod(); //접근은 되는데 비추천. 그냥 static이니 바로 호출하는게 더 좋음.
	
	
	}
	
	
	//접근제한자(public, protected, default, private)
	
	//어디서나 접근가능, ( + ) - 문서상에서 class앞에 +붙어있으면 public임.
	public static void publicMethod() {
		System.out.println("public Method()");
	}
	
	//상속일 경우 상속된 곳에서, 상속이 아닌 경우 같은 패키지 내에서 ( # ) - 문서상에서 class앞에 #붙어있으면 protected임.
	protected static void protectedMethod() {
		System.out.println("protected Method()");
	}
	
	//같은 패키지 내에서 (default)
	static void defaultMethod() {
		System.out.println("default Method()");
	}
	
	//현재 클래스 안에서만 접근이 가능 (-) - 문서상에서 class앞에 -붙어있으면 private임.
	private static void privateMethod() {
		System.out.println("private Method()");
	}
	
	
	
	//static 메서드는 오직 static메서드만 접근 가능. static 영역에 static이라고 정의된 class들은 다 올라가 있음.  static이 더 상위개념임.
	
	
	public void NonstaticMethod() {
		System.out.println("non static Method()");
	}
	
	
	
	
	
	
	
	
	
}
