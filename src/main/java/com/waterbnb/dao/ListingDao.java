package com.waterbnb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.waterbnb.model.Listing;

@Repository
public interface ListingDao extends CrudRepository<Listing, Integer> {
	//read
	Listing findByListingId(int listingId);
}
