package pl.backendapp.backendapp;

import javax.persistence.*;

@Entity
@Table(name = "package_info")
public class Send {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPackage_info;

    @Column(nullable = false)
    private String delivery_man_id_delivery_man;

    @Column(nullable = false)
    private String users_users_details_id_users_details;

    @Column(nullable = false)
    private String getUsers_users_details_id_users_details1;


    public Long getIdPackage_info() {
        return idPackage_info;
    }

    public void setIdPackage_info(Long idPackage_info) {
        this.idPackage_info = idPackage_info;
    }

    public String getDelivery_man_id_delivery_man() {
        return delivery_man_id_delivery_man;
    }

    public void setDelivery_man_id_delivery_man(String delivery_man_id_delivery_man) {
        this.delivery_man_id_delivery_man = delivery_man_id_delivery_man;
    }

    public String getUsers_users_details_id_users_details() {
        return users_users_details_id_users_details;
    }

    public void setUsers_users_details_id_users_details(String users_users_details_id_users_details) {
        this.users_users_details_id_users_details = users_users_details_id_users_details;
    }

    public String getGetUsers_users_details_id_users_details1() {
        return getUsers_users_details_id_users_details1;
    }

    public void setGetUsers_users_details_id_users_details1(String getUsers_users_details_id_users_details1) {
        this.getUsers_users_details_id_users_details1 = getUsers_users_details_id_users_details1;
    }
}
