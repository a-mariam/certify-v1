package ecommerce.example.certify_v1.service;

import ecommerce.example.certify_v1.dtos.requests.CreateStudentRequest;
import ecommerce.example.certify_v1.dtos.responses.CreateUserResponse;
import ecommerce.example.certify_v1.exception.InvalidDetailsException;
import ecommerce.example.certify_v1.exception.UserAlreadyExist;
import org.springframework.stereotype.Service;

@Service
public interface SignUpService {

    CreateUserResponse createStudent(CreateStudentRequest request) throws UserAlreadyExist, InvalidDetailsException;


}
