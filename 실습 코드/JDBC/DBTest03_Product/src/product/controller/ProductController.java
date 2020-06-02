package product.controller;

import java.util.List;

import product.model.service.ProductService;
import product.model.vo.Product;

public class ProductController {
	ProductService ps = new ProductService();
	
	public List<Product> selectAll() {
		return ps.selectAll();
	}


	public Product selectOne(String id) {
		return ps.selectOne(id);
	}


	public int insert(Product res2) {
		return ps.insert(res2);
	}


	public int delete(String name4) {
		return ps.delete(name4);
	}


	public int update(Product res3) {
		return ps.update(res3);
	}

	
}
