package com.collection.part01_list.arrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ArrayListTest {

	public void testArrayList() {
		
		//ArrayList는 객체 생성 시 내부적으로 10칸짜리 배열을 생성
		ArrayList alist = new ArrayList();
		
		//다형성
		List list = new ArrayList();
		Collection clist = new ArrayList();
		
		//저장순서가 유지, index적용
		//객체만 저장
		alist.add("apple");
		alist.add(123);			//autoBoxing(data -> object)
		alist.add(45.67);
		alist.add(new Date());
		//toString Overriding
		//저장 순서 유지
		System.out.println("alist : "+alist);
		
		//list에선 size로 길이를 잼
		//list에선 [i]가 아닌 get(i)가 됨
		for(int i =0; i< alist.size(); i++) {
			System.out.println(i+" : "+alist.get(i));
		}
		
		//list 뒤에 apple이 추가됨
		alist.add("apple");
		System.out.println("alist : "+alist);
		
		
		//list의 1자리(2번째 자리)에 banana를 넣음
		//넣고 그 뒤에 값들을 다 한자리씩 뒤로 미룸
		alist.add(1,"banana");
		System.out.println("alist : "+alist);
		
		//list의 2자리(3번째 자리)에 값이 사라짐.
		//삭제시키고 그 뒤의 값들을 하나씩 앞으로 당김.
		alist.remove(2);
		System.out.println("alist : "+ alist);
		
		
		
	}
	
	public void testArrayListSort() {
		//ArrayList는 오름차순 정렬 가능한 sort() 메소드
		ArrayList list  = new ArrayList();
		list.add("apple");
		list.add("banana");
		list.add("orange");
		list.add("mango");
		System.out.println("list : "+list);
		
		//list 내부의 값들을 abcd순으로 정렬
		Collections.sort(list);
		System.out.println("list : "+ list);
		
		
		
		
		
		
		
		
	}
	
	
}
