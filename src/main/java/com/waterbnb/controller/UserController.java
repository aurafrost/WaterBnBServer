package com.waterbnb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.waterbnb.dao.UserDao;
import com.waterbnb.model.User;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user){
		User u=userDao.save(user);
		return new ResponseEntity<>(u,HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{userId}",method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable int userId){
		User u=userDao.findById(userId);
		return new ResponseEntity<>(u,HttpStatus.OK);
	}
	
	@RequestMapping(path = "/email/{email}",method = RequestMethod.GET)
	public ResponseEntity<User> getUserByEmail(@PathVariable String email){
		User u=userDao.findByEmail(email);
		return new ResponseEntity<>(u,HttpStatus.OK);
	}
}
