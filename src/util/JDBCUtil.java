package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			String url = "jdbc:oracle:thin:@202.86.12.198:1521:orcl";
			String user = "EXPORTTESTUSER";
			String password = "EXPORTTESTUSER";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void closeAll(Connection conn, PreparedStatement pstmt) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
			if(pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			closeAll(conn, pstmt);
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
