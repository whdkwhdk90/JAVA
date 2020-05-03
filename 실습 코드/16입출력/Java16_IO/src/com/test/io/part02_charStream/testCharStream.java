package com.test.io.part02_charStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class testCharStream {
	
	
	public void fileSave() {
		FileWriter fw = null;
		
		try {
			//fw = new FileWriter("sample.txt");
			fw = new FileWriter("sample.txt",true);   
			//true라고 붙이면 다시 실행 시 sample이 초기화 되지 않고 계속 이어서 쓰게 됨
			fw.write("비도 오고 그래서");
			fw.write('A');
			fw.write(' ');
			
			char[] carr = {'a','b','c','d'};
			fw.write(carr);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void fileOpen() {
		FileReader fr = null;
		
		try {
			fr = new FileReader("sample.txt");
			int val;
			try {
				while((val = fr.read()) != -1) {
					System.out.print((char)val+" ");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
