package rep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import model.Rep;

public class DaoImpl implements Dao {
	private Connection conn;
	private PreparedStatement pstmt = null;

	public DaoImpl() {
		DBConnect dbconn = DBConnect.getInstance();
		conn = dbconn.getConnection();
	}
	public void insert(Rep rep) {
		// TODO Auto-generated method stub
		String sql = "insert into reps "
				+ "values(seq_reps.nextval, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rep.getWriter());
			pstmt.setString(2, rep.getContent());
			pstmt.setInt(3, rep.getImg_num());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Rep> selectByImg_num(int img_num) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		ArrayList<Rep> reps = new ArrayList<Rep>();
		String sql = "select * from reps where img_num=? order by num";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, img_num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				reps.add(new Rep(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4)));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reps;
	}

}
