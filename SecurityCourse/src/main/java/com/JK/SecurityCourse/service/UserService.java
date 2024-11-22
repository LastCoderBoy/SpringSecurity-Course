package com.JK.SecurityCourse.service;

import com.JK.SecurityCourse.models.Users;
import com.JK.SecurityCourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JWTService jwtService;

    @Autowired
    public UserService(UserRepository repository, BCryptPasswordEncoder encoder, AuthenticationManager authManager, JWTService jwtService) {
        this.repository = repository;
        this.encoder = encoder;
        this.authManager = authManager;
        this.jwtService = jwtService;
    }

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public String verify(Users user) {
        Authentication authentication =
                authManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }
        return "fail";
    }
}
