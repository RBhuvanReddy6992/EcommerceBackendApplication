package com.ecommerce.Category_Service.Controller;

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

import com.ecommerce.Category_Service.Model.Category;
import com.ecommerce.Category_Service.Service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService cs;

    public CategoryController(CategoryService cs) {
        this.cs = cs;
    }

    // Get all categories
    @GetMapping("/all")
    public List<Category> getAllCategory() {
        return cs.getAllCategory();
    }

    // Get category by id
    @GetMapping("/{id}")
    public ResponseEntity<Category> getByCategoryId(@PathVariable int id) {
        return cs.getCategoryById(id);
    }

    // Create category
    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return cs.createCategory(category);
    }

    // Update category
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(
            @PathVariable int id,
            @RequestBody Category category) {
        return cs.updateCategory(id, category);
    }

    // Delete category
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id) {
        return cs.deleteBycategory(id);
    }
}
