package com.example.product.customException;

public class ElementAlreadyExistException extends RuntimeException{

    public ElementAlreadyExistException(String messsage) {
        super(messsage);
    }
}
