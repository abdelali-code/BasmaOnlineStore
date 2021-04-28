package ma.youcode.basmastoreapi.entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sub_category")
public class SubCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sub_category", nullable = false, updatable = false)
    private Integer idSubCategory;
    @NotNull
    @Column(unique = true)
    private String name;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity category;


    public SubCategoryEntity() {
    }

    public SubCategoryEntity(String name, CategoryEntity category) {
        this.name = name;
        this.category = category;
    }

    public SubCategoryEntity(Integer idSubCategory, String name, CategoryEntity category) {
        this.idSubCategory = idSubCategory;
        this.name = name;
        this.category = category;
    }

    public Integer getIdSubCategory() {
        return idSubCategory;
    }

    public void setIdSubCategory(Integer idSubCategory) {
        this.idSubCategory = idSubCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
