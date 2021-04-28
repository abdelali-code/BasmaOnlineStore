package ma.youcode.basmastoreapi.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product_order")
public class ProductOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_order", nullable = false, updatable = false)
    private Long idProductOrder;
    @NotNull
    private Integer quantity;
    @NotNull
    @Column(name = "total_price")
    private Double totalPrice;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_product")
    private ProductEntity product;

    public ProductOrderEntity() {
    }

    public ProductOrderEntity(Integer quantity, Double totalPrice) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public ProductOrderEntity(Long idProductOrder, Integer quantity, Double totalPrice) {
        this.idProductOrder = idProductOrder;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public ProductOrderEntity(Integer quantity, Double totalPrice, ProductEntity product) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;
    }

    public ProductOrderEntity(Long idProductOrder, Integer quantity, Double totalPrice, ProductEntity product) {
        this.idProductOrder = idProductOrder;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;
    }

    public Long getIdProductOrder() {
        return idProductOrder;
    }

    public void setIdProductOrder(Long idProductOrder) {
        this.idProductOrder = idProductOrder;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

}
