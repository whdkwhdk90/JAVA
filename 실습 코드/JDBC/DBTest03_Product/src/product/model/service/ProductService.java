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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
