package vo;

import java.sql.Date;

public class UserVO {
	private String userId;
	private String password;
	private String userName;
	private String userNickname;
	private Date joinDate;
	
	public UserVO(String userId, String password, String userName, String userNickname, Date joinDate) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.userNickname = userNickname;
		this.joinDate = joinDate;
	}
	
	public UserVO(String userId, String password, String userName, String userNickname) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.userNickname = userNickname;
	}
	
	public UserVO(String userName, String userNickName) {
		this.userName = userName;
		this.userNickname = userNickName;
	}
	
	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public Date getJoinDate() {
		return joinDate;
	}
}
