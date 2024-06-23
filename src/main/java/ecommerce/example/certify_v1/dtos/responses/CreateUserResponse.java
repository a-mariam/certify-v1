package ecommerce.example.certify_v1.dtos.responses;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserResponse {
    private String token;
    private String message;
    private String id;
}
