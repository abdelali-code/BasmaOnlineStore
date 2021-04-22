package com.example.product.controllers;

import com.example.product.models.Category;
import com.example.product.request.CategoryRequest;
import com.example.product.responce.CategoryList;
import com.example.product.responce.CategoryResponce;
import com.example.product.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<CategoryList> getCategories() {
        List<Category> categories = categoryService.getAll();
        CategoryList categoryList = new CategoryList();
        for (Category category : categories) {
            CategoryResponce categoryResponce = new CategoryResponce();
            BeanUtils.copyProperties(category, categoryResponce);
            categoryList.addCategoryResponce(categoryResponce);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryResponce> addCategory(@RequestBody CategoryRequest categoryRequest) {
        Category targetCategory = categoryService.addCategory(categoryRequest);
        CategoryResponce categoryResponce = new CategoryResponce();
        BeanUtils.copyProperties(targetCategory, categoryResponce);
        return new ResponseEntity<>(categoryResponce, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteALlCategories() {
         categoryService.deleteAll();
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponce> getCategory(@PathVariable("categoryId") Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        CategoryResponce categoryResponce = new CategoryResponce();
        BeanUtils.copyProperties(category, categoryResponce);
        return new ResponseEntity<>(categoryResponce, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryResponce> updateCategory(@PathVariable("categoryId") Long categoryId, @RequestBody CategoryRequest categoryRequest) {
        Category categoryTarget = categoryService.updateCategory(categoryId, categoryRequest);
        CategoryResponce categoryResponce = new CategoryResponce();
        BeanUtils.copyProperties(categoryTarget, categoryResponce);
        return new ResponseEntity<>(categoryResponce, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Object> deleteCategory(@PathVariable("categoryId") long categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
