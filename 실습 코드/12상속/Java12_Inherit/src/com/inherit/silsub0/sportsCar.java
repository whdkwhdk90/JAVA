package com.inherit.silsub0;

public class sportsCar extends Car {
	
	public sportsCar() {
		super();
		System.out.println("sportsCar생성");
	}

	public sportsCar(String color) {
		super(color);   //빨간줄이 뜨는건 이렇게 1개만 받아서 처리하는 생성자가 없음.
						//Car에 1개의 매개변수를 받는 생성자를 생성해주면 빨간줄 안뜸.
	System.out.println(color+"색 sportsCar 생성");	
	}
	
	
	@Override
	public void accelPedal() {
		System.out.println("속도가 더 빨리 올라갑니다.");
		super.setSpeed(super.getSpeed() + 30);
	}	
		
		
	@Override	
	public void breakPedal() {
		super.setSpeed(super.getSpeed()-30);
		if(super.getSpeed() > 0 ) {
			System.out.println("속도가 더 빨리 줄어듭니다.");
			}
		else {
			super.setSpeed(0);
			System.out.println("멈췄습니다.");
		}
	}
		
	@Override
	public String toString() {
		return "sportsCar의 현재 속도는 "+this.getSpeed()+ "입니다.";
	}
	
	
	
	
}
