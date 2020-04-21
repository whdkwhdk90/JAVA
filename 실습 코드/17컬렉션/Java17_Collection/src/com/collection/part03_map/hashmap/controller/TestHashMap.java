package com.collection.part03_map.hashmap.controller;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestHashMap {

	public void testHashMap() {
		HashMap hmap = new HashMap();
		//다형성 적용
		//Map hamp2 = new HashMap();
		
		//collection은 map을 상속안줌. 그래서 담을 수가 없음
		//Collection hmap3 = new HashMap();  (안됨)
		
		
		
		//key랑 value가 =형태로 set화 되서 출력
		hmap.put("one", new Date());
		hmap.put(12,"red apple");
		hmap.put(33,123);
		System.out.println("hmap : "+hmap);
		
	
		//key값은 중복 허용을 하지않음.(set의 특징)
		//(그래서 12에 들어가있던 red apple이 yellow banana로 바뀜)		
		hmap.put(12, "yellow banana");
		System.out.println("hmap : "+hmap);
		
		
		//value값 중복은 허용함.(list의 특징)
		hmap.put(11,  "yellow banana");
		hmap.put(9,  "yellow banana");
		System.out.println("hmap : "+hmap);
		
		
		
		//각 객체의 내용을 가져 오기
		System.out.println("키가 9인 객체: "+hmap.get(9));
		
		//삭제(key값이 9인 객체 삭제)
		hmap.remove(9);
		System.out.println("hmap : "+hmap);
		
		
		
	}
	
	public void testHashMap2() {
		
		HashMap hmap = new HashMap();
		hmap.put("one", "java");
		hmap.put("two", "oracle");
		hmap.put("three", "jdbc");
		hmap.put("four", "html5");
		hmap.put("five", "css3");
		
		//전체 정보를 하나씩 출력
		//1. keyset()
		Set keys = hmap.keySet();
		Iterator keyIter = keys.iterator();
		while(keyIter.hasNext()) {
			String key = (String)keyIter.next();
			String val = (String)hmap.get(key);
			System.out.println(key+"="+val);
		}
		
		System.out.println("-------------------------");
		
		//2. 저장된 value값들만 values() 이용해 Collection으로 만든다.
		Collection values = hmap.values();
		//2.1 Iterator()
		Iterator valIter = values.iterator();
		while(valIter.hasNext()) {
			System.out.println(valIter.next());
		}
		//2.2 배열로 만들어서 처리
		Object[] valArr = values.toArray();
		for(int i =0; i < valArr.length; i++) {
			System.out.println(i+": "+ valArr[i]);
		}
		
		//3. Map 내부 클래스인 EntrySet을 이용
		Set set = hmap.entrySet();
		Iterator entryIter = set.iterator();
		while(entryIter.hasNext()) {
			Map.Entry entry = (Map.Entry)entryIter.next();
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		
		
	}
	
	
	
}
