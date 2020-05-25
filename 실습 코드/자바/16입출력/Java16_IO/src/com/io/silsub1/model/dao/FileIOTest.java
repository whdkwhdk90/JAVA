package com.io.silsub1.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileIOTest {

	public static void main(String[] args) {
		
		FileIOTest fio = new FileIOTest();
//		fio.fileSave();
		fio.fileRead();
	
	}
	
	public void fileSave() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		FileWriter fw = null;
		String str = "";
		String str1 ="";
		try {
			System.out.print("파일명을 입력하시오 : ");
			str = br.readLine();
			fw = new FileWriter(str,true);
			
			
			//강사님은 char[] car = str.toCharArray(); 쓰셨음
			
			
		while(true) {
			System.out.print("파일에 저장할 내용을 입력하시오: ");
			str1 = br.readLine();
			if(str1.equals("exit")) {
				break;
			}
			fw.write(str1);
		}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				System.out.println("파일에 성공적으로 저장되었습니다.");
				fw.close();
			//	br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void fileRead() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		FileReader fr = null;
		StringBuilder sb = null;
		String str ="";
		String str1 ="";
		System.out.print("읽을 파일이름을 입력하시오 : ");
		try {
			
			str = br.readLine();
			fr = new FileReader(str);
			
			
			
			
			int value;
			 sb = new StringBuilder();
			
			while( (value = fr.read()) != -1  ){
				sb.append((char)value);
			}
			 System.out.println(sb.toString());
			
			 
			 //고민좀해보기
			 
			 
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
}
