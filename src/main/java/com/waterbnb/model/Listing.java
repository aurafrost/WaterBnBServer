package com.waterbnb.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "LISTING_TABLE")
public class Listing {
	
	@Id
	@GeneratedValue
    @Column(name = "listingId")
	private int listingId;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "poolSize")
	private String poolSize;
	
	@Column(name = "cost")
	private double cost;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	
	@OneToMany(mappedBy = "listing")
	private List<Review> review;
	
	public Listing() {
		
	}
	
	public Listing(String address, String description, String poolSize, double cost, User user,
			List<Review> review) {
		this.address = address;
		this.description = description;
		this.poolSize = poolSize;
		this.cost = cost;
		this.user = user;
		this.review = review;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getListingId() {
		return listingId;
	}

	public void setListingId(int listingId) {
		this.listingId = listingId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPoolSize() {
		return poolSize;
	}

	public void setPoolSize(String poolSize) {
		this.poolSize = poolSize;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Listing [listingId=" + listingId + ", address=" + address + ", poolSize=" + poolSize + ", cost=" + cost
				+ ", user=" + user + ", review=" + review + "]";
	}
	
	
	
}
