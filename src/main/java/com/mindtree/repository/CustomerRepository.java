package com.mindtree.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mindtree.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer,String>{

	public Optional<List<Customer>> findByLastName(String lastName); 

}
