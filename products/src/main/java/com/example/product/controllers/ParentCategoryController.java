package com.example.product.controllers;


import com.example.product.models.ParentCategory;
import com.example.product.request.ParentCategoryRequest;
import com.example.product.responce.ParentCategoryList;
import com.example.product.responce.ParentCategoryResponce;
import com.example.product.service.ParentCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/main-categories")
public class ParentCategoryController {

    @Autowired
    private ParentCategoryService parentCategoryService;
    /** get all parent categry */
    @GetMapping
    public ResponseEntity<ParentCategoryList> getAll() {
        List<ParentCategory>  parentCategories = parentCategoryService.getAll();
        ParentCategoryList parentCategoryList = new ParentCategoryList();

        for (ParentCategory parentCategory : parentCategories) {
            ParentCategoryResponce parentCategoryResponce = new ParentCategoryResponce();
            BeanUtils.copyProperties(parentCategory, parentCategoryResponce);
            parentCategoryList.addParentCategory(parentCategoryResponce);
        }
        return new ResponseEntity<>(parentCategoryList, HttpStatus.OK);
    }
    /** add ParentCategory */
    @PostMapping
    public ResponseEntity<ParentCategoryResponce> addParentCategory(@Valid @RequestBody ParentCategoryRequest parentCategoryRequest) {
        ParentCategory parentCategory = parentCategoryService.addParentCategory(parentCategoryRequest);
        ParentCategoryResponce parentCategoryResponce = new ParentCategoryResponce();
        BeanUtils.copyProperties(parentCategory, parentCategoryResponce);
        return new ResponseEntity<>(parentCategoryResponce, HttpStatus.CREATED);
    }
    /** delete all parent category */
    @DeleteMapping
    public ResponseEntity<Object> deleteAll() {
        parentCategoryService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /** get parent categry with id */
    @GetMapping("/{cateId}")
    public ResponseEntity<ParentCategoryResponce> getParentCategoryWithId(@PathVariable("cateId") long cateId) {
        ParentCategory parentCategory = parentCategoryService.getParentCategoryById(cateId);
        ParentCategoryResponce parentCategoryResponce = new ParentCategoryResponce();
        BeanUtils.copyProperties(parentCategory, parentCategoryResponce);
        return new ResponseEntity<>(parentCategoryResponce, HttpStatus.OK);
    }
    /**  update parentCategory */
    @PutMapping("/{cateId}")
    public ResponseEntity<ParentCategoryResponce> getParentCategory(@PathVariable("cateId") long cateId, @RequestBody ParentCategoryRequest parentCategoryRequest) {
        ParentCategory parentCategory = parentCategoryService.updateParentCategoy(cateId, parentCategoryRequest);
        ParentCategoryResponce parentCategoryResponce = new ParentCategoryResponce();
        BeanUtils.copyProperties(parentCategory, parentCategoryResponce);
        return new ResponseEntity<>(parentCategoryResponce, HttpStatus.ACCEPTED);
    }

    /**  delete parentCategory */
    @DeleteMapping("/{cateId}")
    public ResponseEntity<Object> deleteParentCategory(@PathVariable("cateId") long cateId) {
        parentCategoryService.deleteCategoryById(cateId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
