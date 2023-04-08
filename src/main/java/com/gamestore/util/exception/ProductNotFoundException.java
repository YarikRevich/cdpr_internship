package com.gamestore.util.exception;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(){
        super("Such product not found");
    }
}
