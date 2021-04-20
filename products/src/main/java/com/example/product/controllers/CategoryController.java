package com.example.product.controllers;

import com.example.product.models.Category;
import com.example.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.getAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category targetCategory = categoryService.addCategory(category);
        return new ResponseEntity<>(targetCategory, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteALlCategories() {
         categoryService.deleteAll();
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable("categoryId") Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(category, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable("categoryId") Long categoryId, @RequestBody Category category) {
        Category categoryTarget = categoryService.updateCategory(categoryId, category);
        return new ResponseEntity<>(categoryTarget, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Object> deleteCategory(@PathVariable("categoryId") long categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
