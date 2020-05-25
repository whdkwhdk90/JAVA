package com.collection.part01_list.arrayListSort.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.collection.part01_list.arrayListSort.model.Score;
import com.collection.part01_list.arrayListSort.model.ScoreSorting;

public class ScoreManager {

	public void scoreSort() {
		List list = new ArrayList();
		
		list.add(new Score("이창진",99));
		list.add(new Score("홍길동",75));
		list.add(new Score("이순신",88));
		
		
		list.add(new Score("김유신",72));
		list.add(new Score("강철수",33));
		list.add(new Score("남진",62));
//		list.add("끄읕");
	
		//이름 오름차순정렬
		System.out.println("list : "+list);
		
		//comparable
		//Collections.sort(list);
		list.sort(null);
		//정렬 기준을 아무것도 안하면 기본 정렬만 됨.
		System.out.println("listSort : "+ list);
		
		
		//comparator
	//	Collections.sort(list,new ScoreSorting());
		list.sort(new ScoreSorting());
		//위에 두줄은 같은 의미임
		
		System.out.println("listSorting : "+list);
		
		
		
		
		
	}
	
	
	
	
	
}
