package ma.youcode.basmastoreapi.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class ProductEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", nullable = false, updatable = false)
    private Long idProduct;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Double price;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_sub_category")
    private SubCategoryEntity subCategory;

    public ProductEntity() {
    }

    public ProductEntity(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductEntity(Long idProduct, String name, String description, Double price) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductEntity(String name, String description, Double price, SubCategoryEntity subCategory) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.subCategory = subCategory;
    }

    public ProductEntity(Long idProduct, String name, String description, Double price, SubCategoryEntity subCategory) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.subCategory = subCategory;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public SubCategoryEntity getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategoryEntity subCategory) {
        this.subCategory = subCategory;
    }
}
