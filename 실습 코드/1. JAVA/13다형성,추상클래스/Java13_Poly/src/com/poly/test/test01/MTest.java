package com.poly.test.test01;

public class MTest {

	public static void main(String[] args) {
		Cat cat = new Cat();
		Animal dog = new Dog();
		//오버라이딩이 중요한게 아님.
		//dog의 eat관련된 메소드 지우면 animal에 있는 eat이 출력
		
		cat.bark();
		dog.bark();

		
		cat.eat("고등어");
		dog.eat("뼈다귀");
		
		
		
		
		
	}

}
