package com.graphql.springbootgrapql.resource;

import graphql.ExecutionResult;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graphql.springbootgrapql.service.GraphService;

@RequestMapping("/rest/graphql")
@RestController
public class BookResource {
	static Logger logger = Logger.getLogger(BookResource.class);

    @Autowired
    GraphService graphService;

    @PostMapping
    public ResponseEntity<Object> callGraphQLService(@RequestBody String query, @RequestHeader  Map<String, String> headerMap) {
    	
        ExecutionResult result = graphService.getGraphQL().execute(query);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
