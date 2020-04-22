package com.collection.part04_Generics;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.collection.part02_set.Score;

public class TestGenerics {

	public void testGenerics1() {
		List list = new ArrayList();
		list.add(new String("Object saved"));
		list.add(new Score());
		list.add(new Student());
		list.add(new Car());
		list.add(new Book());
		System.out.println("저장된 객체수 : "+ list.size());
		System.out.println("list : "+ list);
		
		for(int i =0; i < list.size() ; i++) {
			Object obj = list.get(i);
			System.out.println(obj.toString());		
			if(obj instanceof Book) {
				((Book)obj).printBook();
			}
			if(obj instanceof Student) {
				((Student)obj).score();
			}
			if(obj instanceof Car) {
				((Car)obj).printCar();
			}
		}
		
	
		
		
	}

	public void testGenerics2() {
		//제네릭스 : 컬렉션에 저장되는 객체의 자료형에 제한을 거는 기능
		//컬렉션에 한가지 종류의 객체만 저장되기 때문에
		//꺼내서 사용할 때 객체 레퍼런스 형변환x
		
		ArrayList<Book> list = new ArrayList<Book>();
		ArrayList list2 = new ArrayList();
		
	//	list.add("test generics");
		//list는 Book타입만 설정 가능 그래서 add 불가
		
		list.add(new Book());
		list.add(new Book());
		list2.add(new Book());
		list2.add(new Book());
		
		for(Object ob : list2) {
			((Book)ob).printBook();
		}
		
		for(Book b : list) {
			b.printBook();
		}
		
		
	}

	public void testGenerics3() {
		//Map에 제네릭스 적용
		//map은 key랑 value 둘다 설정해줘야됨.
		//object로 받고 싶으면 object라고 명시해야됨.
		HashMap<String,Book> map =
				new HashMap<String,Book>();
		
		//map.put("one","java");
		//타입 오류
		map.put("one",new Book("java"));
		
		map.put("two", new Book("oracle"));
		System.out.println(map);
		
	}
	
	public void testGenerics4() {
		//1.7버전(?)이후에는 앞에 선언하면 뒤에 생략해도 무방.
		HashMap<String,Book> map = new HashMap<>();
		map.put("one", new Book("Java"));
		map.put("two", new Book("Oracle"));
		map.put("three", new Book("JDBC"));
		
		//entrySet()
		Set<Map.Entry<String,Book>> entry = 
				map.entrySet();
		
		Iterator<Map.Entry<String,Book>> it =entry.iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, Book> ent = it.next();
			String key = ent.getKey();
			Book val = ent.getValue();
			System.out.println(key+":"+val);
		}
		
		//set에 key만 추출하여 Iterator로 출력
		//1. key를 set으로
		//2. set을 Iterator로
		//3. 반복문을 통해 Iterator의 key를 가져온 후 value값 확인
		Set<String> set1 = map.keySet();
		Iterator<String> it1 = set1.iterator();
		
		while(it1.hasNext()) {
			String key1 = it1.next();
			Book b = map.get(key1);
			System.out.println(key1+" : "+b);
			
		}	
	}
	
}


//한 클래스 파일 안에 여러개의 클래스 정의 가능
//이런식으로 선언할 때 접근제한자 선언하면 안됨.
class Student{
	public Student() {}
	public void score() {
		System.out.println("score() call");
	}
	@Override
	public String toString() {
		return "Student";
	}
}

class Car{
	public Car() {}
	public void printCar() {
		System.out.println("printCar() call");
	}
	@Override
	public String toString() {
		return "Car";
	}
}

class Book{
	private String title;
	public Book() {}
	public Book(String title) {this.title = title;}
	public void printBook() {
		System.out.println("printBook() call");
	}
	@Override
	public String toString() {
		return "Book";
	}
}

