package com.test01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetTest {
	//IP주소를 표현하는 class
	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		
		System.out.println(addr);
		System.out.println("localhost : "+addr.getHostAddress());
		System.out.println("host name : "+addr.getHostName());
		
		InetAddress[] naver = InetAddress.getAllByName("www.naver.com");

		for(int i=0;i<naver.length;i++) {
			System.out.print(naver[i].getHostName()+" : ");
			System.out.println(naver[i].getHostAddress());
		}
	}
}
