package com.io.silsub1.run;

import com.io.silsub1.model.dao.FileIOTest;

public class Run {

	public static void main(String[] args) {
		FileIOTest fio = new FileIOTest();
		
		fio.fileSave();
		fio.fileRead();
		
	}

}
