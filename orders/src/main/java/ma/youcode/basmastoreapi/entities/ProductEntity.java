package ma.youcode.basmastoreapi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", nullable = false, updatable = false)
    private Long idProduct;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity category;
    @ManyToMany
    @JoinTable( name = "order_product",
            joinColumns = @JoinColumn( name = "id_product" ),
            inverseJoinColumns = @JoinColumn( name = "id_order" ) )
    private List<OrderEntity> orders = new ArrayList<>();

    public ProductEntity() {
    }

    public ProductEntity(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public ProductEntity(Long idProduct, String name, Double price) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
    }

    public ProductEntity(String name, Double price, CategoryEntity category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public ProductEntity(Long idProduct, String name, Double price, CategoryEntity category) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public ProductEntity(String name, Double price, CategoryEntity category, List<OrderEntity> orders) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.orders = orders;
    }

    public ProductEntity(Long idProduct, String name, Double price, CategoryEntity category, List<OrderEntity> orders) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.category = category;
        this.orders = orders;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }
}
