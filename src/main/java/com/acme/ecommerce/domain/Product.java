package com.acme.ecommerce.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 8217376139341892205L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "desc", nullable = false)
	private String desc;
	
	@Column(name = "thumb_image_name", nullable = false)
	private String thumbImageName;
	
	@Column(name = "full_image_name", nullable = false)
	private String fullImageName;
	
	@Column(name = "price", nullable = false)
	private BigDecimal price;
	
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	
	public Long getId() {
		return productId;
	}
	
	public void setId(Long id) {
		this.productId = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getThumbImageName() {
		return thumbImageName;
	}
	
	public void setThumbImageName(String thumbImageName) {
		this.thumbImageName = thumbImageName;
	}
	
	public String getFullImageName() {
		return fullImageName;
	}
	
	public void setFullImageName(String fullImageName) {
		this.fullImageName = fullImageName;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + productId + ", name=" + name + ", desc=" + desc + ", thumbImageName=" + thumbImageName
				+ ", fullImageName=" + fullImageName + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
}
