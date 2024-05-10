package ecommerce.example.certify_v1.dtos.requests;


import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
public class LoginRequest {

    @NotNull

    private String email;
    private String password;


}
