package com.ecommerce.Product_Service.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Product_Service.Model.Product;
import com.ecommerce.Product_Service.Model.ProductDto;
import com.ecommerce.Product_Service.Service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService ps;

    public ProductController(ProductService ps) {
        this.ps = ps;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
        return ps.getProductById(id);
    }

    // Get all products
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return ps.getAllProducts();
    }

   

    // Create product
    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ps.createProduct(product);
    }

    // Update product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable int id,
            @RequestBody Product product) {
        return ps.updateProduct(id, product);
    }

    // Delete product
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        return ps.deleteById(id);
    }
}
