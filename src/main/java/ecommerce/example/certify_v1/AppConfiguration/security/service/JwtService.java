package ecommerce.example.certify_v1.AppConfiguration.security.service;

import com.auth0.jwt.JWT;
import ecommerce.example.certify_v1.models.Authority;
import ecommerce.example.certify_v1.models.School;
import ecommerce.example.certify_v1.models.Student;
import ecommerce.example.certify_v1.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import java.util.stream.Collectors;

import static java.lang.Math.log;

@Slf4j
@Component
public class JwtService {



    public String generateTokenForStudent(Student user){
          List<String> authorities = user.getAuthorities()
                  .stream()
                  .map(Authority:: name)
                  .collect(Collectors.toList());
          String token = JWT.create()
                  .withIssuedAt(Instant.now())
                  .withExpiresAt(Instant.now().plus(86400L, ChronoUnit.SECONDS))
                  .withIssuer("certify")
                  .withSubject(user.getEmail())
                  .withClaim("claims",authorities)
                  .sign(Algorithm.HMAC256("secret"));
          log.info("created token for student: ", token);
        return token;
    }


    public String generateTokenForSchool(School  school){

        List<String> authorities = school.getAuthorities()
                .stream()
                .map(Authority:: name)
                .collect(Collectors.toList());
        String token = JWT.create()
                .withIssuedAt(Instant.now())
                .withExpiresAt(Instant.now().plus(86400L, ChronoUnit.SECONDS))
                .withIssuer("certify")
                .withSubject(school.getEmail())
                .withClaim("claims", authorities)
                .sign(Algorithm.HMAC256("secret"));

        log.info("generated token for school: ", token);

        return token;


    }


    public String extractUsernameFromToken(String token ) {
        JWTVerifier verifier =JWT.require(Algorithm.HMAC256("secret"))
                .withIssuer("certify")
                .build();
        DecodedJWT decodedJWT = verifier.verify(token);
        log.info("decoded: ", decodedJWT);
        return decodedJWT.getSubject();

    }
}
