package ecommerce.example.certify_v1.service;
import ecommerce.example.certify_v1.AppConfiguration.security.service.JwtService;
import ecommerce.example.certify_v1.Validators.ValidateStudentRequest;
import ecommerce.example.certify_v1.dtos.requests.CreateStudentRequest;
import ecommerce.example.certify_v1.dtos.responses.CreateUserResponse;
import ecommerce.example.certify_v1.exception.InvalidDetailsException;
import ecommerce.example.certify_v1.exception.UserAlreadyExist;
import ecommerce.example.certify_v1.mapper.Mapper;
import ecommerce.example.certify_v1.models.Student;
import ecommerce.example.certify_v1.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CertifySignUpService implements SignUpService {

    private ValidateStudentRequest studentValidator;
    private final PasswordEncoder passwordEncoder;
    private Mapper mapper;
    private StudentRepository studentRepository;
    private JwtService jwt;


    @Override
    public CreateUserResponse createStudent(CreateStudentRequest request) throws UserAlreadyExist, InvalidDetailsException {
        studentValidator.validate(request);
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        Student student = mapper.mapper(request, encodedPassword);
        Student savedStudent =  studentRepository.save(student);
        String token = jwt.generateTokenForStudent(savedStudent);
        return mapper.mapper(token, savedStudent.getId(), "student created successfully");
    }
}
