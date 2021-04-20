package com.example.product.customException;

import com.example.product.models.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class HandleException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setStatusCode(HttpStatus.NOT_FOUND);
        response.setMessage(ex.getMessage());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }

    //NoSuchElementException
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionResponse> handleNoSuchElementException(NoSuchElementException ex) {
        ExceptionResponse response = new ExceptionResponse(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }

    //NoSuchElementException
    @ExceptionHandler(ElementAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> handleElementAlreadyExistException(ElementAlreadyExistException ex) {
        ExceptionResponse response = new ExceptionResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
}
