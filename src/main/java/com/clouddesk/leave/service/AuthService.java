package com.clouddesk.leave.service;

import com.clouddesk.leave.domain.UserRole;
import com.clouddesk.leave.dto.request.LoginRequest;
import com.clouddesk.leave.dto.request.SignUpRequest;
import com.clouddesk.leave.dto.response.AuthResponse;
import com.clouddesk.leave.dto.response.SignUpResponse;
import com.clouddesk.leave.model.Tenant;
import com.clouddesk.leave.model.User;
import com.clouddesk.leave.repository.UserRepository;
import com.clouddesk.leave.security.jwt.JwtService;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepo, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse login(LoginRequest req) {
        User user = userRepo.findByEmail(req.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));

        if (!user.isActive()) throw new AccountExpiredException("Account disabled");
        if (!passwordEncoder.matches(req.getPassword(), user.getPassword()))
            throw new UsernameNotFoundException("Invalid credentials");

        String token = jwtService.generateToken(
                user.getId(),
                user.getTenant().getId(),
                user.getRole().name(),
                user.getEmail()
        );

        AuthResponse res = new AuthResponse();
        res.setAccessToken(token);
        res.setFirstName(user.getFirstName());
        res.setLastName(user.getLastName());
        res.setTenantName(user.getTenant().getName());
        res.setUserId(user.getId());
        res.setTenantId(user.getTenant().getId());
        res.setRole(user.getRole().name());
        return res;
    }

    @Transactional
    public SignUpResponse businessSignUp(SignUpRequest req) {

        if (userRepo.existsByEmail(req.getEmail())) {
            throw new EntityExistsException("Email already registered");
        }

        User user = new User();
            user.setEmail(req.getEmail());
            user.setPassword(passwordEncoder.encode(req.getPassword()));
            user.setFirstName(req.getFirstName());
            user.setLastName(req.getLastName());
            user.setRole(UserRole.ADMIN);

            Tenant tenant = new Tenant();
            tenant.setEnable(true);
            tenant.setName(req.getBusinessName());
            user.setTenant(tenant);

            this.userRepo.save(user);

            return new SignUpResponse(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getTenant().getId(),
                    user.getTenant().getName()
            );
    }
}
