package com.acme.ecommerce.repository;

import com.acme.ecommerce.domain.ProductPurchase;
import org.springframework.data.repository.CrudRepository;

public interface ProductPurchaseRepository extends CrudRepository<ProductPurchase, Long> {

}
