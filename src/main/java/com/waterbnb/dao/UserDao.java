package com.waterbnb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.waterbnb.model.User;

@Repository
public interface UserDao extends CrudRepository<User,Integer>{
	//read
	User findById(int userId);
	User findByEmail(String email);
}
