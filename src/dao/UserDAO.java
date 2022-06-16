package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JDBCUtil;
import vo.UserVO;

public class UserDAO {
	
	public final String INSERT = "insert into user_tbl values (?, ?, ?, ?, SYSDATE, '0')";
	public final String SELECT = "select * from user_tbl where user_id = ? and pwd = ?";
	public final String SELECTID = "select * from user_tbl where user_id = ?";
	
	public int insert(UserVO vo) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(INSERT);
			
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getUserName());
			pstmt.setString(4, vo.getUserNickname());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(conn, pstmt);
		}
		
		return result;
	}
	
	public UserVO select(String userId, String pwd) {
		UserVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(SELECT);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new UserVO(rs.getString("user_id"), rs.getString("pwd"), rs.getString("user_name"), rs.getString("user_nickname"), rs.getDate("join_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeAll(conn, pstmt, rs);
		}
		
		return vo;
	}

	public UserVO select(String userId) {
		UserVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(SELECTID);
			
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new UserVO(rs.getString("user_id"), rs.getString("pwd"), rs.getString("user_name"), rs.getString("user_nickname"), rs.getDate("join_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeAll(conn, pstmt, rs);
		}
		
		return vo;
	}
}
