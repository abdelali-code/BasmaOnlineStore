package com.example.product.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ParentCategoryRequest {

    @Size(min = 3, message = "name must be greater than 3 character")
    private String name;
    @Size(min = 6, message = "description must be greater than 6 character")
    private String description;
    private String image;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
