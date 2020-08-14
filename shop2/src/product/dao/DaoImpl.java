package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import conn.DBConnect;
import model.Product;

public class DaoImpl implements Dao {
	
	private DBConnect db;
	
	public DaoImpl() {
		db = DBConnect.getInstance();
	}

	

	public void insert(Product p) {
		
		Connection conn = db.getConnection();
		
		String sql = "insert into shop_product values(seq_shop_product.nextval, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setInt(2, p.getQuantity());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getImg());
			pstmt.setString(5, p.getContent());
			pstmt.setString(6, p.getS_id());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	
	public Product select(int num) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product = null;
		
		String sql = "select * from shop_product where num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return product;
	}
	
	public ArrayList<Product> selectAllById(String s_id) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Product> products = new ArrayList<Product>();
		
		String sql = "select * from shop_product where s_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				products.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return products;
	}

	

	public void update(Product p) {
		Connection conn = db.getConnection();
		
		String sql = "update shop_product set name=?, quantity=?, price=?, content=?, where num=?";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setInt(2, p.getQuantity());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getContent());
			pstmt.setInt(5, p.getNum());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public void delete(int num) {
		Connection conn = db.getConnection();
		String sql = "delete shop_product where num=?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		}

	@Override
	public int selectNum() {
		Connection conn = db.getConnection();
		String sql = "select seq_shop_product.nextval from dual";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return num;
	}
	
	
	

	
	public ArrayList<Product> selectAll() {
		
		
		return null;
	}

	
	
	public void updateQuantity(int q, int num) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "update shop_product set qunatity=quantity-? where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, q);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
