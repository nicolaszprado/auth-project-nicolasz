package com.example.auth_project_nicolasz.controllers;

import com.example.auth_project_nicolasz.domain.user.User;
import com.example.auth_project_nicolasz.dto.LoginRequestDTO;
import com.example.auth_project_nicolasz.dto.responseDTO;
import com.example.auth_project_nicolasz.infra.security.TokenService;
import com.example.auth_project_nicolasz.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity login (@RequestBody LoginRequestDTO body){
        User user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(encoder.matches(body.password(), user.getPassword())){
            String token = tokenService.generateToken(user);
            return ResponseEntity.ok(new responseDTO(user.getUsername(), token));
        }
        return ResponseEntity.badRequest().build();

    }

}
