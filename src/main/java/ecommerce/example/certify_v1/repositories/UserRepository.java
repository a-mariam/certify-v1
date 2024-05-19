package ecommerce.example.certify_v1.repositories;

import ecommerce.example.certify_v1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, String> {

    User getBy(String name);
}
