package ru.flamexander.spring.security.jwt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.flamexander.spring.security.jwt.dtos.JwtRequest;
import ru.flamexander.spring.security.jwt.dtos.RegistrationUserDto;
import ru.flamexander.spring.security.jwt.dtos.UserDto;
import ru.flamexander.spring.security.jwt.dtos.UserDtoAuth;
import ru.flamexander.spring.security.jwt.entities.User;
import ru.flamexander.spring.security.jwt.repositories.UserRepository;
import ru.flamexander.spring.security.jwt.service.AuthService;

import javax.persistence.PostUpdate;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserRepository userRepository;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        System.out.println(authRequest.getUsername());
        System.out.println(authRequest.getPassword());
        User user = userRepository.findByUsername(authRequest.getUsername()).get();

        String token = String.valueOf(authService.createAuthToken(authRequest).getBody().toString());
        System.out.println(user.getUsername()+" Вошел в систему!" );

        token = token.replace("JwtResponse(token=","");

        token = token.replace(")","");
        System.out.println(token);
        return ResponseEntity.ok(new UserDtoAuth(user.getId(),user.getUsername(),user.getEmail(),token));
    }


    @PostMapping("/registration")
    public ResponseEntity<?> createNewUser(@RequestBody RegistrationUserDto registrationUserDto) {
        return authService.createNewUser(registrationUserDto);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateNewUser(@RequestBody RegistrationUserDto request) {
        return authService.updateInfo(request);
    }
}