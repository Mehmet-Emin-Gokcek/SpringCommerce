package com.gokcek.springcommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String title;
	private String shipping;
	private String shippingCost;
	private String price;
	private String condition;
	private String image;

	public Product(String title, String shipping, String shippingCost, String price, String condition, String image) {
		super();
		this.title = title;
		this.shipping = shipping;
		this.shippingCost = shippingCost;
		this.price = price;
		this.condition = condition;
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public String getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(String shippingCost) {
		this.shippingCost = shippingCost;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Product() {

	}

}
