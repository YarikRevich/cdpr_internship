package com.example.practicaltask.util.exception;

public class NotEnoughMoneyToBuyProductException extends Exception {
    public NotEnoughMoneyToBuyProductException(){
        super("There is not enough money to buy product");
    }
}
