package ecommerce.example.certify_v1.dtos.requests;


import lombok.Getter;
import lombok.Setter;

//@Builder
@Setter
@Getter
public class CreateStudentRequest {

    private String firstName;
    private String lastName;
    private String nin;
    private String email;
    private String password;
    private String phoneNumber;

}
