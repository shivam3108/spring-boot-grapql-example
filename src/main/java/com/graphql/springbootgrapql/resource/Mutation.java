package com.graphql.springbootgrapql.resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.springbootgrapql.model.Book;
import com.graphql.springbootgrapql.repository.BookRepository;

public class Mutation implements GraphQLMutationResolver{
	@Autowired
    BookRepository bookRepository;
	
	public Mutation(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	public Book addBooks(String isn, String title, String publisher, String authors, String publishedDate, String userName) {
		Book book = new Book(isn,title,publisher,authors,publishedDate,userName);
		bookRepository.save(book);
		return book;
	}

}
