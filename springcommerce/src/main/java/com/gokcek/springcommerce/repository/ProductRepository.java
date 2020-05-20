package com.gokcek.springcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gokcek.springcommerce.model.Product;

public interface ProductRepository  extends JpaRepository<Product, Long> {

}
