package com.silsub10.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.silsub1.exception.NumberRangeException;
import com.silsub10.controller.NumberProcess;

public class ConsoleIO {

	NumberProcess np = new NumberProcess();
	
	public void numberInput() throws NumberRangeException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str ="";
		double a = 0;
		double b = 0;
		try {
			System.out.print("첫번째 정수를 입력하시오 : ");
			 str =  br.readLine();
			 a = Double.parseDouble(str);
			 
			 System.out.print("두번째 정수를 입력하시오 : ");
			 str =  br.readLine();
			 b = Double.parseDouble(str);
			 
			 checkInt(a,b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
	
	
	public void charOutput(boolean isTrue) {
		
		if(isTrue) {
			System.out.println("의 배수가 맞습니다.");
		}else {
			System.out.println("의 배수가 아닙니다.");
		}
	}
	
	
	public void checkInt(double a, double b) throws NumberRangeException {
	
		
		if(a <1 || a >100 || b<1 || b>100) {
			throw new NumberRangeException();
		}else {
			np.checkDouble(a, b);
		}
			
		
		
	}
	
	
	
	
	
}
