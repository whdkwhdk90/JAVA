package com.inherit.silsub0;


public class Car {
	
			private String color;
			private int speed;
			
			
		//생성자(기본 및 매개변수)		
		public Car() {}
		public Car(String color, int speed) {
			this.color = color;
			this.speed = speed;
		}

		//getter & setter
		public String getColor() {
				return color;
			}
		public void setColor(String color) {
				this.color = color;
			}
			
			
			
		public int getSpeed() {
				return speed;
			}
		public void setSpeed(int speed) {
				this.speed = speed;
			}
		
			//public String prnInfo() {
			//	return "색상 : "+this.color+", 스피드 : "+this.speed;
			//}
		
			
		public void accelPedal() {
				System.out.println("속도가 올라갑니다.");
				setSpeed(getSpeed()+10);   //입력받은 값에 10을 증가시켜서 저장하겠다.
			}
			
		public void breakPedal() {
				setSpeed(getSpeed()-10);	//입력받은 값에 10을 감소시켜서 저장하겠다.
				
				if(getSpeed() >0) {
					System.out.println("속도가 내려갑니다.");
				}else {
					System.out.println("정지하였습니다.");
					setSpeed(0);
				}
			}
		@Override						//상속을 받게되면 유지보수가 편하다.
		public String toString() {		//부모 클래스에 있던 toString을 가져와서 재정의or 재수정했다.
			return "현재 속도는 "+speed+"입니다.";		//현재 이 객체의 필드값 확인
		}	
			
			
			
			
			
		
}
