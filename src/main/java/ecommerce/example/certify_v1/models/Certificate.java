package ecommerce.example.certify_v1.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Setter
@Getter
@Entity
public class Certificate {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String userId;
    private String universityId;
    private String title;
    private String description;
    @ElementCollection
    private List<String> files;
}
