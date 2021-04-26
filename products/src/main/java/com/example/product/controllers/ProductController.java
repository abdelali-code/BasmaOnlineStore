package com.example.product.controllers;


import com.example.product.models.Product;
import com.example.product.request.ProductRequest;
import com.example.product.responce.ProductResponce;
import com.example.product.responce.ProductsList;
import com.example.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<ProductsList> getAllProducts() {
        ProductsList productsList = productService.getAll();

//        List<Product> products = productService.getAll();
//        ProductsList productsList = new ProductsList();
//        for (Product product : products) {
//            ProductResponce productResponce = new ProductResponce();
//            BeanUtils.copyProperties(product, productResponce);
//            productsList.addSingleProducts(productResponce);
//        }
        return new ResponseEntity<>(productsList, HttpStatus.OK);
    }

    /** add products */
    @PostMapping
    public ResponseEntity<ProductResponce> addProducts(@RequestBody ProductRequest productRequest) {
        ProductResponce productResponce = productService.addProduct(productRequest);
//        ProductResponce productResponce = new ProductResponce();
//        BeanUtils.copyProperties(product, productResponce);
        return new ResponseEntity<>(productResponce, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteAll() {
        productService.deleteAllProducts();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    /** add single products
     * @return*/
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponce> addSingleProducts(@PathVariable("productId") long productId) {
        ProductResponce productResponce = productService.getProductById(productId);
        return new ResponseEntity<>(productResponce, HttpStatus.OK);
     }

    /** update all field of products */
    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponce> updateProducts(@PathVariable("productId") long productId, @RequestBody ProductRequest productRequest){
        ProductResponce productTarget = productService.updateProduct(productId, productRequest);
        return new ResponseEntity<>(productTarget, HttpStatus.ACCEPTED);
    }

//    @PatchMapping("/{productId}")
//    public String patchProduct(@PathVariable("productId") String productId) {
//        return "update some field of product  with id " + productId;
//    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("productId") long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
