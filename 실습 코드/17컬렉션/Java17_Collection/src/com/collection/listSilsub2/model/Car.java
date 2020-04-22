package com.collection.listSilsub2.model;

public class Car {

	private int CarNum;
	private int CarType;
	private String owner;
	
	public Car() {}

	public Car(int carNum, int carType, String owner) {
		super();
		CarNum = carNum;
		CarType = carType;
		this.owner = owner;
	}

	
	
	public int getCarNum() {
		return CarNum;
	}

	public void setCarNum(int carNum) {
		CarNum = carNum;
	}

	public int getCarType() {
		return CarType;
	}

	public void setCarType(int carType) {
		CarType = carType;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		String type = "";
		
		if(CarType ==1) {
			type = "경차";
		}if(CarType ==2) {
			type = "세단";
		}if(CarType ==3) {
			type = "SUV";
		}if(CarType ==4) {
			type = "트럭";
		}
		
		return " [차번호 = " + CarNum + ", 차종 = " + CarType + ", 차주 = " + owner + "]";
	}
	
	
	
	
	
	
	
}
