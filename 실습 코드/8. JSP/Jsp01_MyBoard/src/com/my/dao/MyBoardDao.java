package com.my.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.dto.MyBoardDto;

public class MyBoardDao {
	Connection con = null;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "KH";
	String pw = "KH";
	public MyBoardDao() {
		try {
			Class.forName(driver);
			System.out.println("1. 드라이버 등록");
		} catch (ClassNotFoundException e) {
			System.out.println("1. 드라이버 등록 실패");
			e.printStackTrace();
		}
	}
	
	public List<MyBoardDto> selectAll() {
		try {
			con = DriverManager.getConnection(url,id,pw);
			System.out.println("2. con 연결 성공");
		} catch (SQLException e) {
			System.out.println("2. con 연결 실패");
			e.printStackTrace();
		}
		String sql = " SELECT * FROM MYBOARD ";
		List<MyBoardDto> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();
	
			System.out.println("3. 쿼리 준비");
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MyBoardDto dto = new MyBoardDto(
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5)
						);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("rs.에러입니다");
				e.printStackTrace();
			}
			
			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println("stmt에러입니다");
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("con 에러입니다.");
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int insert(MyBoardDto dto) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "KH";
		String pw = "KH";
		Connection con = null;
		PreparedStatement pstm = null;
		String sql = " INSERT INTO MYBOARD VALUES(MYSEQ.NEXTVAL,?,?,?,SYSDATE) ";
		int res = 0;
		try {
			con = DriverManager.getConnection(url,id,pw);
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMyname());
			pstm.setString(2, dto.getMytitle());
			pstm.setString(3, dto.getMycontent());
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	public MyBoardDto selectOne(int res) {
		MyBoardDto dto = new MyBoardDto();
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "KH";
		String pw = "KH";
		Connection con = null;
		String sql = " SELECT * FROM MYBOARD WHERE MYNO = "+res;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url,id,pw);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				dto.setMyno(rs.getInt(1));
				dto.setMyname(rs.getString(2));
				dto.setMytitle(rs.getString(3));
				dto.setMycontent(rs.getString(4));
				dto.setMydate(rs.getDate(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return dto;
	}

	public int update(MyBoardDto dto) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "KH";
		String pw = "KH";
		String sql = " UPDATE MYBOARD SET MYTITLE=?, MYCONTENT=? WHERE MYNO=?  ";
		try {
			con = DriverManager.getConnection(url,id,pw);
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMytitle());
			pstm.setString(2, dto.getMycontent());
			pstm.setInt(3, dto.getMyno());
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public int delete(int myno) {
		int res = 0;
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "KH";
		String pw = "KH";
		PreparedStatement pstm = null;
		String sql = " DELETE FROM MYBOARD WHERE MYNO=? ";
		try {
			con = DriverManager.getConnection(url,id,pw);
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
}
