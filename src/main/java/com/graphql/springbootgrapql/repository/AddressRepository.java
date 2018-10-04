package com.graphql.springbootgrapql.repository;

import org.springframework.data.repository.CrudRepository;

import com.graphql.springbootgrapql.model.Address;

public interface AddressRepository extends CrudRepository<Address, String>{

}
