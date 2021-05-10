package com.example.product.service.serviceImp;

import com.example.product.customException.ResourceNotFoundException;
import com.example.product.models.Category;
import com.example.product.models.Product;
import com.example.product.repository.CategoryRepository;
import com.example.product.repository.ProductsRepository;
import com.example.product.request.ProductRequest;
import com.example.product.responce.CategoryResponce;
import com.example.product.responce.ProductResponce;
import com.example.product.responce.ProductsList;
import com.example.product.service.CategoryService;
import com.example.product.service.ProductService;
import com.example.product.shared.GlobalConstVariable;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductsRepository productsRepository;
//    @Autowired
//    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    /** get all products */
    public ProductsList getAll() {
        List<Product> products = productsRepository.findAll();
        ProductsList productsList = new ProductsList();
        for (Product product : products) {
            ProductResponce productResponce = new ProductResponce();
            BeanUtils.copyProperties(product, productResponce);
            productResponce.setCategory(GlobalConstVariable.HOST+"/categories/"+product.getCategory().getId());
            productsList.addSingleProducts(productResponce);
        }
        return productsList;
    }

    /** add a Product */
    public ProductResponce addProduct(ProductRequest productRequest) {
        try {
            Product product = new Product();
            BeanUtils.copyProperties(productRequest, product);
//            Category category = categoryService.getCategoryById(productRequest.getCategoryId());
            Category category = categoryRepository.findById(productRequest.getCategoryId()).get();
            product.setCategory(category);
            product = productsRepository.save(product);
            ProductResponce productResponce = new ProductResponce();
            BeanUtils.copyProperties(product, productResponce);
            productResponce.setCategory(GlobalConstVariable.HOST+"/categories/"+product.getCategory().getId());
            return productResponce;
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
    public ProductResponce getProductById(long productId) {
        try {
            Product product = productsRepository.findById(productId).get();
            ProductResponce productResponce = new ProductResponce();
            BeanUtils.copyProperties(product, productResponce);
            productResponce.setCategory(GlobalConstVariable.HOST+"/categories/"+product.getCategory().getId());
            return productResponce;
        }
        catch (Exception ex) {
            throw new ResourceNotFoundException("product is not found for the id " + productId);
        }
    }

    @Override
    public ProductResponce updateProduct(long productId, ProductRequest productRequest) {
        try  {
            Product targetProduct = productsRepository.findById(productId).get();
            if (productRequest.getDiscount() > 0) {
                targetProduct.setDiscount(productRequest.getDiscount());
            }
            if (productRequest.getProductImages() != null) {
                targetProduct.setProductImages(productRequest.getProductImages());
            }
            if (productRequest.getCategoryId() > 0) {
//                Category category = categoryService.getCategoryById(productRequest.getCategoryId());
                Category category = categoryRepository.findById(productRequest.getCategoryId()).get();
                targetProduct.setCategory(category);
            }
            if (productRequest.getName() != null) {
                targetProduct.setName(productRequest.getName());
            }
            if (productRequest.getDescription() != null) {
                targetProduct.setDescription(productRequest.getDescription());
            }

            ProductResponce productResponce = new ProductResponce();
            BeanUtils.copyProperties(targetProduct, productResponce);
            productResponce.setCategory(GlobalConstVariable.HOST + "/categories/" + targetProduct.getCategory().getId());

            return productResponce;
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

    @Override
    public void deleteProductsByIdsIn(List<Long> ids) {
        try {
            productsRepository.deleteAllByIdIn(ids);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
