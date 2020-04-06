package com.test.chap01_encapsulation;

public class Score {
		//필드
	
	private String name = "이창진";
	private int kor = 90;
	private int eng = 84;
	private int mat = 97;
	
	//생성자
	
	public Score() {}
	
	//총합을 구하여 출력하는 메소드
	public void sum() {
		int sum = kor+eng+mat;	
		System.out.println("총합 : " +sum);
	}
	
	//평균을 구하여 출력하는 메소드
	public void avg() {
		int avg = (kor+eng+mat)/3;
		System.out.println("평균 : "+avg);
	}
	
	//제일 높은 점수를 받은 과목을 찾는 메소드
	public void max() {
		int max = kor;
		if(max >= eng) {
					if(mat>= max) {
						max = mat;
					}
		}else {
			max =eng;	
			if(max <= mat) {
				 max = mat;
			}
			}
		System.out.println("최댓값 : "+max);
		}
	
/*     if(kor >eng && kor >mat){
 *              system.out.println("국어가 최댓값");
 *               else if(eng > kor && eng >mat){
 *               system.out.println("영어가 최댓값");
 *               }else{
 *               system.out.println("수학이 최댓값");
 *               }
 * 
 * 	
 */
	

	//제일 낮은 점수를 받은 과목을 찾는 메소드
	public void min() {
		int min = kor;
				if(min <= eng) {
						if(mat<= min) {
							min = mat;
						}
			}else {
				min =eng;	
				if(min >= mat) {
					 min = mat;
				}
				}
		System.out.println("최솟값 : "+min);		
				
	}
	//필드값을 확인 할 수 있는 information() 메소드
	public void information() {
		System.out.println("name : " + name + ", kor : " + kor + ", eng : "+eng + ", mat : " + mat);
		
		
	}
	
}



//괄호안에 쓰는 것은 왜 ?? 어떤 이유로 ??



