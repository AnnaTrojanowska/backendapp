package pl.backendapp.backendapp;

import javax.persistence.*;

@Entity
@Table(name = "users_data")

public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_users_data;

    @Column(nullable = false, length = 45)
    private String first_name;
    @Column(nullable = false, length = 45)
    private String last_name;
    @Column(nullable = false, length = 45)
    private String address;
    @Column(nullable = false, length = 45)
    private String city;
    @Column(nullable = false, length = 6)
    private String post_code;
    @Column(nullable = false, length = 9)
    private String phone;

    public Long getId_users_data() {
        return id_users_data;
    }

    public void setId_users_data(Long id_users_data) {
        this.id_users_data = id_users_data;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
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

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
