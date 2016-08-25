package com.acme.ecommerce.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Purchase implements Serializable {  // AKA Shopping Cart
	
	private static final long serialVersionUID = -1544211294433636412L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "purchase_id")
	private Long purchaseId;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="purchase")
	private List <ProductPurchase> productPurchases = new ArrayList<ProductPurchase>(0);
	
	@Column(name = "credit_card_number", nullable=true)
	private String creditCardNumber;
	
	@Column(name = "credit_card_name")
	private String creditCardName;
	
	@Column(name = "credit_card_exp_month")
	private String creditCardExpMonth;
	
	@Column(name = "credit_card_exp_year")
	private String creditCardExpYear;
	
	@Column(name = "credit_card_cvc")
	private String creditCardCVC;
	
	@Column(name = "order_number")
	private String orderNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="shipping_address_id")
	private Address shippingAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="billing_address_id")
	private Address billingAddress;
	
	@Column(name = "billing_address_same")
	private Boolean billingAddressSame;

	public Long getId() {
		return purchaseId;
	}

	public void setId(Long id) {
		this.purchaseId = id;
	}

	public List<ProductPurchase> getProductPurchases() {
		return productPurchases;
	}

	public void setProductPurchases(List<ProductPurchase> productPurchases) {
		this.productPurchases = productPurchases;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getCreditCardName() {
		return creditCardName;
	}

	public void setCreditCardName(String creditCardName) {
		this.creditCardName = creditCardName;
	}

	public String getCreditCardExpMonth() {
		return creditCardExpMonth;
	}

	public void setCreditCardExpMonth(String creditCardExpMonth) {
		this.creditCardExpMonth = creditCardExpMonth;
	}

	public String getCreditCardExpYear() {
		return creditCardExpYear;
	}

	public void setCreditCardExpYear(String creditCardExpYear) {
		this.creditCardExpYear = creditCardExpYear;
	}

	public String getCreditCardCVC() {
		return creditCardCVC;
	}

	public void setCreditCardCVC(String creditCardCVC) {
		this.creditCardCVC = creditCardCVC;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Boolean isBillingAddressSame() {
		return billingAddressSame;
	}

	public void setBillingAddressSame(Boolean billingAddressSame) {
		this.billingAddressSame = billingAddressSame;
	}

	@Override
	public String toString() {
		return "Purchase [purchaseId=" + purchaseId + ", productPurchases=" + productPurchases + ", creditCardNumber="
				+ creditCardNumber + ", creditCardName=" + creditCardName + ", creditCardExpMonth=" + creditCardExpMonth
				+ ", creditCardExpYear=" + creditCardExpYear + ", creditCardCVC=" + creditCardCVC + ", orderNumber="
				+ orderNumber + ", shippingAddress=" + shippingAddress + ", billingAddress=" + billingAddress
				+ ", billingAddressSame=" + billingAddressSame + "]";
	}

}
