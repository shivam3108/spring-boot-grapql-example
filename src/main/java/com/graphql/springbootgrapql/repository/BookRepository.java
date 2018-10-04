package com.graphql.springbootgrapql.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.graphql.springbootgrapql.model.Book;

public interface BookRepository extends CrudRepository<Book, String> {
	@Query(value = "select * from book", nativeQuery = true)
	public List<Book> findAllBooks();
}
