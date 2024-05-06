package ecommerce.example.certify_v1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {

    @Id
    private String id;
    private String email;
    private String phoneNumber;
    private String password;
}

