package com.example.product.controllers;

import com.example.product.models.Category;
import com.example.product.request.CategoryRequest;
import com.example.product.responce.CategoryResponce;
import com.example.product.responce.CategoryResponceList;
import com.example.product.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<CategoryResponceList> getCategories() {
        CategoryResponceList categoryResponceList = categoryService.getAll();
        return new ResponseEntity<>(categoryResponceList, HttpStatus.OK);
//        System.out.println("the size of the categories " + categories.size());
//        CategoryList categoryList = new CategoryList();
//        for (Category category : categories) {
//            CategoryResponce categoryResponce = new CategoryResponce();
//            BeanUtils.copyProperties(category, categoryResponce);
//            System.out.println("the id " + categoryResponce.getId());
//            categoryList.addCategoryResponce(categoryResponce);
//        }
    }

    @PostMapping
    public ResponseEntity<CategoryResponce> addCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        CategoryResponce categoryResponce = categoryService.addCategory(categoryRequest);
        return new ResponseEntity<>(categoryResponce, HttpStatus.CREATED);
//        CategoryResponce categoryResponce = new CategoryResponce();
//        BeanUtils.copyProperties(targetCategory, categoryResponce);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteALlCategories() {
         categoryService.deleteAll();
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponce> getCategory(@PathVariable("categoryId") Long categoryId) {
        CategoryResponce categoryResponce = categoryService.getCategoryById(categoryId);
//        CategoryResponce categoryResponce = new CategoryResponce();
//        BeanUtils.copyProperties(category, categoryResponce);
        return new ResponseEntity<>(categoryResponce, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryResponce> updateCategory(@PathVariable("categoryId") Long categoryId, @RequestBody CategoryRequest categoryRequest) {
        CategoryResponce categoryResponce = categoryService.updateCategory(categoryId, categoryRequest);
        return new ResponseEntity<>(categoryResponce, HttpStatus.ACCEPTED);
//        CategoryResponce categoryResponce = new CategoryResponce();
//        BeanUtils.copyProperties(categoryTarget, categoryResponce);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Object> deleteCategory(@PathVariable("categoryId") long categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
