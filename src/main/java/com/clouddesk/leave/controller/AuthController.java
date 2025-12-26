package com.clouddesk.leave.controller;

import com.clouddesk.leave.dto.request.LoginRequest;
import com.clouddesk.leave.dto.request.SignUpRequest;
import com.clouddesk.leave.dto.response.AuthResponse;
import com.clouddesk.leave.dto.response.SignUpResponse;
import com.clouddesk.leave.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/token")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/signup")
    public SignUpResponse signUp(@Valid @RequestBody SignUpRequest request){
        return authService.businessSignUp(request);
    }
}
