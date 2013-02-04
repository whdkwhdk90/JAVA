package com.collection.listSilsub.view;

import java.util.List;
import java.util.Scanner;

import com.collection.listSilsub.controller.ParkingTowerManager;
import com.collection.listSilsub.model.Car;

public class ParkingTowerMenu {

	protected Scanner sc= new Scanner(System.in);
	private ParkingTowerManager ptm = new ParkingTowerManager();
	
	
	public ParkingTowerMenu() {}
	public void mainMenu() {
		char answer =' ';
		do {
			System.out.println("=== *주차 타워 관리* ===");
			System.out.println();
			System.out.println("1. 차량 주차");
			System.out.println("2. 전체 출력");
			System.out.println("3. 차량 출차");
			System.out.println("4. 차량 검색");
			System.out.println("0. 끝내기");
			System.out.print("메뉴 선택: ");
			int num = sc.nextInt();
			switch(num) {
			case 1:
				insertCar();
				break;
			case 2:
				selectList();
				break;
			case 3:
				deleteList();
				break;
			case 4:
				searchList();
				break;
			case 0:
			default:
				System.out.println("프로그램 종료");
				return;
			}
			System.out.print("계속 하시겠습니까?(y/n): ");
			answer = sc.next().charAt(0);
		}while(answer =='y' || answer == 'Y');	
	}
	
	
	public void insertCar() {
		System.out.print("차량 번호: ");
		int carNum = sc.nextInt();
		System.out.print("차량 타입(1:경차 /2:세단/3:SUV/4:트럭): ");
		int carType = sc.nextInt();
		System.out.print("차주: ");
		String owner = sc.next();
		
		Car car = new Car(carNum,carType,owner);
		ptm.insertCar(car);
	}
	
	public void selectList() {
		
		List<Car> searchList = ptm.selectList();
		
		if(searchList.isEmpty()) {
			System.out.println("주차된 차량이 없습니다.");
		}else {
			
			for(Car c : searchList) {
				System.out.println(c.toString());
			}
			
			
		}
		
		
	}
	
	public void deleteList() {
		String name="";
		System.out.print("출차하시는 차량의 차주의 이름을 입력하시오 : ");
		name = sc.next();
		ptm.deleteList(name);
		
		
		
	}

	public void searchList() {
		sc.nextLine();
		System.out.print("주차 차주 검색: ");
		String owner = sc.nextLine();
		List searchList = ptm.searchList(owner);
		
		if(searchList.isEmpty()) {
			System.out.println("검색한 차량이 존재하지 않습니다.");
		}else {
			for(int i=0; i<searchList.size(); i++) {
				System.out.println(searchList.get(i));
			}
		}
		
	}

}
