package com.example.product.service.serviceImp;

import com.example.product.customException.ResourceNotFoundException;
import com.example.product.models.Category;
import com.example.product.models.ParentCategory;
import com.example.product.repository.CategoryRepository;
import com.example.product.request.CategoryRequest;
import com.example.product.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.product.repository.ParentCategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ParentCategoryRepository parentCategoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryRequest, category);
        return categoryRepository.save(category);
    }

    @Override
    public void deleteAll() {
        categoryRepository.deleteAll();
    }

    @Override
    public Category updateCategory(long id, CategoryRequest categoryRequest) {
        try {
            Category targetCategory = categoryRepository.findById(id).get();
            if (categoryRequest.getImage() != null) {
                targetCategory.setImage(categoryRequest.getImage());
            }
            if (categoryRequest.getName() != null) {
                targetCategory.setName(categoryRequest.getName());
            }
            if (categoryRequest.getDescription() != null) {
                targetCategory.setDescription(categoryRequest.getDescription());
            }
            if (categoryRequest.getCategory() > 0) {
                try {
                    ParentCategory parentCategory = parentCategoryRepository.findById(categoryRequest.getCategory()).get();
                    targetCategory.setParentCategory(parentCategory);
                }
                catch (Exception exception) {
                    throw new ResourceNotFoundException("main category is not found for id " + categoryRequest.getCategory());
                }
            }
//            targetCategory.setCategoryImage(category.getCategoryImage());
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
