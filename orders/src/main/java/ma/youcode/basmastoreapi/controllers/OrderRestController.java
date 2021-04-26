package ma.youcode.basmastoreapi.controllers;

import ma.youcode.basmastoreapi.entities.OrderEntity;
import ma.youcode.basmastoreapi.entities.ProductEntity;
import ma.youcode.basmastoreapi.services.OrderService;
import ma.youcode.basmastoreapi.services.ProductService;
import ma.youcode.basmastoreapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/basmastore/api/orders")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping
    private List<OrderEntity> getAllOrders() {
        return orderService.getAll();
    }

    @GetMapping("{orderId}")
    public OrderEntity orderEntity(@PathVariable Long orderId) {
        return orderService.getById(orderId);
    }

    @PostMapping
    private OrderEntity addOrder(@RequestBody OrderEntity orderEntity) {
        orderEntity.setIdOrder(0L);
        List<ProductEntity> products = new ArrayList<>();
//        products.add(productService.getById(1L));
//        products.add(productService.getById(2L));
//        orderEntity.setProducts(products);
        for (long productId : orderEntity.getProductsId()) {
            ProductEntity productEntity = restTemplate.getForObject("http://localhost:9000/products/" + productId, ProductEntity.class);
            products.add(productEntity);
        }
        orderEntity.setUser(userService.getById(1L));
        orderService.addOrUpdate(orderEntity);
        return orderEntity;
    }

    @PutMapping
    private OrderEntity updateOrder(@RequestBody OrderEntity orderEntity) {
        orderService.addOrUpdate(orderEntity);
        return orderEntity;
    }

    @DeleteMapping("{orderId}")
    private String deleteOrder(@PathVariable Long orderId) {
        if(orderService.deleteById(orderId)) {
            return "Order with id " + orderId + " has deleted";
        } else {
            return "Order doesn't delete it";
        }
    }
}
