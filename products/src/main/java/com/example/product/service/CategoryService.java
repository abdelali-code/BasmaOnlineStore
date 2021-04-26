package com.example.product.service;

import com.example.product.models.Category;
import com.example.product.request.CategoryRequest;
import com.example.product.responce.CategoryResponce;
import com.example.product.responce.CategoryResponceList;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    CategoryResponceList getAll();
    CategoryResponce addCategory(CategoryRequest category);
    void deleteAll();
    CategoryResponce updateCategory(long id, CategoryRequest category);
    void deleteCategory(long id);

    CategoryResponce getCategoryById(Long categoryId);
}
