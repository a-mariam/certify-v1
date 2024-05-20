package ecommerce.example.certify_v1.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Entity(name = "school")
@AllArgsConstructor
@NoArgsConstructor
public class School extends User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private String id;
//    private String name;
    private String schoolNumber;
//    private String email;
    private String CEEB;
//    private String password;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private Type type;
//    private List<Authority> authorities;


}
