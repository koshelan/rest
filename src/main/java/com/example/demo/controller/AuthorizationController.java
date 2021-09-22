package com.example.demo.controller;

import com.example.demo.exception.InvalidCredentials;
import com.example.demo.model.Authorities;
import com.example.demo.model.User;
import com.example.demo.model.UserArgument;
import com.example.demo.service.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class AuthorizationController {

    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid @UserArgument User user) {
        return service.getAuthorities(user);
    }

    public ResponseEntity<String> handleICE(InvalidCredentials e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
    }

}
