package com.silsub1.model;

import java.util.Scanner;

public class Sample {

	public void munjae1() {
	
		
/*		
		int[][] iarr = new int[4][4];
		
	
		int sum = 0;
		for(int i = 0; i <3; i++) {
				for(int j =0; j <3; j++) {
						iarr[i][j] =(int)(Math.random()*100 +1);
				//	System.out.print("\t" + iarr[i][j]);
					iarr[i][3] += iarr[i][j];
				//	System.out.print("\t" + iarr[i][3]);
					iarr[3][j] += iarr[i][j];
				//	System.out.print("\t" + iarr[3][j]);
				}//System.out.println();
			
			}
	
		for(int i = 0 ; i <4 ; i ++) {
			for(int j =0 ; j <4; j++) {
									
									
				
				
							if( (i==3)&&(j==3)) {
									iarr[3][3] = 2*sum/3;
							}
							System.out.print("\t"+ iarr[i][j]);
					sum += iarr[i][j];
															
																
																
			} 
			System.out.println();
			
		}
	*/
		
/*		int[][] iarr = new int[4][4];
	
		int sum = 0;
    	for(int i = 0; i <3; i++) {
				for(int j =0; j <3; j++) {
						iarr[i][j] =(int)(Math.random()*100 +1);
				//	System.out.print("\t" + iarr[i][j]);
					iarr[i][3] += iarr[i][j];
				//	System.out.print("\t" + iarr[i][3]);
					iarr[3][j] += iarr[i][j];
				//	System.out.print("\t" + iarr[3][j]);
				}//System.out.println();
	
			}
	*/
		
		int[][] iarr = new int[4][4];
		int sum = 0;
		
		for(int i = 0 ; i <iarr.length ; i ++) {
				for(int j =0 ; j <iarr[i].length; j++) {
								if((i  == 3) || ( j ==3) ) {	
											
			
														if( (i==3)&&(j==3)) {
																		
																	iarr[3][3] = 2*sum/3;
																	System.out.print("\t"+ iarr[i][j]);				
																	break;
														}
																	
														else {
																		
															sum += iarr[i][j];
															System.out.print("\t" + iarr[i][j]);											
											}
							
								}else {
										iarr[i][j] =(int)(Math.random()*100 +1);
										iarr[i][3] += iarr[i][j];
										iarr[3][j] += iarr[i][j];
										System.out.print("\t"+ iarr[i][j]);
										sum += iarr[i][j];								
									}
									
			}System.out.println();
			
			
		}
		
		
}
		
	
	
	public void munjae2() {
		
		int[][] iarr = new int[3][];
		int num=0;
		int sum=0;
		Scanner sc =new Scanner(System.in);
		
for(int i = 0; i <iarr.length; i++) {		
		System.out.print(" 갯수를 입력하시오 : ");
		num = sc.nextInt();
		iarr[i] =  new int[num];
					for(int j = 0;  j <num; j++) {
							iarr[i][j] =(int)(Math.random()*100+1);
									sum += iarr[i][j];
															}	System.out.println("sum의 값 : " + sum);
																		if(sum%5 ==0) {
																					for(int k = 0; k <num; k++) {
																					System.out.print("\t" + iarr[i][k]);
																		}	
																	}		sum = 0;
																		System.out.println();													
						}
			}

	
}
