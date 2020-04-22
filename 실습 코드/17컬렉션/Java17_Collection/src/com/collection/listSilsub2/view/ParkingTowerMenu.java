package com.collection.listSilsub2.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.collection.listSilsub2.controller.ParkingTowerManager;
import com.collection.listSilsub2.model.Car;

public class ParkingTowerMenu {

	protected Scanner sc = new Scanner(System.in);
	private ParkingTowerManager ptm = new ParkingTowerManager();
	
	public ParkingTowerMenu() {}
	
	public void mainMenu() {
		char answer  = ' ';
		do {
			System.out.println("=== *주차 타워 관리* ===");
			System.out.println();
			System.out.println("1. 차량 주차");
			System.out.println("2. 전체 출력");
			System.out.println("3. 차량 출차");
			System.out.println("4. 주차 차량 검색");
			System.out.println("0. 끝내기");
			System.out.print("메뉴 선택 : ");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				insertCar();
				break;
			case 2:
				selectMap();
				break;
			case 3:
				deleteCar();
				break;
			case 4:
				searchCar();
				break;
			case 0:
			default:
				System.out.println("프로그램 종료");
				return;
			}
		
		}while(true);	
	}
	
	
	public void insertCar() {
		System.out.print("차량 번호: ");
		int carnum = sc.nextInt();
		System.out.print("차량 타입: ");
		int cartype = sc.nextInt();
		System.out.print("차주: ");
		String name = sc.next();
		
		Car car = new Car(carnum,cartype,name);
		ptm.insertCar(car);
		
	}
	
	public void selectMap() {
		Map<Integer, Car> hmap = ptm.selectMap();
		Set set = hmap.entrySet();
		Iterator setIt = set.iterator();
		if(ptm.selectMap().isEmpty()) {
			System.out.println("주차된 차량이 없습니다.");
		}else {
			 while(setIt.hasNext()) {
				 System.out.println(setIt.next());
			 }
		
		}	
	}
	
	public void deleteCar() {
		System.out.print("차량 번호: ");
		int bun = sc.nextInt();
		int res = ptm.deleteCar(bun);
		
		if(res ==1) {
			System.out.println("차량 출차 완료");
		}else {
			System.out.println("입력하신 차량이 주차되어 있지 않습니다.");
		}
		
	}
	
	public void searchCar() {
		Map<Integer,Car> searchMap = new HashMap<>();
		System.out.print("차주 입력: ");
		String name= sc.next();
		searchMap =  ptm.searchCar(name);
		Set set = searchMap.entrySet();
		
		if(searchMap.isEmpty()) {
			System.out.println("검색한 차주의 차량이 주차되어있지 않습니다.");
		}else {
			Iterator searIt = set.iterator();
			while(searIt.hasNext()) {
				System.out.println(searIt.next());
			}
		}
		
		
	}
	
	
}
