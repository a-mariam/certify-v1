package ecommerce.example.certify_v1.repositories;

import ecommerce.example.certify_v1.models.profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProfileRepository extends JpaRepository<profile, String> {



}
