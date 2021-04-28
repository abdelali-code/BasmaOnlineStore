package ma.youcode.basmastoreapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shopping_cart", nullable = false, updatable = false)
    private Long idShoppingCart;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus = OrderStatus.PENDING;
    @NotNull
    @Column(name = "total_price")
    private Double totalPrice;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;
//    @NotNull
    @Column(name = "order_date")
    private Date orderDate;
    @NotNull
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "product_cart",
            joinColumns = @JoinColumn(name = "id_shopping_cart"),
            inverseJoinColumns = @JoinColumn(name = "id_product_order"))
    private List<ProductOrderEntity> productOrders = new ArrayList<>();
    @NotNull
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_customer_details")
    private CustomerDetailsEntity customerDetails;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_promo_code")
    private PromoCodeEntity promoCode;

    public ShoppingCartEntity() {
    }

    public ShoppingCartEntity(OrderStatus orderStatus, Double totalPrice, PaymentMethod paymentMethod, Date orderDate) {
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.orderDate = orderDate;
    }

    public ShoppingCartEntity(Long idShoppingCart, OrderStatus orderStatus, Double totalPrice, PaymentMethod paymentMethod, Date orderDate) {
        this.idShoppingCart = idShoppingCart;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.orderDate = orderDate;
    }

    public ShoppingCartEntity(OrderStatus orderStatus, Double totalPrice, PaymentMethod paymentMethod, Date orderDate, List<ProductOrderEntity> productOrders, CustomerDetailsEntity customerDetails) {
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.productOrders = productOrders;
        this.customerDetails = customerDetails;
        this.orderDate = orderDate;
    }

    public ShoppingCartEntity(Long idShoppingCart, OrderStatus orderStatus, Double totalPrice, PaymentMethod paymentMethod, Date orderDate, List<ProductOrderEntity> productOrders, CustomerDetailsEntity customerDetails) {
        this.idShoppingCart = idShoppingCart;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.productOrders = productOrders;
        this.customerDetails = customerDetails;
        this.orderDate = orderDate;
    }

    public ShoppingCartEntity(OrderStatus orderStatus, Double totalPrice, PaymentMethod paymentMethod, Date orderDate, List<ProductOrderEntity> productOrders, CustomerDetailsEntity customerDetails, PromoCodeEntity promoCode) {
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.productOrders = productOrders;
        this.customerDetails = customerDetails;
        this.promoCode = promoCode;
        this.orderDate = orderDate;
    }

    public ShoppingCartEntity(Long idShoppingCart, OrderStatus orderStatus, Double totalPrice, PaymentMethod paymentMethod, Date orderDate, List<ProductOrderEntity> productOrders, CustomerDetailsEntity customerDetails, PromoCodeEntity promoCode) {
        this.idShoppingCart = idShoppingCart;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.productOrders = productOrders;
        this.customerDetails = customerDetails;
        this.promoCode = promoCode;
        this.orderDate = orderDate;
    }

    public Long getIdShoppingCart() {
        return idShoppingCart;
    }

    public void setIdShoppingCart(Long idShoppingCart) {
        this.idShoppingCart = idShoppingCart;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<ProductOrderEntity> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(List<ProductOrderEntity> productOrders) {
        this.productOrders = productOrders;
    }

    public CustomerDetailsEntity getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetailsEntity customerDetails) {
        this.customerDetails = customerDetails;
    }

    public PromoCodeEntity getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(PromoCodeEntity promoCode) {
        this.promoCode = promoCode;
    }
}
