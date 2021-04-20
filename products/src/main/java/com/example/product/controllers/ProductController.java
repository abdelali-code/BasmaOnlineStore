package com.example.product.controllers;


import com.example.product.models.Product;
import com.example.product.service.ProductService;
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
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /** add products */
    @PostMapping
    public ResponseEntity<Product> addProducts(@RequestBody Product product) {
        Product productTarget = productService.addProduct(product);
        return new ResponseEntity<>(productTarget, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteAll() {
        productService.deleteAllProducts();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    /** add single products
     * @return*/
    @GetMapping("/{productId}")
    public ResponseEntity<Product> addSingleProducts(@PathVariable("productId") long productId) {
        Product product = productService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
     }

    /** update all field of products */
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProducts(@PathVariable("productId") long productId, @RequestBody Product product){
        Product productTarget = productService.updateProduct(productId, product);
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
