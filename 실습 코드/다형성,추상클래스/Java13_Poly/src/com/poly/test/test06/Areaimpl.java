package com.poly.test.test06;

public abstract class Areaimpl implements Area {
	private String res;
	
	
	@Override
	public void print() {
		System.out.println(Area.print+res);
	}
	
	@Override
	public abstract void make();

	
	
	public void setRes(String res) {
		this.res = res;
	}
		
	
	
}
