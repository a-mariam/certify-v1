package ecommerce.example.certify_v1.service;


import ecommerce.example.certify_v1.dtos.requests.CreateStudentRequest;
import ecommerce.example.certify_v1.dtos.responses.CreateUserResponse;
import ecommerce.example.certify_v1.exception.InvalidDetailsException;
import ecommerce.example.certify_v1.exception.UserAlreadyExist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SignUpServiceTest {
    @Autowired
    private SignUpService signUpService;


    @Test
    public void testThatStudentCanRegister() throws InvalidDetailsException, UserAlreadyExist {
        CreateStudentRequest userRequest = new CreateStudentRequest();
        userRequest.setEmail("mariiam@gmail.com");
        userRequest.setNin("283938793723");
        userRequest.setFirstName("Habibi");
        userRequest.setLastName("Muni");
        CreateUserResponse response = signUpService.createStudent(userRequest);
        assertNotNull(response.getMessage());
        assertNotNull(response.getToken());


    }



}
