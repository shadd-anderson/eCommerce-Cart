package com.acme.ecommerce;

import com.acme.ecommerce.config.PersistenceConfig;
import com.acme.ecommerce.domain.Product;
import com.acme.ecommerce.repository.ProductRepository;
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

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("/it-products.xml")
public class TestProductIT {
 
    @Autowired
    private ProductRepository repository;
     
    @Test
    public void findAll_ShouldReturnFourProductEntry() {
        Iterable<Product> searchResults = repository.findAll();
        assertThat(searchResults).hasSize(4);
    }
     
    @Test
    public void findOne_ShouldReturnSecondProductEntry() {
        Product searchResults = repository.findOne(new Long(2));
 
        assertThat(searchResults.getName().equalsIgnoreCase("Item 2"));
    }
    
    @Test
    @ExpectedDatabase(value="/save-product.xml", assertionMode=DatabaseAssertionMode.NON_STRICT)
    public void saveOne_ShouldAddAfterInitialRows() {
    	Product newProduct = new Product();
    	
    	newProduct.setName("Salt Shaker");
    	newProduct.setPrice(new BigDecimal(323.89));
    	newProduct.setQuantity(3);
    	newProduct.setDesc("Not just for pepper anymore!");
    	newProduct.setFullImageName("saltshaker.jpg");
    	newProduct.setThumbImageName("sm_saltshaker.jpg");
    	
    	Product savedProduct = repository.save(newProduct);
    	
    	assertThat(savedProduct.getId()).isNotNull();
    }
}