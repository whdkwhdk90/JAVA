package product.model.service;

import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import product.model.dao.ProductDao;
import product.model.vo.Product;

import static common.JDBCTemplate.*;

public class ProductService {

	public List<Product> selectAll() {
		ProductDao dao = new ProductDao();
		Connection con = getConnection();
		ArrayList<Product> res = dao.selectAll(con);
		close(con);
		return res;
	}

	public Product selectOne(String id) {
		ProductDao dao = new ProductDao();
		Connection con = getConnection();
		Product res = dao.selectOne(con,id);
		close(con);
		return res;
	}

	public int insert(Product res2) {
		ProductDao dao = new ProductDao();
		Connection con = getConnection();
		int number = dao.insert(con,res2);
		if(number>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return number;
	}

	public int update(Product res3) {
		ProductDao dao = new ProductDao();
		Connection con = getConnection();
		int number = dao.update(con,res3);
		if(number>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return number;
	}

	public int delete(String name4) {
		ProductDao dao = new ProductDao();
		Connection con = getConnection();
		int number = dao.delete(con,name4);
		if(number>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return number;
	}
	
}
