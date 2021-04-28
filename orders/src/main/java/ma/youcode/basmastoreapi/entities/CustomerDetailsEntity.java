package ma.youcode.basmastoreapi.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "customer_details")
public class CustomerDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer_details", nullable = false, updatable = false)
    private Long idCustomerDetails;
    @NotNull
    private String gender;
    @NotNull
    private String phone;
    @NotNull
    private String address;
    @NotNull
    private String city;
    @Column(nullable = false)
    private String country;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;

    @OneToMany(mappedBy = "customerDetails")
    private List<ShoppingCartEntity> shoppingCarts;

    public CustomerDetailsEntity() {
    }

    public CustomerDetailsEntity(String gender, String phone, String address, String city, String country) {
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.country = country;
    }

    public CustomerDetailsEntity(Long idCustomerDetails, String gender, String phone, String address, String city, String country) {
        this.idCustomerDetails = idCustomerDetails;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.country = country;
    }

    public CustomerDetailsEntity(String gender, String phone, String address, String city, String country, UserEntity user, List<ShoppingCartEntity> shoppingCarts) {
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.country = country;
        this.user = user;
        this.shoppingCarts = shoppingCarts;
    }

    public CustomerDetailsEntity(Long idCustomerDetails, String gender, String phone, String address, String city, String country, UserEntity user, List<ShoppingCartEntity> shoppingCarts) {
        this.idCustomerDetails = idCustomerDetails;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.country = country;
        this.user = user;
        this.shoppingCarts = shoppingCarts;
    }

    public Long getIdCustomerDetails() {
        return idCustomerDetails;
    }

    public void setIdCustomerDetails(Long idCustomerDetails) {
        this.idCustomerDetails = idCustomerDetails;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<ShoppingCartEntity> getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(List<ShoppingCartEntity> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }
}
