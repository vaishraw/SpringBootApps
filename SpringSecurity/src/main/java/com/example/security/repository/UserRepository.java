package com.example.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.security.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByName(String name);
}