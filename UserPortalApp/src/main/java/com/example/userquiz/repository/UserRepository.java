package com.example.userquiz.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.userquiz.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findByNameAndPassword(String name, String password);

}
