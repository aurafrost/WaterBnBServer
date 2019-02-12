package com.waterbnb.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "REVIEW_TABLE")
public class Review {
	@Id
	@GeneratedValue
    @Column(name = "reviewId")
	private int reviewId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "rating")
	private int rating;
	
	@Column(name = "review")
	private String review;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "listingId")
	private Listing listing;
	
	public Review() {
		
	}

	public Review(String name, int rating, Listing listing, String review) {
		this.name = name;
		this.rating = rating;
		this.listing = listing;
		this.review = review;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Listing getListing() {
		return listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", name=" + name + ", rating=" + rating + ", listing=" + listing + "]";
	}
	
	
}
