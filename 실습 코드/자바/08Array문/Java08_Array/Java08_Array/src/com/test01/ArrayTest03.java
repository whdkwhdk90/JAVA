package com.test01;

public class ArrayTest03 {
	public static void main(String[] args) {
		
		ArrayTest03 at03 = new ArrayTest03();
//		at03.shallowCopy();
//		at03.deepCopy();
//		at03.deepCopy2();
		at03.deepCopy3();
	}
	
	public void shallowCopy() {
		
		//얕은복사
		int[] originArr = {1,2,3,4,5};
		int[] copyArr = originArr;
		
		String str = "";

		for(int i = 0; i <originArr.length; i++) {
			str += originArr[i] + " ";
		}
		System.out.println("1.originArr : " + str);
		

		str = "";
		
		for(int i = 0; i <copyArr.length; i++) {
			str += copyArr[i] + " ";		
		}
		System.out.println("2.copyArr : " + str);
		
		
		//원본 배열 변경
		originArr[0] = 99;
		
		str = "";
		
		for(int i = 0; i <copyArr.length; i++) {
			str += originArr[i] + " ";		
		}
		System.out.println("1.originArr : " + str);
			
		
		str = "";
		
		for(int i = 0; i <copyArr.length; i++) {
			str += copyArr[i] + " ";		
		}
		System.out.println("2.copyArr : " + str);
		
		//얕은 복사를 했기 때문에 원본 배열만 변경을 했는데 copyarray도 같이 변하게 되었음.
		
		System.out.println("originArr의 hashcode : " + originArr.hashCode());		
		System.out.println("copyArr의 hashcode : " + copyArr.hashCode());
		
		//해쉬코드도 동일함.(주소값이 같음)
	}
	
	
	public void deepCopy() {
		//1. 깊은 복사는 동일한 새로운 배열을 하나 생성하고 값을 복사.
		int[] originArr = {1,2,3,4,5};
		int[] copyArr = new int[5];
		
		//for문을 이용하여 1:1 복사
		for(int i =0; i < originArr.length; i++) {
			copyArr[i] = originArr[i];

		}
		
		
		//원본 배열값 출력
		String str = "";
		for(int i = 0; i <originArr.length; i++) {
			str += originArr[i] + " ";
		}
		System.out.println("1.originArr : " + str);
		
		str = "";
		// 복사 배열값 출력
		for(int i = 0; i <copyArr.length; i++) {
			str += copyArr[i] + " ";		
		}
		System.out.println("2.copyArr : " + str);
		
		System.out.println("originArr의 hashcode : " + originArr.hashCode());		
		System.out.println("copyArr의 hashcode : " + copyArr.hashCode());
		
		//원본배열의 0번 인덱스의 값을 99로 변경//////////////////////////////////////////////////////////////////////////////
		
		originArr[0] = 99;
		
		str = "";
		//원본 배열값 출력
		for(int i = 0; i <originArr.length; i++) {
			str += originArr[i] + " ";
		}
		System.out.println("1.originArr : " + str);
	
		
		str = "";
		// 복사 배열값 출력
		for(int i = 0; i <copyArr.length; i++) {
			str += copyArr[i] + " ";		
		}
		System.out.println("2.copyArr : " + str);
		
		
		
		System.out.println("originArr의 hashcode : " + originArr.hashCode());		
		System.out.println("copyArr의 hashcode : " + copyArr.hashCode());
		
	}
	
	public void deepCopy2() {
		//2. arraycopy()를 이용한 복사
		//java.lang.System 
		
		int[] originArr = {1,2,3,4,5};
		int[] copyArr = new int[10];
		
		
		//arraycopy(src, srcPos, dest, destPos, length);
		// src : 원본배열, srcPos : 복사시작위치
		//dest : 카피배열, destPos : 붙여넣기시작위치
		//length :복사될 길이(length만큼 복사해서 destPos로 ...)
		
		System.arraycopy(originArr, 0, copyArr, 3, originArr.length);   //(원본의 , 처음부분부터(0) , 카피배열의 , 4번째부분에(3), 원본길이만큼 복사) 
		
		//원본 배열값 출력
		String str = "";
		for(int i = 0; i <originArr.length; i++) {
			str += originArr[i] + " ";
		}
		System.out.println("1.originArr : " + str);
		
		
		str = "";
		// 복사 배열값 출력
		for(int i = 0; i <copyArr.length; i++) {
			str += copyArr[i] + " ";		
		}
		System.out.println("2.copyArr : " + str);
		
	}
	
	public void deepCopy3() {
		//clone()을 이용한 복사 --원본배열을 통째로 복사하는거임.
		int[] originArr = {1,2,3,4,5};
		int[] copyArr = new int[10];
		
		copyArr = originArr.clone();
		
		//원본 배열값 출력
		String str = "";
		for(int i = 0; i <originArr.length; i++) {
			str += originArr[i] + " ";
		}
		System.out.println("1.originArr : " + str);
				
				
		str = "";
		// 복사 배열값 출력
		for(int i = 0; i <copyArr.length; i++) {
			str += copyArr[i] + " ";		
		}
		System.out.println("2.copyArr : " + str);
		
		
		System.out.println("복사한 후 원본 배열의 주소 : " +originArr.hashCode());
		System.out.println("복사한 후 복사본 배열의 주소 : " +copyArr.hashCode());
		
		
		
	}
	
	
}
