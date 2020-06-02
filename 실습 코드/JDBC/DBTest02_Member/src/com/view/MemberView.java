package com.view;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.biz.MemberBizImpl;
import com.dto.Member;

public class MemberView {
	static Scanner sc = new Scanner(System.in);
	
	private static int getMenu() {
		int select = 0;
		
		System.out.println("********");
		System.out.println("1. selectAll");
		System.out.println("2. selectOne");
		System.out.println("3. insert");
		System.out.println("4. update");
		System.out.println("5. delete");
		System.out.println("6. exit");
		System.out.print("input select: ");
		select = sc.nextInt();
		return select;
	}
	
	
	
	public static void main(String[] args) {
		int select = 0;
		MemberBizImpl memberBiz = new MemberBizImpl();
	
		while(select != 6) {
			select = getMenu();
			
			switch(select) {
			
			case 1: // 전체 출력
					List<Member> res = memberBiz.selectAll();
					
					for(Member m : res) {
						System.out.println(m);
					}
					break;
			case 2:	//선택 출력
					System.out.print("번호 선택: ");
					int n = sc.nextInt();
					Member resOne = memberBiz.selectOne(n);
					System.out.println(resOne);
					break;
			case 3:	//삽입
					System.out.print("번호 입력: ");
					int num = sc.nextInt();
					System.out.print("이름 입력: ");
					String name = sc.next();
					System.out.print("나이 입력: ");
					int age = sc.nextInt();
					System.out.print("성별 입력(M/F): ");
					String gender = sc.next();
					System.out.print("위치 입력: ");
					String loc = sc.next();
					System.out.print("직업 입력: ");
					String job = sc.next();
					System.out.print("전화번호 입력: ");
					String tell = sc.next();
					System.out.print("이메일 입력: ");
					String eml = sc.next();
					Member m = new Member();
					m.setM_no(num);
					m.setM_name(name);
					m.setM_age(age);
					m.setM_gender(gender);
					m.setM_location(loc);
					m.setM_job(job);
					m.setM_tell(tell);
					m.setM_email(eml);		
					int resss = memberBiz.insert(m);
					if(resss>0) {
						System.out.println("insert 성공");
					}else {
						System.out.println("insert 실패");
					}
					break;
			case 4:	//수정
					Member m1 = new Member();
					System.out.print("수정할 번호 입력: ");
					int num1 = sc.nextInt();
					System.out.print("수정할 이름 입력: ");
					String name1 = sc.next();
					System.out.print("수정할 나이 입력: ");
					int age1 = sc.nextInt();
					System.out.print("수정할 성별 입력(M/F): ");
					String gender1 = sc.next();
					System.out.print("수정할 위치 입력: ");
					String loc1 = sc.next();
					System.out.print("수정할 직업 입력: ");
					String job1 = sc.next();
					System.out.print("수정할 전화번호 입력: ");
					String tell1 = sc.next();
					System.out.print("수정할 이메일 입력: ");
					String eml1 = sc.next();
					m1.setM_no(num1);
					m1.setM_name(name1);
					m1.setM_age(age1);
					m1.setM_gender(gender1);
					m1.setM_location(loc1);
					m1.setM_job(job1);
					m1.setM_tell(tell1);
					m1.setM_email(eml1);		
					int res4 = memberBiz.update(m1);
					if(res4>0) {
						System.out.println("수정 성공");
					}else {
						System.out.println("수정 실패");
					}
					break;
			case 5:	//삭제
					System.out.print("삭제할 번호 선택: ");
					int no = sc.nextInt();
					int res1 = memberBiz.delete(no);
					if(res1>0) {
						System.out.println("삭제 성공");
					}else {
						System.out.println("삭제 실패");
					}
					break;
			case 6:	//종료
					return;
			}
			
			
		}
		
	}


	
}
