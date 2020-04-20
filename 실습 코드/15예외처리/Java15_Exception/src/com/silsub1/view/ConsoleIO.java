package com.silsub1.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import com.silsub1.controller.CharacterProcess;
import com.silsub1.exception.CharCheckException;


public class ConsoleIO {

	
	public void charInput() throws CharCheckException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("문자열을 입력하시오 : ");		
			String str;
			try {
				str = br.readLine();
				checkString(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			
	}
	
	
	public void charOutput(String s, int count) {
		System.out.println("입력받은 문자열 "+s+" 중 영문자의 갯수는 "+count+"개 입니다.");
		
		
	}
	
	
	public void checkString(String s) throws CharCheckException {
		CharacterProcess cpp = new CharacterProcess();
		
		cpp.countAlpha(s);
		
		
	}
	
	
}
