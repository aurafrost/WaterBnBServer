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

import com.waterbnb.dao.ListingDao;
import com.waterbnb.model.Listing;
import com.waterbnb.model.User;

@RestController
@RequestMapping(path = "/listing")
@CrossOrigin(origins = "*")
public class ListingController {
	
	@Autowired
	ListingDao listingDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Listing>> getListings(){
		List<Listing> list= (List<Listing>) listingDao.findAll();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
//	@RequestMapping(path = "/{address}",method = RequestMethod.GET)
//	public ResponseEntity<List<Listing>> searchListings(@PathVariable String address){
//		List<Listing> list= listingDao.searchListings(address);
//		return new ResponseEntity<>(list,HttpStatus.OK);
//	}
	
	@RequestMapping(path = "/{listingId}",method = RequestMethod.GET)
	public ResponseEntity<Listing> getListingById(@PathVariable int listingId){
		Listing listing=listingDao.findByListingId(listingId);
		return new ResponseEntity<>(listing,HttpStatus.OK);
	}
	
	@RequestMapping(path = "/user/",method = RequestMethod.GET)
	public ResponseEntity<List<Listing>> getListingsByUser(@RequestBody User user){
		List<Listing>list=listingDao.findByUser(user);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Listing> createListing(@RequestBody Listing listing){
		Listing l=listingDao.save(listing);
		return new ResponseEntity<>(l,HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{listingId}", method = RequestMethod.PUT)
	public ResponseEntity<Listing> updateListing(@PathVariable int listingId, @RequestBody Listing listing){
		Listing l=listingDao.findByListingId(listingId);
		//do updates here
		Listing l2=listingDao.save(l);
		return new ResponseEntity<>(l2, HttpStatus.OK);
	}
}
