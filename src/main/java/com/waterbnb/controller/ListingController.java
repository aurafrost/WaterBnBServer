package com.waterbnb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import com.waterbnb.dao.UserDao;
import com.waterbnb.model.Listing;
import com.waterbnb.model.User;

@RestController
@RequestMapping(path = "/listing")
@CrossOrigin(origins = "*")
public class ListingController {
	
	@Autowired
	ListingDao listingDao;
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Listing>> getListings(){
		List<Listing> list= (List<Listing>) listingDao.findAll();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(path = "/search/{address}",method = RequestMethod.GET)
	public ResponseEntity<List<Listing>> searchListings(@PathVariable String address){
		ArrayList<Listing> list = (ArrayList<Listing>) listingDao.findAll();
		ArrayList<Listing> temp = new ArrayList<>();
		for(Listing l:list) {
			String pattern="("+address+")";
			Pattern r = Pattern.compile(pattern);
			//searching address
			Matcher m = r.matcher(l.getAddress());
			if(m.find()) {
				temp.add(l);
			}
		}
		return new ResponseEntity<>(temp,HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{listingId}",method = RequestMethod.GET)
	public ResponseEntity<Listing> getListingById(@PathVariable int listingId){
		Listing listing=listingDao.findByListingId(listingId);
		return new ResponseEntity<>(listing,HttpStatus.OK);
	}
	
	@RequestMapping(path = "/user/{userId}",method = RequestMethod.GET)
	public ResponseEntity<List<Listing>> getListingsByUser(@PathVariable int userId){
		User user=userDao.findById(userId);
		List<Listing>list=listingDao.findByUser(user);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(path = "/create/{userId}",method = RequestMethod.POST)
	public ResponseEntity<Listing> createListing(@PathVariable int userId, @RequestBody Listing listing){
		User user=userDao.findById(userId);
		listing.setUser(user);
		Listing l=listingDao.save(listing);
		return new ResponseEntity<>(l,HttpStatus.OK);
	}
	
	@RequestMapping(path = "/update/{listingId}", method = RequestMethod.PUT)
	public ResponseEntity<Listing> updateListing(@PathVariable int listingId, @RequestBody Listing listing){
		Listing l=listingDao.findByListingId(listingId);
		l.setAddress(listing.getAddress());
		l.setCost(listing.getCost());
		l.setDescription(listing.getDescription());
		l.setPoolSize(listing.getPoolSize());
		l=listingDao.save(l);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}
}
