package com.silsub10.controller;

import com.silsub10.exception.NumberRangeException;
import com.silsub10.view.ConsoleIO;
import com.silsub1.exception.*;
public class NumberProcess {
	
	
	public boolean checkDouble(double a, double b) throws NumberRangeException {
		ConsoleIO ci = new ConsoleIO();
		boolean isTrue = false;
		if(a%b ==0) {
			isTrue = true;
			System.out.print(a+"는 "+b);
			ci.charOutput(isTrue);
			return isTrue;
		}else {
			System.out.print(a+"는 "+b);
			ci.charOutput(isTrue);
			return isTrue;
		}
		
	}
	
}
