package com.ecommerce.Product_Service.Exception;

public class ResourceNotFoundException extends RuntimeException{
	
    public ResourceNotFoundException(String message) {
        super(message);
    }

}
