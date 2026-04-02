package com.ecommerce.Product_Service.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.Product_Service.Model.Product;
import com.ecommerce.Product_Service.Model.ProductDto;
import com.ecommerce.Product_Service.Repository.ProductRepository;


@Service
public class ProductService {

    private static final CrudRepository<Product, Integer> productRepository = null;
	private final ProductRepository pr;

    public ProductService(ProductRepository pr) {
        this.pr = pr;
    }

    // Get all products
    public List<Product> getAllProducts() {
        return pr.findAll();
    }

    // Get product by id
    public ResponseEntity<Product> getProductById(int id) {
        return pr.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create product
    public ResponseEntity<Product> createProduct(Product product) {

        product.setCreated_at(LocalDateTime.now()); 
        Product saved = pr.save(product);

        return ResponseEntity.ok(saved);
    }
    
    public ProductDto getProductDtoById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return mapToDto(product);
    }

    public ProductDto mapToDto(Product product) {
        ProductDto dto = new ProductDto();

        dto.setId(product.getProduct_id());  
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getQuantity());

        return dto;
    }

    // Update product
    public ResponseEntity<Product> updateProduct(int id, Product product) {

        Optional<Product> existingOpt = pr.findById(id);

        if (existingOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Product existing = existingOpt.get();
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());
        existing.setCategory_id(product.getCategory_id());

        Product updated = pr.save(existing);
        return ResponseEntity.ok(updated);
    }

    // Delete product
    public ResponseEntity<String> deleteById(int id) {

        if (!pr.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        pr.deleteById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
    
    
}
