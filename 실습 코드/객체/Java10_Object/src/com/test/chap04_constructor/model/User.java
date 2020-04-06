package com.test.chap04_constructor.model;

import java.util.Date;

public class User {
			private String userId;
			private String userPwd;
			private String userName;
			private Date EnrollDate;
			
			/* 생성자의 사용 목적
			 *  1. 객체를 생성해 주기 위한 목적
			 *  2. 매개변수로 전달받은 값으로 필드를 초기화할 목적
			 * 
			 * 
			 *  생성자 사용시 주의사항
			 *  1. 반드시 클래스명과 동일해야 한다(대/소문자 구분)
			 *  2. 리턴형이 존재하지 않는다.(void, int, char, string, .... 이런게 하나도 없음)
			 */
		
	//기본생성자 ㅡ> 필드의 초기화 역할은 수행하지 못하고 객체 생성 할 때만 사용		
	public User() {}		
	
	//매개변수 있는 생성자 ㅡ> 객체 생성과 필드를 초기화 하는 두가지 목적으로 사용
	//같은 이름의 생성자 혹은 메소드를 사용하려고 하는 경우 오버로딩을 사용해야 한다.
	public User(String userId, String userPwd, String userName) {
			this.userId = userId;
			this.userPwd = userPwd;
			this.userName = userName;
			
			//this.    : 메소드 내에 숨겨진 채 존재하는 래퍼런스 변수,
			// 			할당된 객체 자신을 의미(숨겨져 있는 주소값정도로 생각하면됨)
			
	}
	
	public User(String userId, String userPwd, String userName, Date EnrollDate) {
//		this.userId = userId;
//		this.userPwd = userPwd;
//		this.userName = userName;
		
		//위에 3줄을 밑에처럼 쓸 수있음.
		//위에 user라는 생성자가 있으니 인용해서 쓰는 것.
		//this() : 같은 클래스 안에 있는 다른 생성자를 가리킴.
		// 중복되는 동일한 초기화 하는 내용의 생성자가 존재하는 경우에
		// this()를 사용 할 수 있다.
		//this.랑 this()랑 구분 잘 할 것!!!!!!
		//this()는 반드시 맨 윗줄에 있어야함.
		this(userId,userPwd,userName);   
		
		this.EnrollDate = EnrollDate;
	}
	
	//getter  setter 작성
	public String getUserId() {
			return userId;
			
	}

	public void setUserId(String userId) {
			this.userId = userId;
			//this.은 객체를 가리킴.
			//만약 뒤에 userId의 이름을 달리하면 굳이 this안써도됨.
	}

	
	
	public String getUserPwd() {
		return userPwd;
	}
		
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	
	
	public String getUserName(){
		return userName;
	}
	
	public void getUserName(String userName) {
		this.userName = userName;
	}	

	
	
	public Date getUserDate() {
		return EnrollDate;
	}
	
	public void setEnrollDate(Date enrollDate) {
		this.EnrollDate = enrollDate;
	}
	
//여기까지는 기본 작성이 되어야함.
	
	
	//출력용 메소드
	public void info() {
		System.out.println(userId+ ", "+ userPwd+", "
												+userName+", "+EnrollDate);
	}
	
	
	
	
	
	
	
}
