package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	
	public static Connection getConnection() {
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "KH";
		String pw = "KH";
		String driver = "oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(driver);
			try {
				con = DriverManager.getConnection(url,id,pw);
				
				con.setAutoCommit(false);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static boolean isConnection(Connection con) {
	
		boolean valid = true;
		try {
			if(con.isClosed() || con == null) {
				valid = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return valid;
	}
	
	public static void close(Connection con) {
		
		if(isConnection(con)) {
			try {
				con.close();
				System.out.println("con 종료 성공");
			} catch (SQLException e) {
				System.out.println("con 종료 실패");
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs) {
		
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void commit(Connection con) {
		
		if(isConnection(con)) {
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void rollback(Connection con) {
		
		if(isConnection(con)) {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
