package com.waterbnb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.waterbnb.dao.ListingDao;
import com.waterbnb.dao.ReviewDao;
import com.waterbnb.model.Listing;
import com.waterbnb.model.Review;

@RestController
@RequestMapping(path = "/review")
@CrossOrigin(origins = "*")
public class ReviewController {
	
	@Autowired
	ReviewDao reviewDao;
	
	@Autowired
	ListingDao listingDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Review>> getReviews(){
		List<Review> list=reviewDao.findAll();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{listingId}",method = RequestMethod.GET)
	public ResponseEntity<List<Review>> getReviewsById(@PathVariable int listingId){
		ArrayList<Review> list=(ArrayList<Review>)reviewDao.findAll();
		ArrayList<Review> temp=new ArrayList<>();
		for(Review r:list) {
			Listing l=r.getListing();
			if(l.getListingId()==listingId) {
				temp.add(r);
			}
		}
		return new ResponseEntity<>(temp,HttpStatus.OK);
	}
	
	@RequestMapping(path = "/create/{listingId}", method = RequestMethod.POST)
	public ResponseEntity<Review> createReview(@PathVariable int listingId,@RequestBody Review review){
		Listing l=listingDao.findByListingId(listingId);
		review.setListing(l);
		Review r=reviewDao.save(review);
		return new ResponseEntity<>(r,HttpStatus.OK);
	}
}
