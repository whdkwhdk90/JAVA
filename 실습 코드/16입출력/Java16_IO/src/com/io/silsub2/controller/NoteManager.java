package com.io.silsub2.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.io.silsub2.model.dao.NoteDao;

public class NoteManager {
	Scanner sc= new Scanner(System.in);
	
	
	public void fileSave() {
		StringBuilder sb = new StringBuilder();
		char answer = ' ';
		String str ="";
		String fileName ="";
		NoteDao nd = new NoteDao();
		
		while(true) {
		System.out.print("파일에 저장할 내용을 입력하시오 : ");
		str = sc.next();
		if(str.equals("exit")) {
			break;
			}
		sb.append(str);
		}
		
		System.out.print("저장하시겠습니까?(y/n): ");
		answer = sc.next().charAt(0);
		if(answer =='Y' || answer == 'y') {
			System.out.print("저장할 파일명을 입력하세요: ");
			fileName = sc.next();
			nd.FileSave(sb, fileName);
		}
		
				
	}
	public void fileOpen() {
		NoteDao nd = new NoteDao();
		StringBuilder sb = new StringBuilder();
		System.out.print("열기할 파일명을 입력하세요: ");
		String str = sc.next();
		
		System.out.println(nd.fileOpen(str));
		
		
		
		
	}
	
	
}
