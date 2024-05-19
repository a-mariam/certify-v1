package ecommerce.example.certify_v1.dtos.responses;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponse {

    private String id;
    private String authority;
    private String token;
}
