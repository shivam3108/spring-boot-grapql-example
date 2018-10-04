package com.graphql.springbootgrapql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "book")
@Entity

public class Book {

	@Id
    @Column(name = "isn")
	@JsonIgnore
    public String isn;
    @Column(name = "title")
    @JsonIgnore
    public String title;
    @Column(name = "publisher")
    @JsonIgnore
    public String publisher;
    @Column(name = "authors")
    @JsonIgnore
    public String authors;
    @Column(name = "published_date")
    @JsonIgnore
    public String publishedDate;
    @Column(name = "user_name")
    @JsonIgnore
    public String userName;

    public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Book(String isn, String title, String publisher, String authors, String publishedDate, String userName) {
		super();
		this.isn = isn;
		this.title = title;
		this.publisher = publisher;
		this.authors = authors;
		this.publishedDate = publishedDate;
		this.userName = userName;
	}
	public String getIsn() {
		return isn;
	}
	public void setIsn(String isn) {
		this.isn = isn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public Book() {
		super();
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
}
