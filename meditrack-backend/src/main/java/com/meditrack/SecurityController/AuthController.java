package com.meditrack.SecurityController;

import com.meditrack.SecurityService.AuthService;
import com.meditrack.dto.ApiResponse;
import com.meditrack.dto.LoginRequest;
import com.meditrack.dto.RegisterRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")  // update to your Vercel domain in production
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * POST /api/auth/register
     * Body: { name, email, password, role }
     * Roles accepted: PATIENT, DOCTOR, ADMIN
     */
    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegisterRequest request) {
    	System.err.println("register api hitted 1");
        ApiResponse response = authService.register(request);
        int status = response.isSuccess() ? 201 : 400;
        return ResponseEntity.status(status).body(response);
    }

    /**
     * POST /api/auth/login
     * Body: { email, password }
     * Returns: { token, role, userId, name }
     */
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest request) {
        ApiResponse response = authService.login(request);
        int status = response.isSuccess() ? 200 : 401;
        return ResponseEntity.status(status).body(response);
    }
}