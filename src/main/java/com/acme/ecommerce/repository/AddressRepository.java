package com.acme.ecommerce.repository;

import com.acme.ecommerce.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
