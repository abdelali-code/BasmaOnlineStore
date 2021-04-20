package com.example.product.service.serviceImp;

import com.example.product.customException.ResourceNotFoundException;
import com.example.product.models.Category;
import com.example.product.repository.CategoryRepository;
import com.example.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteAll() {
        categoryRepository.deleteAll();
    }

    @Override
    public Category updateCategory(long id, Category category) {
        try {
            Category targetCategory = categoryRepository.findById(id).get();
            targetCategory.setCategoryImage(category.getCategoryImage());
            targetCategory.setName(category.getName());
            return targetCategory;
        }
        catch (Exception ex) {
            throw new ResourceNotFoundException("category not found");
        }
    }

    @Override
    public void deleteCategory(long id) {
        try{
            Category category = categoryRepository.findById(id).get();
            categoryRepository.delete(category);
        }catch (Exception ex) {
            throw new ResourceNotFoundException("category is not found");
        }
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        try {
            Category category = categoryRepository.findById(categoryId).get();
            return category;
        }
        catch(Exception ex){
            throw new ResourceNotFoundException("category is not found");
        }
    }
}
