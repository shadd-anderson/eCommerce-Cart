package com.acme.ecommerce.domain;

public class OrderQuantityExceedsStockException extends RuntimeException {
  public OrderQuantityExceedsStockException(Product product) {
    super("Sorry, we only have " + product.getQuantity() + " " + product.getName()
        + "s in stock. :(");
  }
}
