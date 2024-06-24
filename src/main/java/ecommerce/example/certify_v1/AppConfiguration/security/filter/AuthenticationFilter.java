package ecommerce.example.certify_v1.AppConfiguration.security.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import ecommerce.example.certify_v1.AppConfiguration.security.service.JwtService;
import ecommerce.example.certify_v1.dtos.requests.LoginRequest;
import ecommerce.example.certify_v1.dtos.responses.LoginResponse;
import ecommerce.example.certify_v1.exception.CertifyException;
import ecommerce.example.certify_v1.models.Student;
import ecommerce.example.certify_v1.models.User;
import ecommerce.example.certify_v1.repositories.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpRequest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwt;

    private UserDetailsService userDetailsService;



    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        ObjectMapper mapper = new ObjectMapper();

        try {
            InputStream inputStream = request.getInputStream();
            LoginRequest loginRequest = mapper.readValue(inputStream, LoginRequest.class);
            Authentication authentication = new UsernamePasswordAuthenticationToken(loginRequest.getName(), loginRequest.getPassword());
            Authentication authenticationResult = authenticationManager.authenticate(authentication);

            if (authenticationResult.isAuthenticated()){
                SecurityContextHolder.getContext().setAuthentication(authenticationResult);
                return authenticationResult;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    protected void successfulAuthentication (HttpServletRequest request,
                                           HttpServletResponse response,
                                          FilterChain chain,
                                          Authentication authResult
                                           ) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = userRepository.getByName(authResult.getName());

        if (user == null){
            try {
                throw new CertifyException("user not found");
            } catch (CertifyException e) {
                throw new RuntimeException(e);
            }
        }
//        String token =
        String token = "";
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(token);
        loginResponse.setId(user.getId());
        loginResponse.setAuthority(user.getAuthorities());
        response.setContentType(APPLICATION_JSON_VALUE);
        mapper.writeValue(response.getOutputStream(), loginResponse);


    }


    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
    }

}
