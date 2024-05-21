package ecommerce.example.certify_v1.dtos.responses;

import java.util.List;

import ecommerce.example.certify_v1.models.Authority;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponse {

    private String id;
    private List<Authority> authority;
    private String token;
}
