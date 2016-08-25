package com.acme.ecommerce.repository;

import com.acme.ecommerce.domain.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

}
