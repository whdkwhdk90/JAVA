package com.silsub1.objArr.model.vo;

public class Student {
		private int grade;
		private int classroom;
		private int number;
		private String name;
		
public Student() {}
//9번째 줄을 선언해야 JVM이 필드값을 초기화 시킴.

public Student(int grade,int classroom,int number,String name) {
	this.classroom = classroom;
	this.grade = grade;
	this.name = name;
	this.number = number;
}
		
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}


	public int getClassroom() {
		return classroom;
	}
	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}


	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public String info() {
		return grade+"학년 "+classroom+"반 "+number+"번 "+name;
	}
	
	
}
