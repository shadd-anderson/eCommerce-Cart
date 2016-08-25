package com.acme.ecommerce.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="product_purchase")
public class ProductPurchase implements Serializable {

	private static final long serialVersionUID = -3665850872024911072L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "product_purchase_id")
	private Long productPurchaseId;
	
	@ManyToOne
	@JoinColumn(name="purchase_id")
	private Purchase purchase;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	public Long getProductPurchaseId() {
		return productPurchaseId;
	}

	public void setProductPurchaseId(Long productPurchaseId) {
		this.productPurchaseId = productPurchaseId;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductPurchase [productPurchaseId=" + productPurchaseId + ", purchase=" + purchase + ", product="
				+ product + ", quantity=" + quantity + "]";
	}

}
