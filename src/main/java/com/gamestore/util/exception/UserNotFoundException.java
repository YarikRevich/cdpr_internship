package com.gamestore.util.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(){
        super("Such user not found");
    }
}
