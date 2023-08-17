package com.example.contactsystem.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId ;
	
	@Column(name = "name")
	private String userName ; 
	
	@Column(name = "username")
	private String username ;
	
	@Column(name = "user_email",unique=true)
	private String email ;
	
	@Column(name = "password")
	private String password ;
	
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "user")
	private List<Contact> contacts = new ArrayList<Contact>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long id, String name, String username, String email, String password) {
		super();
		this.userId = id;
		this.userName = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public User(String name, String username, String email, String password) {
		super();
		this.userName = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return userId;
	}

	public void setId(long id) {
		this.userId = id;
	}

	public String getName() {
		return userName;
	}

	public void setName(String name) {
		this.userName = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "User [id=" + userId + ", name=" + userName + ", username=" + username + ", email=" + email + ", password="
				+ password + "]";
	} 
	
	

}
