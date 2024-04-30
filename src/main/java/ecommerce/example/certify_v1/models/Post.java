package ecommerce.example.certify_v1.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String userId;
    private String userName;
    private boolean isVerified;
    private String description;
    private String title;

}
