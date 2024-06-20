package ecommerce.example.certify_v1.exception;

public class UserAlreadyExist extends CertifyException{
    public UserAlreadyExist(String message) {
        super(message);
    }
}
