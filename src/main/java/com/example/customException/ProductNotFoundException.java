package com.example.customException;

public class ProductNotFoundException extends RuntimeException{

    private String msg;

    public ProductNotFoundException( String msg) {
        super(msg);
        this.msg = msg;
    }
}
