package com.inherit.silsub0;

public class Run {
	public static void main(String[] args) {
		
		sportsCar c1 = new sportsCar("노란");
		c1.accelPedal();
		System.out.println(c1.toString());  //c1으로 적으나 c1.toString으로 적으나 같이 나옴
		//toString은 해당하는 객체안의 필드값을 확인하는 용도로 사용
		//Override사용안했으면 object안에 있는 tostring을 사용하게됨.
		//sportscar의 tostring을 주석처리하면 car라는 부모 클래스의 tostring 실햄
		// 부모클래스꺼도 주석처리하면 object에 있는 tostring이 실행하게됨.
		c1.accelPedal();
		c1.accelPedal();
		System.out.println(c1);
		
		
		////////////////////////////////////
//		Car c =  new sportsCar(); 
		//부모 클래스의 변수 안에 자식클래스의 객체들이 들어가는게 다형성
		
		Car c2 = new SUV("검정");	//다형성
		c2.accelPedal();
		System.out.println(c2.toString());
		c2.accelPedal();
		c2.accelPedal();
		System.out.println(c2.toString());
		c2.breakPedal();
		c2.breakPedal();
		c2.breakPedal();
		c2.breakPedal();
		System.out.println(c2.toString());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
