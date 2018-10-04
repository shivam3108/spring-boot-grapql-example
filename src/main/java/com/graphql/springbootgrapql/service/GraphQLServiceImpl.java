package com.graphql.springbootgrapql.service;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.graphql.springbootgrapql.repository.AddressRepository;
import com.graphql.springbootgrapql.repository.BookRepository;
import com.graphql.springbootgrapql.repository.UserRepository;
import com.graphql.springbootgrapql.resource.Mutation;
import com.graphql.springbootgrapql.resource.Query;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import com.coxautodev.graphql.tools.SchemaParser;

@Service
public class GraphQLServiceImpl implements GraphService{

	static Logger logger = Logger.getLogger(GraphQLServiceImpl.class);
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserRepository userRepository;

    @Value("classpath:books.graphql")
    Resource resource;

    private GraphQL graphQL;

    @PostConstruct
    private void loadSchema(){    	
        GraphQLSchema schema = buildSchema(bookRepository, addressRepository, userRepository);
        graphQL = GraphQL.newGraphQL(schema).build();
    }
    private GraphQLSchema buildSchema(BookRepository bookRepository, AddressRepository addressRepository, UserRepository  userRepository) {
    	return SchemaParser.newParser()
    	        .file("books.graphql")
    	        .resolvers(new Mutation(bookRepository), new Query(bookRepository, addressRepository, userRepository))
    	        .build()
    	        .makeExecutableSchema();
	}

	@Override
	public GraphQL getGraphQL() {
		return graphQL;
	}

}
