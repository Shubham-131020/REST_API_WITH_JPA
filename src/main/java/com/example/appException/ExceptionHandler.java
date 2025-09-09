package com.example.appException;

import com.example.customException.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class ExceptionHandler {

   /* @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public String handlerExp(Exception e)
    {
return e.getMessage();
    }*/


   /* @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public String handlerExp(RuntimeException e)
    {
        return e.getMessage();
    }*/

    @org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> productNotfound(ProductNotFoundException e)
    {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
