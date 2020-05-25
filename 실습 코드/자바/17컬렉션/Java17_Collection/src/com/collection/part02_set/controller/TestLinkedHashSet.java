package com.collection.part02_set.controller;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TestLinkedHashSet {

	public void testLinkedHashSet() {
		//LinkedHashSet
		//저장 순서 유지 기능이 추가
		LinkedHashSet lhset = new LinkedHashSet();
		lhset.add("java");
		lhset.add(123);
		lhset.add(45.67);
		lhset.add(true);
		lhset.add(new Date());
		System.out.println("Ihset : "+ lhset);
		
		
		//오름차순 정렬
		LinkedHashSet lhset2 = new LinkedHashSet();
		lhset2.add("java");
		lhset2.add("oracle");
		lhset2.add("html");
		lhset2.add("css");
		System.out.println("lhset2 : "+ lhset2);
		
		//만들어진 LinkedHashSet을 가지고 TreeSet 객체를 생성하면 자동으로 오름차순 정렬
		TreeSet tset = new TreeSet(lhset2);
		System.out.println("tset : "+tset);
		
		
	}
	
	
	
	
}
