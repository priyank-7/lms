package com.lms.Controllers;


import com.lms.DTOs.AuthRequest;
import com.lms.Entities.Role;
import com.lms.Entities.User;
import com.lms.Exception.BadCredentialsException;
import com.lms.Security.JWT.JwtService;
import com.lms.Services.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    @Autowired
    public UserController(JwtService jwtService, AuthenticationManager authenticationManager, UserService userService){
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/auth")
    public String authAndGenerateToken(@RequestBody AuthRequest authRequest) throws BadCredentialsException{

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        }
        else{
            throw new BadCredentialsException("Invalid username or password");
        }
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/getRole")
    public ResponseEntity<List<Role>> getRole(){
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/setRole/{user_id}")
    public ResponseEntity<?> setRole(@PathVariable String user_id, @RequestBody Role role){
        return ResponseEntity.ok(this.userService.setUserRoles(user_id, role));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/getall")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }


}
