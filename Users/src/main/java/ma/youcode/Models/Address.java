package ma.youcode.Models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Adress")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Address_id")
    private Long address_id;
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
    private Users user;


    public Address() {
    }

    public Address(Long address_id, String gender, String phone, String address, String city, String country, Users user) {
        this.address_id = address_id;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.country = country;
        this.user = user;
    }

    public Address(String gender, String phone, String address, String city, String country, Users user) {
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.country = country;
        this.user = user;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long idCustomerDetails) {
        this.address_id = idCustomerDetails;
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
