package product.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import product.model.vo.Product;
import static common.JDBCTemplate.*;

public class ProductDao {
	
	private Properties prop;
	
	public ProductDao() {
		//여기서 properties를 읽을꺼임.
		prop = new Properties();
		try {
			prop.load(new FileReader("query.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Product> selectAll(Connection con) {
			PreparedStatement pstm = null;
			ResultSet rs = null;
			ArrayList<Product> list = null;
			String sql = prop.getProperty("selectAll");
			
			try {
				pstm  = con.prepareStatement(sql);
				rs = pstm.executeQuery();
				
				list = new ArrayList<>();
				
				while(rs.next()) {
					Product p = new Product();
					p.setpId(rs.getString(1));
					p.setpName(rs.getString(2));
					p.setPrice(rs.getInt(3));
					p.setDesc(rs.getString(4));
					list.add(p);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstm);
			}
		return list;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
