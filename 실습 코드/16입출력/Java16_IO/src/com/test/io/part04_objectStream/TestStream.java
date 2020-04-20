package com.test.io.part04_objectStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestStream {

	public void fileSave() {
		Member[] mar = {
				new Member("user01","pass01","이창진","lee@kh.org",19,'남'),
				new Member("user02","pass02,","황선웅","ksh@kh.org",20,'남'),
				new Member("user03","pass03","한예인","hyi@kh.org",21,'여')	
				};
		
		
		try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("member.dat"));) 
		{
			for(int i=0; i<mar.length; i++) {
				objOut.writeObject(mar[i]);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void fileOpen() {
		Member[] mar = new Member[3];
		
		try( ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("member.dat"));)
		{
			for(int i=0; i<mar.length; i++) {
				mar[i] = (Member)objIn.readObject();
			}
			
			for(Member m : mar) {
				System.out.println(m);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch(Exception e) {     //위의 catch들 모두 exception으로 다 잡힘. 모두 exception의 자식들
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
	
}
