package com.acme.ecommerce;

import com.acme.ecommerce.config.PersistenceConfig;
import com.acme.ecommerce.domain.Purchase;
import com.acme.ecommerce.repository.PurchaseRepository;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("/it-products.xml")
public class TestPurchaseIT {
 
    @Autowired
    private PurchaseRepository repository;
    
    @Test
    public void findAll_ShouldReturnThreePurchaseEntry() {
        Iterable<Purchase> searchResults = repository.findAll();
        assertThat(searchResults).hasSize(3);
    }
     
    @Test
    public void findOne_ShouldReturnSecondPurchaseEntry() {
    	Purchase searchResult = repository.findOne(new Long(2));
 
        assertThat(searchResult.getCreditCardNumber().equalsIgnoreCase("1234567890123456"));

        try {
        	searchResult.getProductPurchases().size();
        	fail("LazyInitialization expected because findOne doesn't walk the persistence graph");
        } catch (LazyInitializationException l) {
        	assertThat(l).hasMessageEndingWith("domain.Purchase.productPurchases, could not initialize proxy - no Session");
        }
    }
    
    @Test
    @ExpectedDatabase(value="/save-purchase.xml", assertionMode=DatabaseAssertionMode.NON_STRICT)
    public void saveOne_ShouldAddAfterInitialRows() {
    	Purchase newPurchase = new Purchase();
    	    	
    	newPurchase.setCreditCardNumber("9876543210654321");
    	newPurchase.setCreditCardName("MC");
    	newPurchase.setCreditCardExpMonth("3");
    	newPurchase.setCreditCardExpYear("2018");
    	newPurchase.setCreditCardCVC("134");
    	newPurchase.setOrderNumber("654321");
    	newPurchase.setBillingAddressSame(true);
    	
    	Purchase savedPurchase = repository.save(newPurchase);
    	
    	assertThat(savedPurchase.getId()).isNotNull();
    }
}
