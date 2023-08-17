package com.example.contactsystem.dto;

import com.example.contactsystem.entity.User;

public class ContactDTO {

	private long sID ; 
	private String userName ; 
	private String nickName ; 
	private String userEmail ; 
	private String userMobile ; 
	private String userWork ;
	private User user ; 
	
	public ContactDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactDTO(long sID, String userName, String nickName, String userEmail, String userMobile, String userWork,
			User user) {
		super();
		this.sID = sID;
		this.userName = userName;
		this.nickName = nickName;
		this.userEmail = userEmail;
		this.userMobile = userMobile;
		this.userWork = userWork;
		this.user = user;
	}

	public ContactDTO(String userName, String nickName, String userEmail, String userMobile, String userWork,
			User user) {
		super();
		this.userName = userName;
		this.nickName = nickName;
		this.userEmail = userEmail;
		this.userMobile = userMobile;
		this.userWork = userWork;
		this.user = user;
	}
	
	public long getsID() {
		return sID;
	}

	public void setsID(long sID) {
		this.sID = sID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserWork() {
		return userWork;
	}

	public void setUserWork(String userWork) {
		this.userWork = userWork;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ContactDTO [sID=" + sID + ", userName=" + userName + ", userEmail=" + userEmail + ", nickName="
				+ nickName + ", userMobile=" + userMobile + ", userWork=" + userWork + ", user=" + user + "]";
	}

	
	
	
}
