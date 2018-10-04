package com.graphql.springbootgrapql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "address")
@Entity
public class Address {
	@Id
	@Column(name = "id")
    private String id;
    @Column(name = "user_name")
    private String userName;
	@Column(name = "house")
    private String house;
	@Column(name = "street")
    private String street;
	@Column(name = "city")
    private String city;
	public Address() {
		super();
	}
	public Address(String userName, String house, String street, String city, String id) {
		super();
		this.userName = userName;
		this.house = house;
		this.street = street;
		this.city = city;
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
