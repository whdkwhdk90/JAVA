package com.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.Member;

public class MemberDaoImpl implements MemberDao{

	@Override
	public List<Member> selectAll(Connection con) {
			Statement stmt = null;
			ResultSet rs = null;
			List<Member> res = new ArrayList<>();
			
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(selectAll);
				
				while(rs.next()) {
					Member tmp = new Member();
					tmp.setM_no(rs.getInt(1));
					tmp.setM_name(rs.getString(2));
					tmp.setM_age(rs.getInt(3));
					tmp.setM_gender(rs.getString("M_GENDER"));
					tmp.setM_location(rs.getString(5));
					tmp.setM_job(rs.getString(6));
					tmp.setM_tell(rs.getString(7));
					tmp.setM_email(rs.getString(8));
					res.add(tmp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(stmt);
			}
		return res;
	}

	@Override
	public Member selectOne(Connection con, int no) {
		Member m = new Member();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = con.prepareStatement(selectOne);
			pstm.setInt(1, no);
			rs = pstm.executeQuery();
			while(rs.next()) {
				m.setM_no(rs.getInt(1));
				m.setM_name(rs.getString(2));
				m.setM_age(rs.getInt(3));
				m.setM_gender(rs.getString("M_GENDER"));
				m.setM_location(rs.getString(5));
				m.setM_job(rs.getString(6));
				m.setM_tell(rs.getString(7));
				m.setM_email(rs.getString(8));		
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
		}
		return m;
	}

	@Override
	public int insert(Connection con, Member m) {
		PreparedStatement stmt = null;
		int ress =0;
		try {
			stmt =con.prepareStatement(insert);
			stmt.setInt(1, m.getM_no());
			stmt.setString(2,m.getM_name());
			stmt.setInt(3,m.getM_age());
			stmt.setString(4,m.getM_gender());
			stmt.setString(5,m.getM_location());
			stmt.setString(6,m.getM_job());
			stmt.setString(7,m.getM_tell());
			stmt.setString(8,m.getM_email());	
			ress = stmt.executeUpdate();
			commit(con);
		} catch (SQLException e) {
			rollback(con);
			e.printStackTrace();
		}finally {
			close(stmt);
		}
		return ress;
	}

	@Override
	public int delete(Connection con, int no) {
			PreparedStatement stmt = null;
			int ress =0;
			try {
				stmt = con.prepareStatement(delete);
				stmt.setInt(1, no);
				ress = stmt.executeUpdate();
				commit(con);
			} catch (SQLException e) {
				rollback(con);
				e.printStackTrace();
			}finally {
				close(stmt);
			}
		return ress;
	}

	@Override
	public int update(Connection con, Member m) {
			PreparedStatement stmt = null;
			int ress = 0;
			try {
				stmt = con.prepareStatement(update);
				stmt.setInt(8, m.getM_no());
				stmt.setString(1,m.getM_name());
				stmt.setInt(2,m.getM_age());
				stmt.setString(3,m.getM_gender());
				stmt.setString(4,m.getM_location());
				stmt.setString(5,m.getM_job());
				stmt.setString(6,m.getM_tell());
				stmt.setString(7,m.getM_email());	
				ress = stmt.executeUpdate();
				commit(con);
			} catch (SQLException e) {
				rollback(con);
				e.printStackTrace();
			}finally {
				close(stmt);
			}
		return ress;
	}

}
