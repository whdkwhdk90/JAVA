package com.collection.part02_set.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class TestHashSet {

	public void testHashSet() {
		//Hashset
		HashSet hset = new HashSet();
		//다형성 적용 가능!!
		//Set hset2 = new HashSet();
		//Collection hset3 = new HashSet();
		hset.add(new String("java"));
		hset.add(new Integer(123));
		hset.add(new Double(45.67));
		hset.add(new Date());
		//저장 순서 유지가 안된다.
		System.out.println("hset : "+ hset);
		
		//중복으로 넣었을 때 들어가지않음.
		//중복허용 x
		hset.add(new String("java"));
		hset.add(new Integer(123));
		System.out.println("hset : "+ hset);
		System.out.println("저장된 객체수 : "+hset.size());
		System.out.println("포함확인 : "+ hset.contains(new Integer(123)));
		
		System.out.println("------------------------------------------------------");
		
		HashSet hset2 = new HashSet();
		hset2.add(new Score("이창진",99));
		hset2.add(new Score("홍길동",83));
		hset2.add(new Score("이순신",69));
		
		
		//값은 같지만 new 연산자를 통해서 만들어져서 주소값이 다름.(즉, 다르다고 인식함)
		//그래서 set에 포함됨.
		
		//score.java에 hashcode랑 equals를 오버라이드해줌으로써 값이 같으면 같은객체로 인식하게하면
		//같은 객체로 보고 중복되게 넣지않음.
		hset2.add(new Score("이창진",99));
		System.out.println("hset2 : "+hset2);
		
		
		
		
		//저장된 객체를 하나씩 꺼내기
		//set에서는 하나씩 꺼내는 기능이 없다.
		
		//1. toArray()배열로 바꾸고 반복문사용
		Object[] arr = hset.toArray();
		for(int i =0; i<arr.length; i++) {
			System.out.println(i+" : "+arr[i]);
		}
		
		//2. Iterator()로 목록 만들어 처리
		Iterator iter = hset.iterator();
		//StringTokenizer랑 비슷
		while(iter.hasNext()){
		System.out.println(iter.next());		
		}
		//위에서이미 iterator 커서가 끝을 가리키고있음.(그래서 밑에꺼는 자동으로 false가 됨)-iterator는 1번밖에 사용불가
		//재사용하려면 다시 만들어서 다시 써야됨.
		Iterator iter2 = hset.iterator();
		while(iter2.hasNext()) {
			System.out.println("2: "+iter2.next());
		}
		
		
		
		
	}
	
	
	
}
