package com.collection.part02_set;

public class Score implements Comparable {

	//필드 생성
	
	private String name;
	private int score;
	
	//생성자(기본, 매개변수)
	
	public Score() {}

	public Score(String name, int score) {
		this.name = name;
		this.score = score;
	}

	
	//getter & setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", score=" + score + "]";
	}

	
	//위에 comparable을 상속받으면 unimplement method가 생성 가능
	
	@Override
	public int compareTo(Object o) {
		//name으로 정렬
		//object o 라는 애를 score로 강제형변환한 후 이후에 이름을 가져옴. 그것을 othername에 초기화
		String otherName = ((Score)o).getName();
		//둘의 차이를 비교함.(앞 숫자에서 뒷 숫자 빼서 음수면 그대로, 양수면 순서 바꿈)
		return name.compareTo(otherName);
//		return -name.compareTo(otherName);
		//이렇게하면 이름 내림차순으로 됨!!! 
		//-붙이면 내림차순 정렬
		
	}
	
	
	
	
	
}
