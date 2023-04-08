package com.gamestore.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(){
        super("Such user not found");
    }
}
