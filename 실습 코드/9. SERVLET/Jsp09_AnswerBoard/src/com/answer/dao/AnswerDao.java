package com.answer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.answer.dto.AnswerDto;

import common.JDBCTemplate;

public class AnswerDao  extends JDBCTemplate{
	
	//전체 출력
	public List<AnswerDto> selectAll(){
		List<AnswerDto> res = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM ANSWERBOARD ORDER BY GROUPNO DESC, GROUPSQ ";
		
		try {
			pstm = con.prepareStatement(sql);
			rs= pstm.executeQuery();
			
			while(rs.next()) {
				AnswerDto dto = new AnswerDto(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8));
				res.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
		}
		return res;
	}
	
	//글 등록
	public int insert(AnswerDto dto) {
		int res = 0;
		Connection con = getConnection();
		PreparedStatement pstm = null;
		String sql = " INSERT INTO ANSWERBOARD VALUES(BOARDNOSQ.NEXTVAL,GROUPNOSQ.NEXTVAL,1,0,?,?,?,SYSDATE)	";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setString(3, dto.getWriter());
			
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
		return res;
	}

	public AnswerDto selectOne(int boardno) {
		AnswerDto dto = new AnswerDto();
		Connection con =getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM ANSWERBOARD WHERE BOARDNO=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, boardno);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				dto = new AnswerDto(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),
						rs.getString(5),rs.getString(6),rs.getString(7), rs.getDate(8)
						);
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

	//answer-update
	public int updateAnswer(int parentgroupno, int parentgroupsq) {
		int res = 0;
		Connection con = getConnection();
		PreparedStatement pstm = null;
		String sql = " UPDATE ANSWERBOARD SET GROUPSQ = GROUPSQ+1 WHERE GROUPNO=? AND GROUPSQ > ? ";
		String sql2 = " UPDATE ANSWERBOARD SET GROUPSQ = GROUPSQ+1 WHERE GROUPNO=(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=? ) AND GROUPSQ> "
				+ " (SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=?) ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, parentgroupno);
			pstm.setInt(2, parentgroupsq);
			
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
		
		return res;
	}

	//ANSWER-INSERT
	public int insertAnswer(AnswerDto dto) {
		int res = 0;
		Connection con = getConnection();
		PreparedStatement pstm = null;
		String sql = " INSERT INTO ANSWERBOARD VALUES(BOARDNOSQ.NEXTVAL,?,?,?,?,?,?,SYSDATE) ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, dto.getGroupno());
			pstm.setInt(2, dto.getGroupsq()+1);
			pstm.setInt(3, dto.getTitletab()+1);
			pstm.setString(4, dto.getTitle());
			pstm.setString(5, dto.getContent());
			pstm.setString(6, dto.getWriter());
			
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
		
		return res;
	}






















}
