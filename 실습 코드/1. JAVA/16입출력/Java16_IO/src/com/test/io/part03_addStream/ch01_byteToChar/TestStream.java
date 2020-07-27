package com.test.io.part03_addStream.ch01_byteToChar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestStream {

	
		public void input() {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//보조스트림 변수 = new 보조스트림(new 보조스트림(new 기반스트림("외부자원")));
	
			try {
				System.out.print("문자열 입력 : ");
				String val = br.readLine();
				System.out.println("val : "+ val);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
		public void output() {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			try {
				bw.write("Java Oracle JDBC");
				//bw.flush();
				//밑에 finally부분을 다 주석처리하면 출력내용이 없음.
				//flush를 쓰면 버퍼안에있는 내용들 다 밀어서 출력시킴.
				//닫으면 다 flush가 되긴하는데 여러 파일 작업을 하다가 data를 중간중간 비워야한다면 flush를 쓰는 거임.
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
		
}
