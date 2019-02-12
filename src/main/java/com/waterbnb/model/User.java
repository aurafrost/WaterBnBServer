package com.waterbnb.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_TABLE")
public class User {
	@Id
    @GeneratedValue
    @Column(name = "userId")
	private int userId;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "fName")
    private String fName;
	
    @Column(name = "lName")
    private String lName;
    
	@Column(name = "email", unique = true)
    private String email;
	
	@Column(name = "password")
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy = "user")
    private List<Listing>listing;
	
	public User() { }

	public User(String type, String fName, String lName, String email, String password, List<Listing> listing) {
		this.type = type;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.listing = listing;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Listing> getListing() {
		return listing;
	}

	public void setListing(List<Listing> listing) {
		this.listing = listing;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", type=" + type + ", fName=" + fName + ", lName=" + lName + ", email="
				+ email + ", password=" + password + ", listing=" + listing + "]";
	}

	
	
	
}
