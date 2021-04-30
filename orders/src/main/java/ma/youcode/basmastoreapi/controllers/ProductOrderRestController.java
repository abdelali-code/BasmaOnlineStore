package ma.youcode.basmastoreapi.controllers;

import ma.youcode.basmastoreapi.entities.ProductOrderEntity;
import ma.youcode.basmastoreapi.services.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/basmastore/api/product-orders")
public class ProductOrderRestController {
    @Autowired
    private ProductOrderService productOrderService;

    @GetMapping
    public ResponseEntity<List<ProductOrderEntity>> getAllProductsOrders() {
        return ResponseEntity.status(HttpStatus.OK).body(productOrderService.getAll());
    }

    @GetMapping("{productOrderId}")
    public ResponseEntity<ProductOrderEntity> getProductsOrder(@PathVariable Long productOrderId) {
        return ResponseEntity.status(HttpStatus.OK).body(productOrderService.getById(productOrderId));
    }

    @PostMapping
    public ResponseEntity<ProductOrderEntity> addProductOrder(@RequestBody @Valid ProductOrderEntity productOrder) {
        productOrder.setIdProductOrder(0L);
        System.out.println(productOrder.getProduct().getIdProduct());
        return ResponseEntity.status(HttpStatus.CREATED).body(productOrderService.addOrUpdate(productOrder));
    }

    @PutMapping
    public ResponseEntity<ProductOrderEntity> updateProductOrder(@RequestBody @Valid ProductOrderEntity productOrder) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productOrderService.addOrUpdate(productOrder));
    }

    @DeleteMapping("{productOrderId}")
    public ResponseEntity<Object> deleteProductOrder(@PathVariable Long productOrderId) {
        String result = "";
        if (productOrderService.deleteById(productOrderId)) {
            result = "Product order with id " + productOrderId + " has deleted";
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
    }

}
