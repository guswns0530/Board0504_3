package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.JDBCUtil;
import vo.BoardVO;
import vo.UserVO;

public class BoardDAO {
	
	private final String INSERT = "insert into board_tbl values(board_seq.nextval, ?, ?, ?, SYSDATE, '0')";
	private final String SELECTALL = "select * from (select tbl.*, rownum as seq from (select b.*, u.user_nickname from board_tbl b join user_tbl u on (b.user_id = u.user_id) where b.is_del = '0' order by b.board_id desc) tbl) where seq >= ? and seq <= ?";
	private final String COUNTALL = "select count(*) cnt from board_tbl where is_del = '0'";
	private final String SELECTQUERYALL = "select * from (select tbl.*, rownum as seq from (select b.*, u.user_nickname from board_tbl b join user_tbl u on (b.user_id = u.user_id) where b.is_del = '0' and title like '%' || ? || '%' order by b.board_id desc) tbl) where seq >= ? and seq <= ?";
	private final String COUNTQUERYALL = "select count(*) cnt from board_tbl where is_del = '0' and title like '%' || ? || '%'";
	private final String SELECTID = "select * from board_tbl where board_id = ? and is_del = 0";
	private final String DELETE = "update BOARD_TBL set is_del = 1 where board_id = ?";
	private final String UPDATE = "update BOARD_TBL set title = ?, content = ? where board_id = ?";

	public int insert(BoardVO vo) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(INSERT);
			
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(conn, pstmt);
		}
		
		return result;
	}
	
	public ArrayList<BoardVO> selectAll(int page) {
		ArrayList<BoardVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int pageCnt = 6;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(SELECTALL);
			
			int start = (page - 1) * pageCnt;
			int end = ((page - 1) * pageCnt) + pageCnt;
			
			
			System.out.println(start + " " + end);
			pstmt.setInt(1, start + 1);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				
				String boardId = rs.getString("board_id");
				String userId = rs.getString("user_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date writeDate = rs.getDate("write_date");
				String password = "";
				String userName = "";
				String userNickname = rs.getString("user_nickname");
				UserVO userVO = new UserVO(userId, password, userName, userNickname);
				
				BoardVO vo = new BoardVO(boardId, userId, title, content, writeDate, userVO);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeAll(conn, pstmt, rs);
		}
		
		return list;
	}

	public int countAll() {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(COUNTALL);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(conn, pstmt, rs);
		}
		return result;
	}

	public ArrayList<BoardVO> selectAll(int page, String query) {
		ArrayList<BoardVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int pageCnt = 6;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(SELECTQUERYALL);
			
			int start = (page - 1) * pageCnt;
			int end = ((page - 1) * pageCnt) + pageCnt;
			
			pstmt.setString(1, query);
			pstmt.setInt(2, start + 1);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String boardId = rs.getString("board_id");
				String userId = rs.getString("user_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date writeDate = rs.getDate("write_date");
				String password = "";
				String userName = "";
				String userNickname = rs.getString("user_nickname");
				UserVO userVO = new UserVO(userId, password, userName, userNickname);
				
				BoardVO vo = new BoardVO(boardId, userId, title, content, writeDate, userVO);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeAll(conn, pstmt, rs);
		}
		
		return list;
	}

	public int countAll(String query) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(COUNTQUERYALL);
			
			pstmt.setString(1, query);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(conn, pstmt, rs);
		}
		return result;
	}

	public BoardVO selectId(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BoardVO vo = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(SELECTID);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String boardId = rs.getString("board_id");
				String userId = rs.getString("user_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date writeDate = rs.getDate("write_date");
				
				vo = new BoardVO(boardId, userId, title, content, writeDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(conn, pstmt, rs);
		}
		
		return vo;
	}

	public int delete(String boardId) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(DELETE);
			
			pstmt.setString(1, boardId);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(conn, pstmt);
		}
		
		return result;
	}

	public int update(String boardId, String title, String content) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(UPDATE);
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, boardId);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(conn, pstmt);
		}
		
		return result;
	}
}
