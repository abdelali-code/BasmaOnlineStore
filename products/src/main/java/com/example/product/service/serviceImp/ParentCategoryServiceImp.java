package com.example.product.service.serviceImp;

import com.example.product.customException.ElementAlreadyExistException;
import com.example.product.customException.ResourceNotFoundException;
import com.example.product.models.ParentCategory;
import com.example.product.repository.ParentCategoryRepository;
import com.example.product.request.ParentCategoryRequest;
import com.example.product.service.ParentCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ParentCategoryServiceImp implements ParentCategoryService {

    @Autowired
    private ParentCategoryRepository parentCategoryRepository;

    @Override
    public List<ParentCategory> getAll() {
        return parentCategoryRepository.findAll();
    }

    @Override
    public ParentCategory getParentCategoryById(long id) {
        try {
            return parentCategoryRepository.findById(id).get();
        }
        catch (NoSuchElementException exception) {
            throw new ResourceNotFoundException("main category with this id is not found");
        }
    }

    @Override
    public void deleteAll() {
        parentCategoryRepository.deleteAll();
    }

    @Override
    public void deleteCategoryById(long id) {
        try {
            parentCategoryRepository.deleteById(id);
        }
        catch (NoSuchElementException exception) {
            throw new ResourceNotFoundException("category with id " + id + " is not found");
        }
    }

    @Override
    public ParentCategory addParentCategory(ParentCategoryRequest parentCategoryRequest) {
        try {
            ParentCategory parentCategory = new ParentCategory();
            BeanUtils.copyProperties(parentCategoryRequest, parentCategory);
            return parentCategoryRepository.save(parentCategory);
        }
        catch (DataIntegrityViolationException exception) {
            throw new ElementAlreadyExistException("the category with the name " + parentCategoryRequest.getName() + "already exist");
        }
    }

    @Override
    public ParentCategory updateParentCategoy(long id, ParentCategoryRequest parentCategoryRequest) {
        try {
            ParentCategory targetCategory = parentCategoryRepository.findById(id).get();
            if (parentCategoryRequest.getDescription()!= null) {
                targetCategory.setDescription(parentCategoryRequest.getDescription());
            }
            if (parentCategoryRequest.getImage() != null) {
                targetCategory.setName(parentCategoryRequest.getName());
            }
            if (parentCategoryRequest.getImage() != null) {
                targetCategory.setImage(parentCategoryRequest.getImage());
            }
            return targetCategory;
        }
        catch (NoSuchElementException exception) {
            throw new ResourceNotFoundException("category with id " + id + " is not found");
        }
    }
}
