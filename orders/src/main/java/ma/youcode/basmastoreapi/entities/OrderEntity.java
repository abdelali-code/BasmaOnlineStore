package ma.youcode.basmastoreapi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false, updatable = false)
    private Long idOrder;
    @Column(nullable = false)
    private Date date;
    @Column(name = "is_checkout")
    private boolean isCheckout = false;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;
    @ManyToMany
    @JoinTable( name = "order_product",
            joinColumns = @JoinColumn( name = "id_order" ),
            inverseJoinColumns = @JoinColumn( name = "id_product" ) )
    private List<ProductEntity> products = new ArrayList<>();

    public OrderEntity() {
    }

    public OrderEntity(Date date, Boolean isCheckout) {
        this.date = date;
        this.isCheckout = isCheckout;
    }

    public OrderEntity(Long idOrder, Date date, Boolean isCheckout, List<ProductEntity> products) {
        this.idOrder = idOrder;
        this.date = date;
        this.isCheckout = isCheckout;
        this.products = products;
    }

    public OrderEntity(Date date, Boolean isCheckout, UserEntity user, List<ProductEntity> products) {
        this.date = date;
        this.isCheckout = isCheckout;
        this.user = user;
        this.products = products;
    }

    public OrderEntity(Long idOrder, Date date, Boolean isCheckout, UserEntity user, List<ProductEntity> products) {
        this.idOrder = idOrder;
        this.date = date;
        this.isCheckout = isCheckout;
        this.user = user;
        this.products = products;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getCheckout() {
        return isCheckout;
    }

    public void setCheckout(Boolean checkout) {
        isCheckout = checkout;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }


}
