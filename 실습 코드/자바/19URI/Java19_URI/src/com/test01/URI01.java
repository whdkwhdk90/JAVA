package com.test01;

import java.net.URI;
import java.net.URISyntaxException;

public class URI01 {

	/*
	 URL(Uniform Resource Locator) : 주소(위치)
	 	특정 서버의 한 리소스에 대한 구체적인 위치를 서술
	 URN(Uniform Resource Name) : 대상(이름)
	 URI(Uniform Resource Identifier) : URL+URN(통합 자원 식별자)	
	 */
	public static void main(String[] args) throws URISyntaxException {
		URI u = new URI("http://localhost:8787/java19_URI_Web/res.jsp"+"?tname=lee&taddr=seoul");
	
	System.out.println(u.getHost());
	System.out.println(u.getHost());
	System.out.println(u.getQuery());
	
	
	
	}
	
	
	
	
	
}
