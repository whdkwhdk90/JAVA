package com.mvc.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.dto.MyMVCDto;

public class MyMVCDaoImpl implements MyMVCDao{

	@Override
	public List<MyMVCDto> selectAll() {
		List<MyMVCDto> res = new ArrayList<>();
		Connection con = getConnection();
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		try {
			pstm = con.prepareStatement(selectAllSql);
			System.out.println("03. query 준비 : "+ selectAllSql);
			
			rs = pstm.executeQuery();
			System.out.println("04. query 실행 및 리턴");
			
			while(rs.next()) {
				MyMVCDto tmp = new MyMVCDto(
				rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5)		
						);
				res.add(tmp);
			}
		} catch (SQLException e) {
			System.out.println("3/4단계 에러");
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05. db 종료 \n");
		}
		return res;
	}

	@Override
	public MyMVCDto selectOne(int seq) {
		MyMVCDto dto = null;
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = con.prepareStatement(selectOneSql);
			pstm.setInt(1, seq);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				dto = new MyMVCDto(rs.getInt(1), rs.getString(2),
						rs.getString(3),rs.getString(4),rs.getDate(5));
							}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
		}
		return dto;
	}

	@Override
	public boolean insert(MyMVCDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		try {
			pstm = con.prepareStatement(insertSql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			
			res = pstm.executeUpdate();
			
			if(res>0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			System.out.println("3/4단계 에러");
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			System.out.println("05. db 종료\n");
		}
		return (res>0)?true:false;
	}

	@Override
	public boolean update(MyMVCDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(updateSql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());

			res = pstm.executeUpdate();
			
			if(res>0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		return (res>0)?true:false;
	}

	@Override
	public boolean delete(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(deleteSql);
			pstm.setInt(1, seq);
			
			res = pstm.executeUpdate();
			
			if(res>0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		return (res>0)?true:false;
	}

}
