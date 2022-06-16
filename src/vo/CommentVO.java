package vo;

import java.sql.Date;

public class CommentVO {
	private String commentId;
	private String boardId;
	private String userId;
	private String content;
	private Date writeDate;
	
	private UserVO userVO;
	
	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public CommentVO(String commentId, String boardId, String userId, String content, Date writeDate) {
		super();
		this.commentId = commentId;
		this.boardId = boardId;
		this.userId = userId;
		this.content = content;
		this.writeDate = writeDate;
	}
	
	public String getCommentId() {
		return commentId;
	}
	public String getBoardId() {
		return boardId;
	}
	public String getUserId() {
		return userId;
	}
	public String getContent() {
		return content;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	
	
}
