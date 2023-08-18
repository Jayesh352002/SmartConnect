package com.example.contactsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="contact")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long contactId ; 
	
	private String name ; 
	
	private String nickname ; 
	
	@Column(unique = true)
	private String email ; 
	
	private String mobile ; 
	
	private String work ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user ; 

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(long sId, String name, String nickname, String email, String mobile, String work, User user) {
		this.contactId = sId;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.mobile = mobile;
		this.work = work;
		this.user = user;
	}


	public Contact(String name, String nickname, String email, String mobile, String work, User user) {
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.mobile = mobile;
		this.work = work;
		this.user = user;
	}

	public Contact(String name, String nickname, String email, String mobile, String work) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.mobile = mobile;
		this.work = work;
	}

	public long getsId() {
		return contactId;
	}

	public void setsId(long sId) {
		this.contactId = sId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Contact [sId=" + contactId + ", name=" + name + ", nickname=" + nickname + ", email=" + email + ", mobile="
				+ mobile + ", work=" + work + ", user=" + user + "]";
	}
	
	
	
}
