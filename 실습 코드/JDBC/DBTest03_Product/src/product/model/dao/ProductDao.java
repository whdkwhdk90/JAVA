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

	public Product selectOne(Connection con, String id) {
			PreparedStatement pstm = null;
			ResultSet rs = null;
			Product res = null;
			
			String sql = prop.getProperty("selectOne");
			
			try {
				pstm = con.prepareStatement(sql);
				pstm.setString(1, id);
				rs = pstm.executeQuery();
				
				while(rs.next()) {
					res = new Product();
					res.setpId(rs.getString(1));
					res.setpName(rs.getString(2));
					res.setPrice(rs.getInt(3));
					res.setDesc(rs.getString(4));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstm);
			}
		return res;
	}

	public int insert(Connection con, Product res2) {
		PreparedStatement pstm = null;
		int number = 0;
		
		String sql = prop.getProperty("insert");
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, res2.getpId());
			pstm.setString(2, res2.getpName());
			pstm.setInt(3, res2.getPrice());
			pstm.setString(4, res2.getDesc());
			
			number = pstm.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		return number;
	}

	
	public int update(Connection con, Product res3) {
		PreparedStatement pstm = null;
		int number = 0;
		
		String sql = prop.getProperty("update");
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(4, res3.getpId());
			pstm.setString(1, res3.getpName());
			pstm.setInt(2, res3.getPrice());
			pstm.setString(3, res3.getDesc());
			
			number = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		return number;
	}
	
	
	public int delete(Connection con, String name4) {
		PreparedStatement pstm = null;
		int number = 0;
		
		String sql = prop.getProperty("delete");
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, name4);
			
			number = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		
		return number;
	}

	

	
}
