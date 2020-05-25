package com.silsub1.run;


import com.silsub1.model.Sample;
import com.kh.inputTest.TestCommandLine;

public class Main {
			public static void main(String[] args) {
	
			Sample sp = new Sample();
//		sp.munjae1();
//		sp.munjae2();
	
		Main test = new Main();
//		test.TestTest01();
		test.TestTest02();
		
		
			}
			
	public void TestTest01() {
		
		int[][] iarr = new int[5][5];
		int k = 1;
		int L = 0;
		
for(int i = 0; i < iarr.length; i++) {
		if(i%2 ==0)
		{     
				for(int j=0; j < iarr[i].length; j++) {
					
					iarr[i][j] = k;
					System.out.print("\t"+ iarr[i][j]);
					k++;	
				}	k += 5;
					System.out.println();	
	
		
		}
		
		else {
				for(int j=0; j < iarr[i].length; j++) {
				
					iarr[i][j] = 5*(i+1) - L;
					System.out.print("\t"+ iarr[i][j]);
					L++;	
				}	L = 0;
					System.out.println();	
			
			}	
	

		}
		
	
	}		
			
	public void TestTest02() {
		int[][] arr = new int[5][5];
		
for(int i = 0; i < arr.length; i++) {
			for(int j = 0 ; j< arr[i].length; j++) {
					arr[i][j] = (i+1);
					arr[i][j] += 5*j;
				System.out.print("\t"+ arr[i][j]);			
			}System.out.println();
	
	
	
		}
	
	}	
}
