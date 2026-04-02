package com.ecommerce.Order_Servcie.Exception;

public class ResourceNotFoundException extends RuntimeException{
	
    public ResourceNotFoundException(String message) {
        super(message);
    }

}
