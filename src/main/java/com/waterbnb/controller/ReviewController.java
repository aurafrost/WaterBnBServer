package com.waterbnb.controller;

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

import com.waterbnb.dao.ReviewDao;
import com.waterbnb.model.Review;

@RestController
@RequestMapping(path = "/review")
@CrossOrigin(origins = "*")
public class ReviewController {
	
	@Autowired
	ReviewDao reviewDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Review>> getReviews(){
		List<Review> list=reviewDao.findAll();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{listingId}",method = RequestMethod.GET)
	public ResponseEntity<List<Review>> getReviewsById(@PathVariable int listingId){
		List<Review> list=reviewDao.findAllByListing(listingId);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Review> createReview(@RequestBody Review review){
		Review r=reviewDao.save(review);
		return new ResponseEntity<>(r,HttpStatus.OK);
	}
}
