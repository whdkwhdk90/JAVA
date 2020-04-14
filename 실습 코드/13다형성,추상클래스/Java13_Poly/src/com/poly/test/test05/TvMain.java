package com.poly.test.test05;

public class TvMain {
	public static void main(String[] args) {
		
		Lg_tv lg = new Lg_tv();
		
		
		System.out.println("현재 볼륨은 "+lg.volumeUp()+"입니다.");
		lg.volumeUp();
		System.out.println("현재 볼륨은 "+lg.volume+"입니다.");
		lg.volumeUp();		
		System.out.println("현재 볼륨은 "+lg.volume+"입니다.");
		lg.volumeDown();
		System.out.println("현재 볼륨은 "+lg.volume+"입니다.");
		lg.tvClosed();
		
		Samsung_tv samsung = new Samsung_tv();
		
		samsung.volumeUp();
		System.out.println("현재 볼륨은 "+samsung.volume+"입니다.");
		samsung.volumeUp();
		System.out.println("현재 볼륨은 "+samsung.volume+"입니다.");
		samsung.volumeUp();
		System.out.println("현재 볼륨은 "+samsung.volume+"입니다.");
		samsung.volumeDown();
		System.out.println("현재 볼륨은 "+samsung.volume+"입니다.");
		samsung.tvClosed();
		
		
		
		
		
	}
}
