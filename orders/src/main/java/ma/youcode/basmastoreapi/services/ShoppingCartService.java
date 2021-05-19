package ma.youcode.basmastoreapi.services;

import ma.youcode.basmastoreapi.entities.OrderStatus;
import ma.youcode.basmastoreapi.entities.PaymentMethod;
import ma.youcode.basmastoreapi.entities.ShoppingCartEntity;
import ma.youcode.basmastoreapi.exceptions.ShoppingCartNotExistException;
import ma.youcode.basmastoreapi.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartEntity getById(Long idShoppingCart) {
        if (shoppingCartRepository.findById(idShoppingCart).isPresent()) {
            return shoppingCartRepository.findById(idShoppingCart).get();
        } else {
            throw new ShoppingCartNotExistException("Shopping cart does not exist");
        }
    }

    public List<ShoppingCartEntity> getAll() {
        return shoppingCartRepository.findAll();
    }

    public ShoppingCartEntity addOrUpdate(ShoppingCartEntity idShoppingCart) {
        return shoppingCartRepository.save(idShoppingCart);
    }

    public boolean deleteById(Long idShoppingCart) {
        shoppingCartRepository.deleteById(idShoppingCart);
        return true;
    }

    public List<ShoppingCartEntity> findShoppingCartByCity(String city) {
        return shoppingCartRepository.findShoppingCartEntitiesByCustomerDetails_CityIgnoreCase(city);
    }

    public List<ShoppingCartEntity> findShoppingCartByCountry(String country) {
        return shoppingCartRepository.findShoppingCartEntitiesByCustomerDetails_CountryIgnoreCase(country);
    }

    public List<ShoppingCartEntity> findShoppingCartByGender(String gender) {
        return shoppingCartRepository.findShoppingCartEntitiesByCustomerDetails_GenderIgnoreCase(gender);
    }
    public List<ShoppingCartEntity> findShoppingCartByEmail(String email) {
        return shoppingCartRepository.findShoppingCartEntitiesByCustomerDetails_User_EmailIgnoreCase(email);
    }

    public List<ShoppingCartEntity> findShoppingCartByOrderDate(Date date) {
        return shoppingCartRepository.findShoppingCartEntitiesByOrderDate(date);
    }

    public List<ShoppingCartEntity> findShoppingCartByOrderStatus(OrderStatus orderStatus) {
        return shoppingCartRepository.findShoppingCartEntitiesByOrderStatus(orderStatus);
    }

    public List<ShoppingCartEntity> findShoppingCartByPaymentMethod(PaymentMethod paymentMethod) {
        return shoppingCartRepository.findShoppingCartEntitiesByPaymentMethod(paymentMethod);
    }

    public List<ShoppingCartEntity> findShoppingCartByPromoCode(String code) {
        return shoppingCartRepository.findShoppingCartEntitiesByPromoCode_Code(code);
    }
}
