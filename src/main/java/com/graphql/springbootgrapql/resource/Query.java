package com.graphql.springbootgrapql.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.springbootgrapql.exception.ResourceNotFoundException;
import com.graphql.springbootgrapql.model.Address;
import com.graphql.springbootgrapql.model.Book;
import com.graphql.springbootgrapql.model.User;
import com.graphql.springbootgrapql.repository.AddressRepository;
import com.graphql.springbootgrapql.repository.BookRepository;
import com.graphql.springbootgrapql.repository.UserRepository;

public class Query implements GraphQLQueryResolver {
	static Logger logger = Logger.getLogger(Query.class);
	@Autowired
    BookRepository bookRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserRepository userRepository;
    
    public Query(BookRepository bookRepository, AddressRepository addressRepository, UserRepository userRepository) {
    	this.bookRepository = bookRepository;
    	this.addressRepository = addressRepository;
    	this.userRepository = userRepository;
    }
    
    public Book book(String id) {
    	return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "isn", id));
    }
    
    public User user(String userName) {
    	RestTemplate restTemplate = new RestTemplate();
    	Map<String, String> map = new HashMap<>();
    	map.put("userName", userName);
    	logger.debug("Before calling "+userName);
    	ResponseEntity <User> response = restTemplate.getForEntity("http://localhost:8085/userDetails/getUser/{userName}",User.class, map);
    	User user = response.getBody();
    	logger.debug("Response is "+response);
    	return user;
    }
    
    public Address address(String id) {
    	return addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address", "id", id));
    }
    
    public List<Book> allBooks(){
		return bookRepository.findAllBooks();
	}
	
}