package com.inherit.part01_inherit.model.vo;

import java.util.Date;

public class Computer extends Product {

		private String cpu;
		private int hdd;
		private int ram;
		private String os;
		
	//생성자	
public Computer() {}		
public Computer(String brand, String productNumber, String productCode, String productName, int price,
						Date date, String cpu, int hdd, int ram, String os) {
	super(brand,productNumber,productCode,productName,price,date);    //부모 클래스의 생성자에게 초기화 요청!!
	this.cpu = cpu; 				//나머지는 여기서 만든것이기 때문에 여기서 this.로 초기화
	this.hdd = hdd;
	this.os = os;
	this.ram = ram;
}

			//getter & setter	
			public String getCpu() {
				return cpu;
			}
			public void setCpu(String cpu) {
				this.cpu = cpu;
			}
			
			
			
			public int getHdd() {
				return hdd;
			}
			public void setHdd(int hdd) {
				this.hdd = hdd;
			}
			
			
			
			public int getRam() {
				return ram;
			}
			public void setRam(int ram) {
				this.ram = ram;
			}
			
			
			
			public String getOs() {
				return os;
			}
			public void setOs(String os) {
				this.os = os;
			}		
					
		
	@Override
	public String prnInfo() {
		return super.prnInfo()+", "+this.cpu+", "+this.hdd+", "+this.ram+ ", "+this.os;
	}
	








}
