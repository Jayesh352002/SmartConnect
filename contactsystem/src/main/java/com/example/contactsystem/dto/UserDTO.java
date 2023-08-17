package com.example.contactsystem.dto;

public class UserDTO {
	
	private long userId ; 
	private String userName ; 
	private String username ; 
	private String userEmail ; 
	private String userPassword ;
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(long userId, String userName, String username2, String userEmail, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		username = username2;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public UserDTO(String userName, String username2, String userEmail, String userPassword) {
		super();
		this.userName = userName;
		username = username2;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", username=" + username + ", userEmail="
				+ userEmail + ", userPassword=" + userPassword + "]";
	} 
	
}
