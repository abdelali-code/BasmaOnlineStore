package com.example.product.controllers;


import com.example.product.models.ParentCategory;
import com.example.product.service.ParentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main-categories")
public class ParentCategoryController {

    @Autowired
    private ParentCategoryService parentCategoryService;
    /** get all parent categry */
    @GetMapping
    public ResponseEntity<List<ParentCategory>> getAll() {
        List<ParentCategory>  parentCategories = parentCategoryService.getAll();
        return new ResponseEntity<>(parentCategories, HttpStatus.OK);
    }
    /** add ParentCategory */
    @PostMapping
    public ResponseEntity<ParentCategory> addParentCategory(@RequestBody ParentCategory parentCategory) {
        ParentCategory category = parentCategoryService.addParentCategory(parentCategory);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }
    /** delete all parent category */
    @DeleteMapping
    public ResponseEntity<Object> deleteAll() {
        parentCategoryService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /** get parent categry with id */
    @GetMapping("/{cateId}")
    public ResponseEntity<ParentCategory> getParentCategoryWithId(@PathVariable("cateId") long cateId) {
        ParentCategory parentCategory = parentCategoryService.getParentCategoryById(cateId);
        return new ResponseEntity<>(parentCategory, HttpStatus.OK);
    }
    /**  update parentCategory */
    @PutMapping("/{cateId}")
    public ResponseEntity<ParentCategory> getParentCategory(@PathVariable("cateId") long cateId, @RequestBody ParentCategory parentCategory) {
        ParentCategory category = parentCategoryService.updateParentCategoy(cateId, parentCategory);
        return new ResponseEntity<>(category, HttpStatus.ACCEPTED);
    }

    /**  delete parentCategory */
    @DeleteMapping("/{cateId}")
    public ResponseEntity<Object> deleteParentCategory(@PathVariable("cateId") long cateId) {
        parentCategoryService.deleteCategoryById(cateId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
