package ecommerce.example.certify_v1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.util.List;


@Entity(name = "user")

@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String email;
    private String name;
    private String password;
    private List<Authority> authorities;


}
