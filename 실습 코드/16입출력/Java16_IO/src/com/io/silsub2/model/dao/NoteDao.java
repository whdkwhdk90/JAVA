package com.io.silsub2.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NoteDao {

	public void FileSave(StringBuilder sb, String fileName) {
		BufferedWriter fw = null;
		try {
			fw = new BufferedWriter(new FileWriter(fileName));
			fw.write(sb.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println(fileName+"파일에 성공적으로 저장하였습니다.");
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	
	}
	
	public StringBuilder fileOpen(String fileName) {
		BufferedReader br = null;
		StringBuilder sb = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			sb = new StringBuilder();
			
			String str = "";
			
			while( (str = br.readLine()) != null  ) {
				sb.append(str);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb;
	}
	
}
