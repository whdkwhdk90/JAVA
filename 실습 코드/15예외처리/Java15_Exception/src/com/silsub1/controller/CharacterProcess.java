package com.silsub1.controller;

import com.silsub1.exception.CharCheckException;
import com.silsub1.view.ConsoleIO;

public class CharacterProcess {
	int count = 0;
	public CharacterProcess(){}
	
	public void countAlpha(String s) throws CharCheckException{
	
		for(int i=0; i <s.length(); i++) {
			if((s.charAt(i)>='a' && s.charAt(i) <='z') ||
					(s.charAt(i)>='A' && s.charAt(i) <= 'Z'))
			{
				count++;
			}
				
		}
		
		if(count != s.length()) {
			throw new CharCheckException();
		}
		
		ConsoleIO ci = new ConsoleIO();
		ci.charOutput(s, count);
	}
	
	
}
