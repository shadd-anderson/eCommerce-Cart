package com.acme.ecommerce;

public class FlashMessage {
  private String message;
  private Status status;

  public FlashMessage(String message, Status status) {
    this.message = message;
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public Status getStatus() {
    return status;
  }

  public enum Status {
    SUCCESS, FAILURE
  }
}

