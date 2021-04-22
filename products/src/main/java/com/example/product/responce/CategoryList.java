package com.example.product.responce;

import java.util.List;

public class CategoryList {

    private List<CategoryResponce> categoryResponces;

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
