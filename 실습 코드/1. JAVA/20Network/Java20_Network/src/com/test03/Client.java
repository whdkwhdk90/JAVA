package com.test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable{
	
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Client());
		t1.start();
		
	}
	

	@Override
	public void run() {
		
		try {
			Socket clientSocket = null;
			PrintWriter out = null;
			BufferedReader in = null;
			BufferedReader stdIn = null;
			
			System.out.println("server에 접속합니다.....");
			
			clientSocket = new Socket("localhost",8585);
			
			out = new PrintWriter(clientSocket.getOutputStream(),true);
			
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			//키보드로 입력을 받을 친구
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			String inputLine;
			while( (inputLine= stdIn.readLine()) != null  ) {
				out.println(inputLine);
				System.out.println("server로부터 다시받은 메시지: " + in.readLine());
				
			}
			out.close();
			in.close();
			stdIn.close();
			clientSocket.close();
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
}
