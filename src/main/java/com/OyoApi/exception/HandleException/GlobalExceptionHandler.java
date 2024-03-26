package com.OyoApi.exception.HandleException;

import com.OyoApi.exception.BookingNotFoundException;
import com.OyoApi.exception.EntityNotFoundException;
import com.OyoApi.exception.ResourceNotFoundException;
import jakarta.persistence.Column;
import org.aspectj.lang.annotation.AdviceName;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    //create Exception handler methods
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> ResourceNotFoundException(
            ResourceNotFoundException e,
            WebRequest request) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> Exception(
            Exception e,
            WebRequest request) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<Object> BookingNotFoundException(
          BookingNotFoundException e,
            WebRequest request) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> EntityNotFoundException(
            EntityNotFoundException e,
            WebRequest request) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
