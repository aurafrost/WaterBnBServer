package com.waterbnb.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.waterbnb.model.Review;

@Repository
public interface ReviewDao extends CrudRepository<Review,Integer>{
	//read
	List<Review> findAll();
	List<Review> findAllByListing(int listingId);
}
