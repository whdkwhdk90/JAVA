package com.silsub3.member.view;

import java.util.Scanner;
import com.silsub3.member.controller.MemberManager;

public class MemberMenu {

	private Scanner sc = new Scanner(System.in);
	private MemberManager mManager = null;
	
	
	public void mainMenu() {
	char answer = ' ';
	
	do {
	System.out.println("***** 회원 관리 프로그램 *****");
	System.out.println();
	System.out.println("1. 새 회원 등록");	  		//객체배열 사용
	System.out.println("2. 회원 조회");			//equals 사용
	System.out.println("3. 회원 정보 수정");		//setter 사용
	System.out.println("4. 회원 정보 정렬");		//compareto 사용
	System.out.println("5. 회원 삭제");
	System.out.println("6. 모두 출력");
	System.out.println("9. 끝내기");
	System.out.print("메뉴 선택 : ");
	int num = sc.nextInt();	
		
	switch(num) {
	
	case 1:
		mManager.memberInput();
		break;
	case 2:
		searchMenu();
		break;
	case 3:
		modifyMenu();
		break;
	case 4:
		sortMenu();
		break;
	case 5:
		mManager.deleteMember();
	case 6:
		mManager.printAllMember();
		break;
	case 9:
		return;
	default :
		System.out.println("잘못 입력하셨습니다.");
	}
	System.out.print("계속 입력하시겠습니까?('y/n') : ");
	answer = sc.next().charAt(0);
	}while((answer=='y')||(answer=='Y'));
}

	public void searchMenu() {
	char answer = ' ';
	
	do {
		System.out.println("***** 회원 정보 검색 메뉴 *****");
		System.out.println();
		System.out.println("1. 아이디로 검색");
		System.out.println("2. 이름으로 검색");
		System.out.println("3. 이메일로 검색");
		System.out.println("9. 이전 메뉴로 가기");
		System.out.print("메뉴 선택 : ");
		int num = sc.nextInt();
		
		switch(num) {
		case 1:
			System.out.print("아이디를 입력하시오 : ");
			String str = sc.next();
		
		
		
		
		}
		
	}while((answer=='y')||(answer=='Y'));
		
	}
	
	public void sortMenu() {}
	
	public void modifyMenu() {}
	
	
}
