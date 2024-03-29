package com.example.cardatabase.web;

import com.example.cardatabase.domain.AccountCredentials;
import com.example.cardatabase.service.JwtService;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class LogInController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<?> getToken(@RequestBody AccountCredentials accountCredentials){
        UsernamePasswordAuthenticationToken creds =
                new UsernamePasswordAuthenticationToken(
                                accountCredentials.getUsername(),
                                accountCredentials.getPassword());

        Authentication auth = authenticationManager.authenticate(creds);
        String jwts = jwtService.getToken(auth.getName());

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION,"Bearer "+ jwts)
                .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS,"Authorization")
                .build();

    }
}
