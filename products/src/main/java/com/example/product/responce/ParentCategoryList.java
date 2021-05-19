package com.example.product.responce;

import com.example.product.models.ParentCategory;

import java.util.ArrayList;
import java.util.List;

public class ParentCategoryList {

    private List<ParentCategoryResponce> parentCategories;


    public ParentCategoryList() {
        this.parentCategories = new ArrayList<>();
    }
    public List<ParentCategoryResponce> getParentCategories() {
        return parentCategories;
    }

    public void setParentCategories(List<ParentCategoryResponce> parentCategories) {
        this.parentCategories = parentCategories;
    }

    public void addParentCategory(ParentCategoryResponce parentCategoryResponce) {
        this.parentCategories.add(parentCategoryResponce);
    }
}
