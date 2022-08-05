package com.durgesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durgesh.model.User;
import com.durgesh.repository.UserRepository;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private UserRepository userDao;

	public List<User> getAllUsers() {
		List<User> userList = userDao.findAll();
		return userList;
	}

	public User getUserForId(int id) {
		User user = userDao.findById(id).get();
		return user;
	}

	public User createUser(User user) {
		User userResponse = userDao.save(user);
		return userResponse;
	}

	public User updateUser(User user) {
		User userResponse =userDao.save(user);
		return userResponse;
	}

	public void deleteUser(Integer id) {
	userDao.deleteById(id);
		
	}

}
