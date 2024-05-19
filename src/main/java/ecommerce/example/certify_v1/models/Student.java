package ecommerce.example.certify_v1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@Entity(name = "student")
@AllArgsConstructor
@NoArgsConstructor
public class Student  extends User{

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private String id;
//    private String name;
//    private String email;
    private String phoneNumber;
    private String nin;
//    private List<Authority> authorities;



}
