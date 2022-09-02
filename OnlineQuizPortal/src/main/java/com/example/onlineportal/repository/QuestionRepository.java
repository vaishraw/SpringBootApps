package com.example.onlineportal.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.onlineportal.entity.Questions;

public interface QuestionRepository extends CrudRepository<Questions, Integer> {

}
