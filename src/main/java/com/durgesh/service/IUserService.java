package com.durgesh.service;

import java.util.List;

import com.durgesh.model.User;

public interface IUserService {
	
	public List<User> getAllUsers() ;

	public User getUserForId(int id);

	public User createUser(User user);

	public User updateUser(User user) ;

	public void deleteUser(Integer id) ;

}
