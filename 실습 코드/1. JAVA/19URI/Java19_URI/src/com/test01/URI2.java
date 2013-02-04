package com.test01;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;


public class URI2 {
	public static void main(String[] args) throws IOException {
	byte[] b = new byte[1];
	
	URL url = new URL("https://cdn.inflearn.com/wp-content/uploads/java_ver.2018-2.jpg");
	
	URLConnection urlConnection = url.openConnection();
	urlConnection.connect();
	DataInputStream di = new DataInputStream(urlConnection.getInputStream());
	
	FileOutputStream fo = new FileOutputStream("a.jpg");
	
	while(di.read(b,0,1) != -1) {
		fo.write(b,0,1);
	}
	
	System.out.println("완료");
	di.close();
	fo.close();
	
}
	
}
