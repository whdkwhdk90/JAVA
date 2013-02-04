package com.biz;

import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.dao.MemberDaoImpl;
import com.dto.Member;
import static common.JDBCTemplate.*;

public class MemberBizImpl implements MemberBiz{
	MemberDaoImpl dao = new MemberDaoImpl();
	
	
	@Override
	public List<Member> selectAll() {
		Connection con = getConnection();
		List<Member> res = dao.selectAll(con);
		close(con);
		return res;
	}

	@Override
	public Member selectOne(int no) {
		Connection con = getConnection();
		Member m = dao.selectOne(con, no);
		close(con);
		return m;
	}

	@Override
	public int delete(int no) {
		Connection con = getConnection();
		int res1 = dao.delete(con, no);
		close(con);
		return res1;
	}

	@Override
	public int update(Member m) {
		Connection con = getConnection();
		int res3 = dao.update(con, m);
		return res3;
	}

	@Override
	public int insert(Member m) {
			Connection con = getConnection();
			int res2 = dao.insert(con, m);
			close(con);
		return res2;
	}

}
