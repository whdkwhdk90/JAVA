package product.controller;

import java.util.List;

import product.model.service.ProductService;
import product.model.vo.Product;

public class ProductController {
	ProductService ps = new ProductService();
	
	
	
	public List<Product> selectAll() {
		return ps.selectAll();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
