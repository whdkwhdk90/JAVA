package com.silsub2.student.vo;

public class Student {

	private int grade;
	private int baan;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
		
public Student() {}

public Student(int grade, int baan, String name, int kor, int eng, int mat) {
	this.grade = grade;
	this.baan  = baan;
	this.name = name;
	this.kor = kor;
	this.eng = eng;
	this.mat = mat;
}

public int getGrade() {
	return grade;
}

public void setGrade(int grade) {
	this.grade = grade;
}


public int getBaan() {
	return baan;
}

public void setBaan(int baan) {
	this.baan = baan;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getKor() {
	return kor;
}

public void setKor(int kor) {
	this.kor = kor;
}

public int getEng() {
	return eng;
}

public void setEng(int eng) {
	this.eng = eng;
}

public int getMat() {
	return mat;
}

public void setMat(int mat) {
	this.mat = mat;
}
	
public String prnInfo() {
	return "학년 : "+grade+", 반 : "+baan+", 이름 : "+ name+
			", 국어점수 : "+kor+", 영어점수 : "+eng+", 수학점수 : "+mat;
}




}
