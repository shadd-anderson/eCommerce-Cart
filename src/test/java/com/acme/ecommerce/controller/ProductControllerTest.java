package com.acme.ecommerce.controller;

import com.acme.ecommerce.Application;
import com.acme.ecommerce.domain.Product;
import com.acme.ecommerce.domain.ProductNotFoundException;
import com.acme.ecommerce.domain.ProductPurchase;
import com.acme.ecommerce.domain.Purchase;
import com.acme.ecommerce.domain.ShoppingCart;
import com.acme.ecommerce.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SuppressWarnings("unchecked")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ProductControllerTest {

	final String BASE_URL = "http://localhost:8080/";
	
	 static {
		 System.setProperty("properties.home", "/Users/shadd/Techdegree Projects/E-Commerce Cart/techdegree-javaweb-ecommerce-master");
	 }

	@Mock
	private MockHttpSession session;

	@Mock
	private ProductService productService;
	@InjectMocks
	private ProductController productController;
	@Mock
	private ShoppingCart sCart;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
		productController.imagePath = "src/test/resources/"; // properties hack because @Value wouldn't resolve
	}

	@Test
	public void getIndex() throws Exception {
		
		Product product = productBuilder();
		
		Product product2 = productBuilder();
		product2.setId(2L);
		
		List<Product> pList = new ArrayList<Product>();
		pList.add(product);
		pList.add(product2);
		
		Page<Product> products = new PageImpl<Product>(pList);
		
		when(productService.findAll(new PageRequest(1, 2))).thenReturn(products);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/product/"))
			.andExpect(status().isOk())
			.andExpect(view().name("index"));
	}

	@Test
	public void getProductDetail() throws Exception {
		Product product = productBuilder();
		product.setFullImageName("fork.jpg");
		
		when(productService.findById(1L)).thenReturn(product);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/product/detail/1"))
			.andExpect(status().isOk())
			.andExpect(view().name("product_detail"));
	}
	
	@Test
	public void getProductDetailInvalidId() throws Exception {
		when(productService.findById(1L)).thenReturn(null);
		mockMvc.perform(MockMvcRequestBuilders.get("/product/detail/1"))
			.andExpect(status().is3xxRedirection())
		    .andExpect(redirectedUrl("/error"));
	}

	@Test
	public void getProductImage() throws Exception {
		
		Product product = productBuilder();
		product.setFullImageName("fork.jpg");
			
		when(productService.findById(1L)).thenReturn(product);
		mockMvc.perform(MockMvcRequestBuilders.get("/product/1/image")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType("image/jpeg"));
	}
	
	@Test(expected = FileNotFoundException.class)
	public void getProductImageFail() throws Exception {
		
		Product product = productBuilder();
		product.setFullImageName("a.jpg");
			
		when(productService.findById(1L)).thenReturn(product);
		mockMvc.perform(MockMvcRequestBuilders.get("/product/1/image")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType("image/jpeg"));
	}

	@Test
	public void cartIsShownWithSubtotal() throws Exception {
		Product product = productBuilder();
		Purchase purchase = purchaseBuilder(product);
		when(sCart.getPurchase()).thenReturn(purchase);


		mockMvc.perform(MockMvcRequestBuilders.get("/product/"))
				.andExpect(model().attributeExists("subTotal"));
	}

	@Test
	public void notFoundExceptionResultsInNotFoundError() throws Exception {
		when(productService.findById(18L)).thenThrow(ProductNotFoundException.class);

		mockMvc.perform(MockMvcRequestBuilders.get("/product/detail/18"))
				.andExpect(status().is(404));
	}

	@Test
	public void addingProductAddsFlashMessage() throws Exception {

	}

	private Product productBuilder() {
		Product product = new Product();
		product.setId(1L);
		product.setDesc("TestDesc");
		product.setName("TestName");
		product.setPrice(new BigDecimal(1.99));
		product.setQuantity(3);
		product.setFullImageName("imagename");
		product.setThumbImageName("imagename");
		return product;
	}

	private Purchase purchaseBuilder(Product product) {
		ProductPurchase pp = new ProductPurchase();
		pp.setProductPurchaseId(1L);
		pp.setQuantity(1);
		pp.setProduct(product);
		List<ProductPurchase> ppList = new ArrayList<ProductPurchase>();
		ppList.add(pp);

		Purchase purchase = new Purchase();
		purchase.setId(1L);
		purchase.setProductPurchases(ppList);
		return purchase;
	}
}