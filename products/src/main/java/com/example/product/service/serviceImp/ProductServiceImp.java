package com.example.product.service.serviceImp;

import com.example.product.customException.ResourceNotFoundException;
import com.example.product.models.Category;
import com.example.product.models.Product;
import com.example.product.repository.ProductsRepository;
import com.example.product.request.ProductRequest;
import com.example.product.service.CategoryService;
import com.example.product.service.ProductService;
import org.springframework.beans.BeanUtils;
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
    public Product addProduct(ProductRequest productRequest) {
        try {
            Product product = new Product();
            BeanUtils.copyProperties(productRequest, product);
            Category category = categoryService.getCategoryById(productRequest.getCategoryId());
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
    public Product updateProduct(long productId, ProductRequest productRequest) {
        try  {
            Product targetProduct = productsRepository.findById(productId).get();
            if (productRequest.getDiscount() > 0) {
                targetProduct.setDiscount(productRequest.getDiscount());
            }
            if (productRequest.getProductImages() != null) {
                targetProduct.setProductImages(productRequest.getProductImages());
            }
            if (productRequest.getCategoryId() > 0) {
                Category category = categoryService.getCategoryById(productRequest.getCategoryId());
                targetProduct.setCategory(category);
            }
            if (productRequest.getName() != null) {
                targetProduct.setName(productRequest.getName());
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
