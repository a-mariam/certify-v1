package ecommerce.example.certify_v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ecommerce.example.certify_v1.models.School;

public interface SchoolRepository extends JpaRepository<School, String> {
}
