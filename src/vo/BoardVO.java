package vo;

import java.sql.Date;

public class BoardVO {
	private String boardId;
	private String userId;
	private String title;
	private String content;
	private Date writeDate;
	private UserVO userVO;
	
	public BoardVO(String boardId, String userId, String title, String content, Date writeDate) {
		super();
		this.boardId = boardId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
	}
	public BoardVO(String boardId, String userId, String title, String content, Date writeDate, UserVO userVO) {
		super();
		this.boardId = boardId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
		this.userVO = userVO;
	}

	public BoardVO(String userId, String title, String content) {
		super();
		this.userId = userId;
		this.title = title;
		this.content = content;
	}


	public String getBoardId() {
		return boardId;
	}

	public String getUserId() {
		return userId;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Date getWriteDate() {
		return writeDate;
	}
	
	public UserVO getUserVO() {
		return userVO;
	}
}
