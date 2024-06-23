package ecommerce.example.certify_v1.mapper;

import ecommerce.example.certify_v1.dtos.requests.CreateStudentRequest;
import ecommerce.example.certify_v1.dtos.responses.CreateUserResponse;
import ecommerce.example.certify_v1.models.Authority;
import ecommerce.example.certify_v1.models.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapper {



    public Student mapper(CreateStudentRequest request, String password){
        Student student = new Student();
        student.setAuthorities(List.of(Authority.STUDENT));
        student.setNin(request.getNin());
        student.setEmail(request.getEmail());
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setPhoneNumber(request.getPhoneNumber());
        student.setPassword(password);
        return student;
    }
    public CreateUserResponse mapper(String token, String id, String message){
        CreateUserResponse userResponse = new CreateUserResponse();
        userResponse.setId(id);
        userResponse.setToken(token);
        userResponse.setMessage(message);
        return userResponse;
    }
}
