package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBTest05 {
	
	//insert
	public void insert() throws Exception {
		//1. 준비
		Connection con = null;
		PreparedStatement pstm = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "KH";
		String pw = "KH";
		Scanner sc = new Scanner(System.in);
		System.out.print("번호입력: ");
		int no = sc.nextInt();
		System.out.print("이름입력: ");
		String name = sc.next();
		System.out.print("별명입력: ");
		String nickname = sc.next();
		/*
		 * INSERT INTO MYTEST VALUES("+no+", '"+name+"',"+" '"+nickname+"'");
		 */
		//								물음표는 각각 (no, name, nickname)을 의미함
		String sql ="INSERT INTO MYTEST VALUES(?,?,?)";
		
		//2. 드라이버 등록
		Class.forName(driver);
		//3. DB연결
		con = DriverManager.getConnection(url,id,pw);
		//4. statement준비		(쿼리문이 언제 들어가느냐를 잘 봐야됨. prepared는 실행할 때 넣어줌)
		//	현재 sql은 매개변수가 ?,?,?로 채워져 있음.
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, no);			//첫번째 물음표는 no로 채워주자~
		pstm.setString(2, name);
		pstm.setString(3, nickname);
		//5. query 실행		(괄호안에 sql넣으려면 statement써야됨)
		int res = pstm.executeUpdate();
		//6. 결과 처리
		if(res>0) {
			System.out.println("insert 성공");
		}else {
			System.out.println("insert 실패");
		}
		//7. 종료
		pstm.close();
		con.close();
		sc.close();
	}
	
	//delete
	public void delete() throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstm = null;
		int res = 0;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "KH";
		String pw = "KH";
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 번호 입력: ");
		int no = sc.nextInt();
		String sql = "DELETE FROM MYTEST WHERE MNO="+no;
		
		Class.forName(driver);
		con = DriverManager.getConnection(url,id,pw);
		pstm = con.prepareStatement(sql);
		res = pstm.executeUpdate();
		if(res >0) {
			System.out.println("delete 성공");
		}else {
			System.out.println("delete 실패");
		}
		pstm.close();
		con.close();
		sc.close();	
	}

	//selectAll
	public void selectAll() throws SQLException, ClassNotFoundException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "KH";
		String pw = "KH";
		String sql = "SELECT * FROM MYTEST";
		
		Class.forName(driver);
		con = DriverManager.getConnection(url,id,pw);
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3));
		}
		rs.close();
		stmt.close();
		con.close();
	}


	public void selectOne() throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "KH";
		String pw = "KH";
		String sql = "SELECT * FROM MYTEST WHERE MNO=?";
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 번호: ");
		int no = sc.nextInt();
		
		Class.forName(driver);
		con = DriverManager.getConnection(url,id,pw);
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, no);
		
		rs =pstm.executeQuery();
		//하나만 가져오기에 while안쓰고 if로 해도 됨
		if(rs.next()) {
			System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3));
		}
		rs.close();
		pstm.close();
		con.close();
		sc.close();
	}
	
	
	
	
}
