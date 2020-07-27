package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		//2. DB연결   (URL, ID, PW)
		Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"KH","KH");
		
		//3. SQL 실행
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMP");	
		
		//4. 결과 리턴 
		while(rs.next()) {  //getint(1)은 emp의 첫번째 컬럼(empno), "SAL"은 SAL이라는 컬럼
			System.out.println(rs.getInt(1)+" "+rs.getString(2)
			+" "+rs.getInt("SAL")); 
		}
		
		//5. 종료  (여는 순서 역순으로 닫기)
		rs.close();
		stmt.close();
		con.close();
		
	}

}


