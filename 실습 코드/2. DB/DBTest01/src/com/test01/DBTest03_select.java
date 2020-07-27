package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBTest03_select {
	public static void main(String[] args) throws Exception {
		//jdbc를 통한 db연결 후 mytest테이블 select하는 코드 작성
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KH","KH");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM MYTEST");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getString(3));
		}
		rs.close();
		stmt.close();
		con.close();
	}
}
