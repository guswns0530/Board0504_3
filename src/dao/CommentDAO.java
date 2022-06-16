package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.JDBCUtil;
import vo.BoardVO;
import vo.CommentVO;

public class CommentDAO {
	private final String INSERT = "insert into COMMENT_TBL values(content_seq.nextval, ?, ?, ?, SYSDATE, 0)";
	private final String SELECTBOARDIDALL = "select * from comment_tbl where is_del = 0 and board_id = ? order by comment_id desc";

	public ArrayList<CommentVO> selectAll(String id) {
		ArrayList<CommentVO> list = new ArrayList<>();

		UserDAO userDAO = new UserDAO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(SELECTBOARDIDALL);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String commentId = rs.getString("comment_id");
				String boardId = rs.getString("board_id");
				String userId = rs.getString("user_id");
				String content = rs.getString("content");
				Date writeDate = rs.getDate("write_date");
				
				CommentVO commentVO = new CommentVO(commentId, boardId, userId, content, writeDate);
				
				commentVO.setUserVO(userDAO.select(userId));
				
				list.add(commentVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(conn, pstmt, rs);
		}
		
		return list;
	}

	public int insert(String boardId, String userId, String content) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(INSERT);
			
			pstmt.setString(1, boardId);
			pstmt.setString(2, userId);
			pstmt.setString(3, content);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(conn, pstmt);
		}
		
		return result;
	}
}
