package ecommerce.example.certify_v1.service;

import ecommerce.example.certify_v1.dtos.requests.CreateUserRequest;
import ecommerce.example.certify_v1.dtos.responses.CreateUserResponse;
import ecommerce.example.certify_v1.exception.UserAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface SignUpService {

    CreateUserResponse createUser(CreateUserRequest request)throws UserAlreadyExist;


}
