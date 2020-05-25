package com.poly.test.test05;

public class Lg_tv implements Tv {

	
	int volume =0;
	
public Lg_tv() {
	System.out.println("TV 켜졌습니다.");
}	
	
	@Override
	public int volumeUp() {
		volume += 1;
		return volume;
		
	}

	@Override
	public int volumeDown() {
		volume -= 1;
		return volume;
	}

	
public void tvClosed() {
	System.out.println("TV 꺼졌습니다.");
}	
	
	
}
