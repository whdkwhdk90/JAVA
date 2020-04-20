package com.test.io.part01_byteStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestByteStream {

	public void fileSave() {
		FileOutputStream fout = null;
		
		
		try {
			fout = new FileOutputStream("sample.txt");
			//대상 파일이 존재하지 않으면 자동으로 파일을 만든다.
			fout.write(97);
			//숫자 97이 a로 변환되서 들어감.
			byte[] bar = {98,99,100,101,102,10};
			//여기서의 10은 줄바꿈이다!!
			fout.write(bar);
			fout.write(bar, 1, 3);
			//뒤에 숫자로 넣으면 잘라서 넣는다. 1부터 3까지(총 3개)
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	public void fileOpen() {
		FileInputStream fin = null;
		//file이 붙어있기때문에 기반stream;
		//inputStream이기때문에 byte단위
		
		try {
			fin = new FileInputStream("sample.txt");
			int fileSize =(int) new File("sample.txt").length();
			
			//System.out.println(fileSize);
			
			
			//파일을 읽어서 저장할 파일 크기 만큼의 byte 배열 선언
			byte[] bar = new byte[fileSize];
			
			fin.read(bar);
			
			for(int i = 0 ; i < bar.length; i++) {
				
				System.out.print(bar[i]+" ");
				//유니코드로 읽어옴
				
				
				System.out.print((char)bar[i]+" ");
			}
			
			
//			for(int i = 0 ; i <15; i++) {
//				System.out.print(fin.read()+" ");
//				//읽을 값이 없는데 읽으라고하면 -1을 얻어옴.
//			}
//			
			//조건문에서 fin.read()를 읽고 true가 되면
			//sysout에서 다음꺼를 읽음.
//			int gap = 0;
//			
//			while(gap != -1) {	
//				gap = fin.read();
//					if(gap == -1) {
//						break;
//					}else {
//					System.out.print(gap+" ");
//					}			
//			}
			
			
			//강사님
			int no;
			while( (no = fin.read()) != -1) {
				System.out.print((char)no+" ");
			}
			
			//sample.txt 파일안에 한글을 입력하면 출력 깨짐.(이건 byte단위, 한글은 2byte단위이기에)
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
