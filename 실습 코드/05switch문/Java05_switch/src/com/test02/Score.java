package com.test02;

public class Score {

	//double, void ... : 리턴 타입
	//메소드명(파라미터값(=변수))
	public double getAvg(int kor, int eng, int mat) {
		
		double avg= (kor+eng+mat)/3.0;
		return avg;
		
	}
	
	public String getGrade(double avg){
		
		String grade="";
		
		switch((int)avg/10) {
		case 10:
		case 9:
			grade="A";
			break;
		case 8:
		case 7:
			grade="B";
			break;
		default:
			grade="F";
		}
		
		return grade;
		
	}
	
	
	
	
	
}
