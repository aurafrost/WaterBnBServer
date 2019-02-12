package com.waterbnb.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.waterbnb.model.Listing;
import com.waterbnb.model.User;

@Repository
public interface ListingDao extends CrudRepository<Listing, Integer> {
	//read
	Listing findByListingId(int listingId);

	List<Listing> findByUser(User user);
}
