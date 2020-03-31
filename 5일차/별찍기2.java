package com.test01;

import java.util.Scanner;

public class 별찍기2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int num1=1, num2=1;
		
		
		for ( int i = 1; i <= N; i++)
		{
				for(int j = 1; j <= N; j++) {
					System.out.print("*");
					num2++;
					
							if(num1 == num2) {
								
								System.out.print("\n");
								num1++;
								}
									
									
		}
			
				
		
		}
	}
}
