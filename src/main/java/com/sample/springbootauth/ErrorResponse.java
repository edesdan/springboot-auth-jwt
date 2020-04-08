package com.sample.springbootauth;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class ErrorResponse {

  public final String message;

  @JsonCreator
  ErrorResponse(@JsonProperty("message") String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "ErrorResponse{" +
      "message='" + message + '\'' +
      '}';
  }
}
