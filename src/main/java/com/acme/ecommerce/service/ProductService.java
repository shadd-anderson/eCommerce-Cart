package com.acme.ecommerce.service;

import com.acme.ecommerce.domain.Product;
import com.acme.ecommerce.domain.ProductPurchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

	public Iterable<Product> findAll();
	
	public Page<Product> findAll(Pageable pageable);
	
	public Product findById(Long id);

	void checkForAvailability(Product product, Integer quantity);
}
