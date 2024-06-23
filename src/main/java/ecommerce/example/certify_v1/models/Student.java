package ecommerce.example.certify_v1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Setter
@Getter

@Entity(name = "student")
@AllArgsConstructor
@NoArgsConstructor
public class Student  extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String nin;
    private List<Authority> authorities;



}
