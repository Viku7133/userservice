package com.neosave.userservice.userservice.interceptor;

import com.neosave.userservice.userservice.constants.ErrorMessage;
import com.neosave.userservice.userservice.exception.CustomException;
import com.neosave.userservice.userservice.response.BaseErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionInterceptor {

  @ExceptionHandler(CustomException.class)
  public final ResponseEntity<BaseErrorResponse> handleCustomException(CustomException ex) {
    return new ResponseEntity<>(new BaseErrorResponse(false, ex.errorMessage),
        HttpStatus.valueOf(ex.errorCode));
  }

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<BaseErrorResponse> handleAllException(Exception ex) {
    return new ResponseEntity<>(new BaseErrorResponse(false, ErrorMessage.INTERNAL_SERVER_ERROR),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

}