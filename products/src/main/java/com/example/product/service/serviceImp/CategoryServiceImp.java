package com.example.product.service.serviceImp;

import com.example.product.customException.ResourceNotFoundException;
import com.example.product.models.Category;
import com.example.product.models.ParentCategory;
import com.example.product.repository.CategoryRepository;
import com.example.product.request.CategoryRequest;
import com.example.product.responce.CategoryResponce;
import com.example.product.responce.CategoryResponceList;
import com.example.product.service.CategoryService;
import com.example.product.shared.GlobalConstVariable;
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
    public CategoryResponceList getAll() {
        List<Category> categoryList = categoryRepository.findAll();
        CategoryResponceList categoryResponceList = new CategoryResponceList();

        for (Category category : categoryList) {
            CategoryResponce categoryResponce = new CategoryResponce();
            BeanUtils.copyProperties(category, categoryResponce);
            categoryResponce.setParentCategory(GlobalConstVariable.HOST+"/main-categories/"+category.getParentCategory().getId());
            categoryResponceList.addCategoryResponce(categoryResponce);
        }
        return categoryResponceList;

    }

    @Override
    public CategoryResponce addCategory(CategoryRequest categoryRequest) {
        try {
            ParentCategory parentCategory = parentCategoryRepository.findById(categoryRequest.getCategory()).get();
            Category category = new Category();
            BeanUtils.copyProperties(categoryRequest, category);
            category.setParentCategory(parentCategory);
            Category addedCategory = categoryRepository.save(category);
            CategoryResponce categoryResponce = new CategoryResponce();
            BeanUtils.copyProperties(addedCategory, categoryResponce);
            categoryResponce.setParentCategory(GlobalConstVariable.HOST+"/main-categories/"+parentCategory.getId());
            return categoryResponce;

        }
        catch (Exception exception) {
            throw new ResourceNotFoundException("main category is not found for id " + categoryRequest.getCategory());
        }
    }

    @Override
    public void deleteAll() {
        categoryRepository.deleteAll();
    }

    @Override
    public CategoryResponce updateCategory(long id, CategoryRequest categoryRequest) {
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
            CategoryResponce categoryResponce = new CategoryResponce();
            BeanUtils.copyProperties(targetCategory, categoryResponce);
            categoryResponce.setParentCategory(GlobalConstVariable.HOST+"/main-categories/"+ targetCategory.getParentCategory().getId());
            return categoryResponce;
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
    public CategoryResponce getCategoryById(Long categoryId) {
        try {
            Category category = categoryRepository.findById(categoryId).get();
            CategoryResponce categoryResponce = new CategoryResponce();
            BeanUtils.copyProperties(category, categoryResponce);
            categoryResponce.setParentCategory(GlobalConstVariable.HOST+"/main-categories/"+category.getParentCategory().getId());
            return categoryResponce;
        }
        catch(Exception ex){
            throw new ResourceNotFoundException("category is not found");
        }
    }

    /**
     * construct the parent category lien
     * */
//    private CategoryResponce constructHyberLink(CategoryResponce categoryResponce) {
//        String lien = GlobalConstVariable.HOST+"/main-categories/"+parentCategory.getId();
//    }
}
