package com.gokcek.springcommerce.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "customer")
public class Customer {
	
 
    @Id
    @GeneratedValue(
        strategy= GenerationType.AUTO,
        generator="native")
    @GenericGenerator(
        name = "native",
        strategy = "native")
	private Long id;
	private String fname;
	private String lname;
	private String city;
	private String email;

	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	
	public Customer(Long id, String fname, String lname, String city, String email) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.city = city;
		this.email = email;
	}
	public Customer () {
		
	}

}
