package order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import model.Order;

public class DaoImpl implements Dao {
	private DBConnect db;

	public DaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Order o) {
		Connection conn = db.getConnection();
		
		String sql = "insert into shop_order values(seq_shop_order.nextval, ?, ?, ?, ?, sysdate, ?, 0)";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, o.getPro_num());
			pstmt.setInt(2, o.getOrder_num());
			pstmt.setInt(3, o.getTotal_price());
			pstmt.setString(4, o.getO_id());
			pstmt.setInt(5, o.getO_state());
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

	@Override
	public Order select(int num) {
		Order o = null;
		ResultSet rs = null;
		Connection conn = db.getConnection();
		String sql = "select * from shop_order where num=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getInt(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public ArrayList<Order> selectAll(String o_id, int o_state) {
		ArrayList<Order> list = new ArrayList<Order>();
		ResultSet rs = null;
		Connection conn = db.getConnection();
		String sql = "select * from shop_order where o_id=?, and o_state=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, o_id);
			pstmt.setInt(2, o_state);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getInt(8)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String type, int num) {
		// TODO Auto-generated method stub
		
	}
}
