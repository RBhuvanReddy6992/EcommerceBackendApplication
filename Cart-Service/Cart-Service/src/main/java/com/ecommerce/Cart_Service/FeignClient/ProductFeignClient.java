package com.ecommerce.Cart_Service.FeignClient;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.Cart_Service.Model.ProductDTO;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductFeignClient {

    @GetMapping("/product/{id}")
    ProductDTO getProduct(@PathVariable Integer id);
}
