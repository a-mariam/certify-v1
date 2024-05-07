package ecommerce.example.certify_v1.repositories;

import ecommerce.example.certify_v1.models.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository  extends JpaRepository<Certificate, String> {
}
