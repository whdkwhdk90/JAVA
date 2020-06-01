package common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			//따로 파일화 시켜놓으면 파일만 열어서 수정하면 되니 관리가 수월함
			Properties prop = new Properties();
			prop.load(new FileReader("driver.properties"));
			
			//properties도 key와 value로 구성.   A = B 꼴로 되어있으면 A는 KEY, B는 VALUE값임.
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			con.setAutoCommit(false);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return con;
	}
	
	
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//2개의 close를 호출하는 메소드
	public static void close(Connection con, Statement stmt) {
		try {
			con.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//3개의 close를 호출하는 메소드
	public static void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
