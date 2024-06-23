package ecommerce.example.certify_v1.Validators;

import ecommerce.example.certify_v1.dtos.requests.CreateStudentRequest;
import ecommerce.example.certify_v1.exception.InvalidDetailsException;
import ecommerce.example.certify_v1.exception.UserAlreadyExist;
import ecommerce.example.certify_v1.models.Student;
import ecommerce.example.certify_v1.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ValidateStudentRequest {
    private StudentRepository studentRepository;


    public void validate(CreateStudentRequest request) throws UserAlreadyExist, InvalidDetailsException {
        Student foundStudent = studentRepository.findByNin(request.getNin());
        if (foundStudent != null) throw new UserAlreadyExist("User with this nin already exist ");
        checkPhoneNumber(request.getPhoneNumber());

    }
    private void checkPhoneNumber(String phoneNumber) throws InvalidDetailsException {
      if(phoneNumber.length() > 11 || phoneNumber.length() < 11 )throw new InvalidDetailsException("phone number entered is incorrect");
    }


}
