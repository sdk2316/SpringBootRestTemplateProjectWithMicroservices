package com.durgesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.durgesh.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	

}
