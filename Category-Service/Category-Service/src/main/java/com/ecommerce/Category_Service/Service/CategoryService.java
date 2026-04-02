package com.ecommerce.Category_Service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.Category_Service.Model.Category;
import com.ecommerce.Category_Service.Repository.CategoryRepository;

@Service   // 🔥 THIS WAS MISSING
public class CategoryService {

    private final CategoryRepository cr;

    public CategoryService(CategoryRepository cr) {
        this.cr = cr;
    }

    public List<Category> getAllCategory() {
        return cr.findAll();
    }

    public ResponseEntity<Category> getCategoryById(int id) {
        return cr.findById(id)
                 .map(ResponseEntity::ok)
                 .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Category> createCategory(Category category) {
        Category saved = cr.save(category);
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<Category> updateCategory(int id, Category category) {
        Optional<Category> existing = cr.findById(id);

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Category c = existing.get();
        c.setCategory_name(category.getCategory_name());
        

        return ResponseEntity.ok(cr.save(c));
    }

    public ResponseEntity<String> deleteBycategory(int id) {
        if (!cr.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        cr.deleteById(id);
        return ResponseEntity.ok("Data Deleted Successfully");
    }
}
