package ma.youcode.basmastoreapi.repositories;

import ma.youcode.basmastoreapi.entities.OrderStatus;
import ma.youcode.basmastoreapi.entities.PaymentMethod;
import ma.youcode.basmastoreapi.entities.ShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCartEntity, Long> {
    List<ShoppingCartEntity> findShoppingCartEntitiesByCustomerDetails_CityIgnoreCase(String city);
    List<ShoppingCartEntity> findShoppingCartEntitiesByCustomerDetails_CountryIgnoreCase(String country);
    List<ShoppingCartEntity> findShoppingCartEntitiesByCustomerDetails_GenderIgnoreCase(String gender);
    List<ShoppingCartEntity> findShoppingCartEntitiesByCustomerDetails_User_EmailIgnoreCase(String email);
    List<ShoppingCartEntity> findShoppingCartEntitiesByOrderDate(Date date);
    List<ShoppingCartEntity> findShoppingCartEntitiesByOrderStatus(OrderStatus orderStatus);
    List<ShoppingCartEntity> findShoppingCartEntitiesByPaymentMethod(PaymentMethod paymentMethod);
    List<ShoppingCartEntity> findShoppingCartEntitiesByPromoCode_Code(String code);

}
