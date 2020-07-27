package com.test.io.fileTest;

import java.io.File;
import java.io.IOException;

public class TestFile {

	public static void main(String[] args) {
		File file = new File("person.txt");
		
		System.out.println("파일명 : "+file.getName());
		System.out.println("저장경로 : "+file.getPath());
		//파일의 상대경로
		System.out.println("저장경로 : "+file.getAbsolutePath());
		//파일의 절대경로
		System.out.println("파일용량 : "+file.length());
		
		try {
			//파일이 없을 경우 파일 생성하고 true값 리턴.
			//파일이 있는 경우는 false를 리턴.
			boolean b = file.createNewFile();
			System.out.println(b);
			
			//파일이 있을 경우 파일 삭제하고 true값 리턴.
			//파일이 없을 경우 error발생
			boolean b2 = file.delete();
			System.out.println(b2);

		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
