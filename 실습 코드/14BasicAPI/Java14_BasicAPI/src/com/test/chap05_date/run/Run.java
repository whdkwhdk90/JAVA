package com.test.chap05_date.run;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Run {
	public static void main(String[] args) {
		//Date
//		Date originTime = new Date(0L);
//		System.out.println(originTime);
//		
//		Date originTime1 = new Date(1000L);
//		System.out.println(originTime1);
//		//1000mile seconds = 1초
		
		String originTime = new Date(0L).toGMTString();
		System.out.println(originTime);	 //Greenwich Mean Time
										//그리니치 표준 시간(세계  표준 시간)
		
		Date today = new Date();
		System.out.println(today);
		
		//원하는 패턴으로
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
													//월만 대문자로 쓰는듯??
		System.out.println(sdf.format(today));
	
		
		System.out.println("-----캘린더-----");
		Calendar calendar = Calendar.getInstance();
		//현재 시간
		//calendar는 추상클래스 
		
		calendar.set(2020, 4-1,27);


		int year = calendar.get(1);
		int month = calendar.get(calendar.MONTH)+1;
		// int date = calendar.get(2);
		int date = calendar.get(calendar.DATE);
		// int date = calendar.get(5);
		int hour = calendar.get(calendar.HOUR);
		int min = calendar.get(calendar.MINUTE);
		int sec = calendar.get(calendar.SECOND);
		
		System.out.println(year+"년 "+month+"월 "+date+"일 "+hour+"시간 "+min+"분 "+sec+"초");
		//System.out.println(calendar);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sdf1.format(calendar.getTime()));
		//getTime에서는 set의 month값엔 -1, get에서는 +1을 해야 정상 출력됨.
		
		
		Calendar cal = (Calendar)calendar.clone();
		cal.add(calendar.YEAR, -10);
		cal.add(calendar.MONTH, -2);
		cal.add(calendar.DATE, 11);
		System.out.println(cal.getTime());
		
		
		//타임존
		TimeZone  tz = TimeZone.getTimeZone("Etc/Greenwich");
		sdf1.setTimeZone(tz);
		System.out.println(sdf1.format(calendar.getTime()));
		
		
//		for(String name : TimeZone.getAvailableIDs()) {
//			System.out.println(name);
//		} //타임존이 가능한 모두를 출력
//		
		
		//
		System.out.println("------그레고리안------");
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.getTime());
		gc.set(2018, 9-1,22);
		System.out.println(gc.getTime());
		
		
	}
}
