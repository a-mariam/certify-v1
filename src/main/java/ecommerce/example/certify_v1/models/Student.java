package ecommerce.example.certify_v1.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String username;
    private String email;
    private String phoneNumber;
    private String nin;
    private Authority authority;



}
