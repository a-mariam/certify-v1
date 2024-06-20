package ecommerce.example.certify_v1.service;
import ecommerce.example.certify_v1.dtos.requests.CreateUserRequest;
import ecommerce.example.certify_v1.dtos.responses.CreateUserResponse;
import ecommerce.example.certify_v1.exception.UserAlreadyExist;
import ecommerce.example.certify_v1.service.SignUpService;
import org.springframework.stereotype.Service;

@Service
public class CertifySignUpService implements SignUpService {


    @Override
    public CreateUserResponse createUser(CreateUserRequest request) throws UserAlreadyExist {

        return null;
    }
}
