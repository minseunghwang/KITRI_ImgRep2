package img.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import model.Img;


public class DaoImpl implements Dao {
	private DBConnect db;
	
	public DaoImpl() {
		db = DBConnect.getInstance();
	}

	public ArrayList<Img> selectAll() {
		// TODO Auto-generated method stub
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Img> data = new ArrayList<Img>();
		String sql = "select * from img order by num";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				data.add(new Img(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4),rs.getDate(5), null));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	public void insert(Img img) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into img "
				+ "values(seq_img.nextval, ?, ?,?, sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1,img.getWriter());	
			pstmt.setString(2, img.getTitle());
			pstmt.setString(3, img.getPath());
			pstmt.executeUpdate();
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		try {
			// 자원 반환
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 }
}

