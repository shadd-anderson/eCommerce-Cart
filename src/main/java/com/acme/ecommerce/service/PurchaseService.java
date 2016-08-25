package com.acme.ecommerce.service;

import com.acme.ecommerce.domain.Purchase;

public interface PurchaseService {
	public Iterable<Purchase> findAll();
	
	public Purchase findById(Long id);
	
	public Purchase save(Purchase purchase);
}
