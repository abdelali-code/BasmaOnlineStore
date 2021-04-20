package com.example.product.service.serviceImp;

import com.example.product.customException.ResourceNotFoundException;
import com.example.product.models.Category;
import com.example.product.models.Product;
import com.example.product.repository.ProductsRepository;
import com.example.product.service.CategoryService;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    private CategoryService categoryService;

    /** get all products */
    public List<Product> getAll() {
        return productsRepository.findAll();
    }

    /** add a Product */
    public Product addProduct(Product product) {
        try {
            System.out.println(product.getTempCategory());
            Category category = categoryService.getCategoryById(product.getTempCategory());
            System.out.println(category.getName());
            product.setCategory(category);
            return productsRepository.save(product);
        }
        catch (Exception exception) {
            throw new ResourceNotFoundException("category is not found");
        }
    }

    @Override
    public void deleteAllProducts() {
        productsRepository.deleteAll();
    }

    @Override
    public Product getProductById(long productId) {
        try {
            return productsRepository.findById(productId).get();
        }
        catch (Exception ex) {
            throw new ResourceNotFoundException("product is not found for the id " + productId);
        }
    }

    @Override
    public Product updateProduct(long productId, Product product) {
        try  {
            Product targetProduct = productsRepository.findById(productId).get();
            if (product.getDiscount() > 0) {
                targetProduct.setDiscount(product.getDiscount());
            }
            if (product.getProductImages() != null) {
                targetProduct.setProductImages(product.getProductImages());
            }
            if (product.getTempCategory() > 0) {
                Category category = categoryService.getCategoryById(product.getTempCategory());
                targetProduct.setCategory(category);
            }
            if (product.getName() != null) {
                targetProduct.setName(product.getName());
            }
            return targetProduct;
        }
        catch (Exception exception) {
            throw new ResourceNotFoundException("product not found " + productId);
        }
    }

    @Override
    public void deleteProduct(long productId) {
        try {
            Product product = productsRepository.findById(productId).get();
            productsRepository.delete(product);
        }
        catch (Exception exception) {
            throw new ResourceNotFoundException("product not found with id" + productId);
        }
    }
}
