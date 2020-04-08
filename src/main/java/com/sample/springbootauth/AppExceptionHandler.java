package com.sample.springbootauth;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class AppExceptionHandler {

  @ExceptionHandler
  @ResponseStatus(code = HttpStatus.FORBIDDEN)
  public ErrorResponse bcdApiHttpMultiStatusException(AccessDeniedException ex) {
    return new ErrorResponse("Access denied.");
  }
}
