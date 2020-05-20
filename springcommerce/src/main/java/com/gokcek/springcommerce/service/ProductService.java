package com.gokcek.springcommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gokcek.springcommerce.model.Product;
import com.gokcek.springcommerce.repository.ProductRepository;;

@Service
public class ProductService {

    @Autowired
    private ProductRepository ProductRepository;

    public List<Product> findAll() {

        return ProductRepository.findAll();
    }
    
    public Optional<Product> findById(Long ProductId) {
    	
    	
    	return ProductRepository.findById(ProductId);
    }

    public Long count() {

        return ProductRepository.count();
    }

    public void deleteById(Long ProductId) {

        ProductRepository.deleteById(ProductId);
    }
    
    public void saveProduct(Product Product) {
    	
    	 ProductRepository.save(Product);
    }
    
    public void updateProduct(Product Product) {
    	    	
    	
    	Product st = ProductRepository.findById(Product.getId()).orElse(null);
    	
    	st.setTitle(Product.getTitle());
    	st.setShipping(Product.getShipping());
    	st.setShippingCost(Product.getShippingCost());
    	st.setPrice(Product.getPrice());
    	st.setCondition(Product.getCondition());
    	st.setImage(Product.getImage());
 	
    	ProductRepository.save(st);
    	
    }
    
    
}
