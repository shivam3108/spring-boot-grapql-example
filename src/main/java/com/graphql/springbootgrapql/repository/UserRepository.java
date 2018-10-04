package com.graphql.springbootgrapql.repository;

import org.springframework.data.repository.CrudRepository;

import com.graphql.springbootgrapql.model.User;

public interface UserRepository extends CrudRepository<User, String>{

}
