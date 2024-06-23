package ecommerce.example.certify_v1.repositories;

import ecommerce.example.certify_v1.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {

    Student findByNin(String nin);

}
