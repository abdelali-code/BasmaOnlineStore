package com.example.product.service.serviceImp;

import com.example.product.customException.ElementAlreadyExistException;
import com.example.product.customException.ResourceNotFoundException;
import com.example.product.models.ParentCategory;
import com.example.product.repository.ParentCategoryRepository;
import com.example.product.service.ParentCategoryService;
import org.postgresql.util.PSQLException;
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
    public ParentCategory addParentCategory(ParentCategory parentCategory) {
        try {
            return parentCategoryRepository.save(parentCategory);
        }
        catch (DataIntegrityViolationException exception) {
            throw new ElementAlreadyExistException("the category with the name " + parentCategory.getName() + "already exist");
        }
    }

    @Override
    public ParentCategory updateParentCategoy(long id, ParentCategory parentCategory) {
        try {
            ParentCategory targetCategory = parentCategoryRepository.findById(id).get();
            if (parentCategory.getDescription() != null) {
                targetCategory.setDescription(parentCategory.getDescription());
            }
            if (parentCategory.getImage() != null) {
                targetCategory.setName(parentCategory.getName());
            }
            if (parentCategory.getImage() != null) {
                targetCategory.setImage(parentCategory.getImage());
            }
            return targetCategory;
        }
        catch (NoSuchElementException exception) {
            throw new ResourceNotFoundException("category with id " + id + " is not found");
        }
    }
}
