package com.example.product.responce;

import java.util.ArrayList;
import java.util.List;

public class CategoryResponceList {


    private List<CategoryResponce> categoryResponces;

    public CategoryResponceList() {
        this.categoryResponces = new ArrayList<>();
    }

    public List<CategoryResponce> getCategoryResponces() {
        return categoryResponces;
    }

    public void setCategoryResponces(List<CategoryResponce> categoryResponces) {
        this.categoryResponces = categoryResponces;
    }

    public void addCategoryResponce(CategoryResponce categoryResponce) {
        this.categoryResponces.add(categoryResponce);
    }
}
