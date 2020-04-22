package com.collection.listSilsub.controller;

import java.util.ArrayList;
import java.util.List;

import com.collection.listSilsub.model.Car;

public class ParkingTowerManager {
	
	private ArrayList<Car> carList = new ArrayList<>();
	//주차 차량의 모든 데이터가 담기는 carList
	public ParkingTowerManager() {}
	
	public void insertCar(Car car) {
		int lastNo = 0;
		try {
		lastNo = carList.get(carList.size()-1).getParkingNum()+1;
		
		}catch(ArrayIndexOutOfBoundsException e) {
			lastNo = 1;
		
		}finally {
			car.setParkingNum(lastNo);	
			carList.add(car);
			
		}
		
		
				
	}
	
	public ArrayList<Car> selectList(){
		return carList;
	}
	
	public ArrayList<Car> deleteList(String name){
		 int count =0;
		for(int i = 0; i < carList.size(); i++) {
			if(carList.get(i).getOwner().equals(name)) {
				System.out.println("출차처리완료하였습니다.");
				carList.remove(i);
				count++;
			}
		}
		
			if(count == 0) {
				System.out.println("잘못 입력하셨거나 없는 차량입니다.");
			}
			
		return carList;
	}

	public List searchList(String owner) {
		
		List<Car> searchList = new ArrayList<>();
		for(int i =0; i < carList.size(); i++) {
			if(carList.get(i).getOwner().equals(owner)) {
				searchList.add(carList.get(i));
			}
		}
		
		return searchList;
	}
	
	
}
