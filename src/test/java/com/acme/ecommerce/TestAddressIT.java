package com.acme.ecommerce;

import com.acme.ecommerce.config.PersistenceConfig;
import com.acme.ecommerce.domain.Address;
import com.acme.ecommerce.repository.AddressRepository;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import static org.assertj.core.api.Assertions.assertThat;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("/it-products.xml")
public class TestAddressIT {
 
    @Autowired
    private AddressRepository repository;
    
    @Test
    public void findAll_ShouldReturnThreeAddressEntry() {
        Iterable<Address> searchResults = repository.findAll();
        assertThat(searchResults).hasSize(3);
    }
     
    @Test
    public void findOne_ShouldReturnSecondAddressEntry() {
    	Address searchResults = repository.findOne(new Long(3));
 
        assertThat(searchResults.getStreetAddress().equalsIgnoreCase("Street Address 3"));
    }
    
    @Test
    @ExpectedDatabase(value="/save-address.xml", assertionMode=DatabaseAssertionMode.NON_STRICT)
    public void saveOne_ShouldAddAfterInitialRows() {
    	Address newAddress = new Address();
    	
    	newAddress.setFirstName("First");
    	newAddress.setLastName("Last");
    	newAddress.setCity("City");
    	newAddress.setCountry("Country");
    	newAddress.setEmail("email@address.com");
    	newAddress.setPhoneNumber("1234567890");
    	newAddress.setState("AA");
    	newAddress.setStreetAddress("123 Street Address");
    	newAddress.setZipCode("12345");
    	
    	Address savedAddress = repository.save(newAddress);
    	
    	assertThat(savedAddress.getId()).isNotNull();
    }
}
