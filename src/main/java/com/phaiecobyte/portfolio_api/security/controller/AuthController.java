package com.phaiecobyte.portfolio_api.security.controller;

import com.phaiecobyte.portfolio_api.common.ApiResponse;
import com.phaiecobyte.portfolio_api.security.dto.req.LoginReq;
import com.phaiecobyte.portfolio_api.security.dto.req.SignupReq;
import com.phaiecobyte.portfolio_api.security.jwt.JwtService;
import com.phaiecobyte.portfolio_api.security.service.CustomUserDetailsService;
import com.phaiecobyte.portfolio_api.security.service.SignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtService jwtService;
    private final SignupService signupService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginReq req){

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(),req.getPassword()));

        UserDetails user = customUserDetailsService.loadUserByUsername(req.getUsername());

        String jwtToken = jwtService.generateToken(user);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of(
                        "status",true,
                        "message","Login successfully...!",
                        "access_token",jwtToken
                ));
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@Valid @RequestBody SignupReq req){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.apiSuccessRes(true,"Signup successfully...!",signupService.signUp(req)));
    }
}
