package com.example.blogdemo.controllers;

import com.example.blogdemo.payloads.JWTAuthRequest;
import com.example.blogdemo.payloads.JWTAuthresponse;
import com.example.blogdemo.security.JWTTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController  {

    @Autowired
    private JWTTokenHelper jwtTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<JWTAuthresponse> createToken(
            @RequestBody JWTAuthRequest request){

    this.authenticate(request.getUsername(),request.getPassword());

    UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());

    String Token = this.jwtTokenHelper.generateToken(userDetails);

    JWTAuthresponse response = new JWTAuthresponse();
    response.setToken(Token);
    return new ResponseEntity<JWTAuthresponse>(response, HttpStatus.OK);
    }

    private void authenticate(String username, String password Object password){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        try {
            this.authenticationManager.authenticate(authenticationToken);
        }catch (BadCredentialsException e){
            System.out.println("Invalid Details!!");
            try {
                throw new Exception("Invalid username or password");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        }
}
