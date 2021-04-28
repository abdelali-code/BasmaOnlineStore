package ma.youcode.basmastoreapi.controllers;

import ma.youcode.basmastoreapi.entities.OrderStatus;
import ma.youcode.basmastoreapi.entities.PaymentMethod;
import ma.youcode.basmastoreapi.entities.ShoppingCartEntity;
import ma.youcode.basmastoreapi.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/basmastore/api/shopping-carts")
public class ShoppingCartRestController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping
    public ResponseEntity<List<ShoppingCartEntity>> getAllShoppingCarts() {
        return ResponseEntity.status(HttpStatus.OK).body(shoppingCartService.getAll());
    }

    @GetMapping("{shoppingCartId}")
    public ResponseEntity<ShoppingCartEntity> getShoppingCart(@PathVariable Long shoppingCartId) {
        return ResponseEntity.status(HttpStatus.OK).body(shoppingCartService.getById(shoppingCartId));
    }

    @PostMapping
    public ResponseEntity<ShoppingCartEntity> addShoppingCart(@RequestBody @Valid ShoppingCartEntity shoppingCart) {
        shoppingCart.setIdShoppingCart(0L);
        return ResponseEntity.status(HttpStatus.CREATED).body(shoppingCartService.addOrUpdate(shoppingCart));
    }

    @PutMapping
    public ResponseEntity<ShoppingCartEntity> updateShoppingCart(@RequestBody @Valid ShoppingCartEntity shoppingCart) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(shoppingCartService.addOrUpdate(shoppingCart));
    }

    @DeleteMapping("{shoppingCartId}")
    public ResponseEntity<String> deleteShoppingCart(@PathVariable Long shoppingCartId) {
        String result = "";
        if (shoppingCartService.deleteById(shoppingCartId)) {
            result = "Shopping cart with id " + shoppingCartId + " has deleted";
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
    }

    @GetMapping("search")
    public List<ShoppingCartEntity> shoppingCartsBy(
                                        @RequestParam(value = "city", required = false) String city,
                                        @RequestParam(value = "country", required = false) String country,
                                        @RequestParam(value = "gender", required = false) String gender,
                                        @RequestParam(value = "email", required = false) String email,
                                        @RequestParam(value = "date", required = false) Date date,
                                        @RequestParam(value = "status", required = false) String orderStatus,
                                        @RequestParam(value = "payment-method", required = false) String paymentMethod,
                                        @RequestParam(value = "promo-code", required = false) String code
    ) {
        List<ShoppingCartEntity> shoppingCartList = new ArrayList<>();
        if (city != null) {
            shoppingCartList =  shoppingCartService.findShoppingCartByCity(city);
        } else if (country != null) {
            shoppingCartList =  shoppingCartService.findShoppingCartByCountry(country);
        } else if (gender != null) {
            shoppingCartList =  shoppingCartService.findShoppingCartByGender(gender);
        } else if (email != null) {
            shoppingCartList =  shoppingCartService.findShoppingCartByEmail(email);
        } else if (date != null) {
            shoppingCartList =  shoppingCartService.findShoppingCartByOrderDate(date);
        } else if (orderStatus != null) {
            shoppingCartList =  shoppingCartService.findShoppingCartByOrderStatus(OrderStatus.valueOf(orderStatus.toUpperCase()));
        } else if (paymentMethod != null) {
            shoppingCartList =  shoppingCartService.findShoppingCartByPaymentMethod(PaymentMethod.valueOf(paymentMethod.toUpperCase()));
        } else if (code != null) {
            shoppingCartList =  shoppingCartService.findShoppingCartByPromoCode(code);
        }
        return shoppingCartList;
    }

}
