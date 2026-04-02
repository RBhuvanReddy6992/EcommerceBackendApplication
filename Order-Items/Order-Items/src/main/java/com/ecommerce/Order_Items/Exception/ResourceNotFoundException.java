package com.ecommerce.Order_Items.Exception;

public class ResourceNotFoundException extends RuntimeException{
	
    public ResourceNotFoundException(String message) {
        super(message);
    }

}