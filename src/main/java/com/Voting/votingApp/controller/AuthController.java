package com.Voting.votingApp.controller;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Voting.votingApp.Security.JwtAuthRequest;
import com.Voting.votingApp.Security.JwtAuthResponse;
import com.Voting.votingApp.Security.JwtTokenHelper;
import com.Voting.votingApp.Entity.Admin;
import com.Voting.votingApp.Entity.Users;

@RestController
@CrossOrigin("http://localhost:5173/")  // Adjust frontend URL accordingly
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody JwtAuthRequest request) {

        // Perform authentication
        this.doAuthenticate(request.getEmail(), request.getPassword());

        // Load user details from the email provided
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

        Integer id = null;
        String name = null;
        List<String> roles = null;

        if (userDetails instanceof Admin) {
            Admin admin = (Admin) userDetails;
            id = admin.getId();
            name = admin.getName();
            roles = admin.getAdminrole().stream()
                    .map(role -> role.getName())
                    .collect(Collectors.toList());
        } else if (userDetails instanceof Users) {
            Users user = (Users) userDetails;
            id = user.getId();
            name = user.getName();
            roles = user.getUserrole().stream()
                    .map(role -> role.getName())
                    .collect(Collectors.toList());
        }

        // Generate JWT token
        String token = jwtTokenHelper.generateToken(userDetails);

        // Prepare response with token and user details
        JwtAuthResponse response = new JwtAuthResponse(
                token,
                userDetails.getUsername(),  // Username (email)
                userDetails.getUsername(),  // Email
                name,
                id,
                roles
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            authenticationManager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid Username or Password !!");
        }
    }

    // Handle BadCredentialsException globally
    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }
}
