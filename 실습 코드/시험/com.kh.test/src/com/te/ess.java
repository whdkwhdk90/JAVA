package com.te;

import java.util.StringTokenizer;

public class ess {
	
	public static void main(String[] args) {
		String colors = "banana#apple/orange sweet.hot";
	
		StringTokenizer st = new StringTokenizer(colors, "#/. ");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
	}
	
	
	
	
}