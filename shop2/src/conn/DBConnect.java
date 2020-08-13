package conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static DBConnect db = new DBConnect();
	public Connection conn = null;
	
	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	private DBConnect() {
		
	}
	
	public static DBConnect getInstance() {
		return db;
	}
	
	public Connection getConnection() {
		
		try {
			Class.forName(jdbc_driver);
			
			conn = DriverManager.getConnection(jdbc_url, "c##ora_user", "yeo");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}
	
	
}
