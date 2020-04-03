package com.test02;



public class Score {
	//return 타입 : double, void, ...... 
	 // 괄호안에 있는 데이터를 던져주면 일을 함!!
	//(kor, eng, mat의 값을 주면 이 메서드가 계산해서 값을 돌려줌)
	
	public double getAvg(int kor, int eng, int mat) {
		
		double avg = (kor+eng+mat)/3.0;
		return avg;
		
		
	}

	
	public String getGrade(double avg) {
		//avg라는 데이터를 받아서 등급을 판단하고 grade를 return함
		String grade = " ";
		
		switch((int)(avg/10)) {
		case 10 :	
		case 9 : 
			grade = "A";
			break;
		case 8:
		case 7:
			grade = "B";
			break;
		default :
			grade = "C";
			
		
		}
		
		return grade;
		
	}
	
}
