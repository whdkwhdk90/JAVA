package com.collection.listSilsub2.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.collection.listSilsub2.model.Car;

public class ParkingTowerManager {

	private HashMap<Integer,Car> carMap = new HashMap<>();
	private int parkingNo = 0;
	
	public ParkingTowerManager() {}
	
	public void insertCar(Car car) {
			 carMap.put(parkingNo, car);
			 parkingNo++;

	
	}
	
	public Map<Integer,Car> selectMap(){
		return carMap;
	}
	
	public int deleteCar(int carNum) {
	
		int[] iarr = new int[1000];
		int res=0;
		int i=0;
		int count =0;
		for(Map.Entry<Integer, Car> entry : carMap.entrySet()) {		
			Car car = entry.getValue();
			int num = entry.getKey();
			if(car.getCarNum()==carNum) {
				iarr[i] = num;
				i++;
				res = 1;
				count ++;
			}
		}
		for(int j = 0; j < count; j++) {
			carMap.remove(iarr[j]);
		}
		
		
		 return res;	
}
		
		
		
		
			
	
	
	public HashMap<Integer,Car> searchCar(String owner){
		
		Map<Integer,Car> searchMap = new HashMap<>();
		
		Set set = carMap.entrySet();
		Iterator setIt = set.iterator();
		
		while(setIt.hasNext()){
			Map.Entry entry = (Map.Entry)setIt.next();
			if( ((Car)entry.getValue()).getOwner().equals(owner)) {
				searchMap.put((Integer)entry.getKey(),(Car)entry.getValue());
			}
		}
		
		return (HashMap<Integer, Car>) searchMap;
		
	}
	
}
