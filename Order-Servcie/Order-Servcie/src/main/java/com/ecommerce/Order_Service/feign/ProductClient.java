package com.ecommerce.Order_Service.feign;

import org.springframework.cloud.openfeign.FeignClient; 
import org.springframework.web.bind.annotation.*;

import com.ecommerce.Order_Servcie.Model.ProductDto;

@FeignClient(name = "Product-Service")
public interface ProductClient {

    @GetMapping("/product/{id}")
    ProductDto getProduct(@PathVariable("id") Integer id);
}