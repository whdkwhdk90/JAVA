package com.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import common.JDBCTemplate;
//import static common.JDBCTemplate.*;				//extends해서 import하거나 그냥 static으로 import하는 방법 

public class DBTest06 extends JDBCTemplate{
	//전체 선택
	public void selectAll() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MYTEST";
		
		con = getConnection();
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3));
			}	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
		}
		
	}
	//삭제
	public void delete() {
		Connection con = null;
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = "DELETE FROM MYTEST WHERE MNO=?";
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 번호 입력: ");
		int no = sc.nextInt();
		
		con = getConnection();
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, no);
			res = pstm.executeUpdate();
			if(res>0) {
				System.out.println("delete 성공");
			}else {
				System.out.println("delete 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			sc.close();
		}	
	}
	
	//DAO(Data Access Object)
	
	//삽입
	public void insert() {
		Connection con = null;
		PreparedStatement pstm = null;
		int res = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("번호 입력: ");
		int num = sc.nextInt();
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("별칭 입력 : ");
		String nickname = sc.next();
		String sql = "INSERT INTO MYTEST VALUES(?,?,?)";
		
		con = getConnection();
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, num);
			pstm.setString(2, name);
			pstm.setString(3, nickname);
			res = pstm.executeUpdate();
			if(res>0) {
				System.out.println("insert 성공");
			}else {
				System.out.println("insert 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			sc.close();
		}	
	}
	
	//1개 선택
	public void selectOne() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("번호 선택: ");
		int no = sc.nextInt();
		String sql = "SELECT * FROM MYTEST WHERE MNO =?";
		
		con = getConnection();
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, no);
			rs = pstm.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			sc.close();
		}
		
		
	}


}
