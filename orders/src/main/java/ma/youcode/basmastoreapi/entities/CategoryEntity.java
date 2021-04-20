package ma.youcode.basmastoreapi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "categories")
public class CategoryEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category", nullable = false, updatable = false)
    private Integer idCategory;
    @Column(nullable = false)
    private String name;
//    @OneToMany(mappedBy = "category")
//    private List<ProductEntity> products = new ArrayList<>();

    public CategoryEntity() {
    }

    public CategoryEntity(String name) {
        this.name = name;
    }

    public CategoryEntity(Integer idCategory, String name) {
        this.idCategory = idCategory;
        this.name = name;
    }

    public CategoryEntity(String name, List<ProductEntity> products) {
        this.name = name;
    }

    public CategoryEntity(Integer idCategory, String name, List<ProductEntity> products) {
        this.idCategory = idCategory;
        this.name = name;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<ProductEntity> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<ProductEntity> products) {
//        this.products = products;
//    }
}
