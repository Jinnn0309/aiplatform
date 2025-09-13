package com.enterprise.aiplatform.controller;

import com.enterprise.aiplatform.model.User;
import com.enterprise.aiplatform.security.JwtTokenProvider;
import com.enterprise.aiplatform.service.UserService;
import com.enterprise.aiplatform.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        
        User user = (User) authentication.getPrincipal();
        
        Map<String, Object> response = new HashMap<>();
        response.put("token", jwt);
        response.put("user", UserResponse.fromUser(user));
        
        return ResponseEntity.ok(ApiResponse.success("登录成功", response));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        if (userService.existsByUsername(registerRequest.getUsername())) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error("用户名已存在"));
        }

        if (userService.existsByEmail(registerRequest.getEmail())) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error("邮箱已被使用"));
        }

        User user = userService.createUser(registerRequest);
        
        return ResponseEntity.ok(ApiResponse.success("注册成功", UserResponse.fromUser(user)));
    }
    
    // 请求和响应的内部类
    
    @lombok.Data
    public static class LoginRequest {
        private String username;
        private String password;
    }
    
    @lombok.Data
    public static class RegisterRequest {
        private String username;
        private String password;
        private String email;
        private String fullName;
        private String department;
    }
    
    @lombok.Data
    @lombok.Builder
    public static class UserResponse {
        private Long id;
        private String username;
        private String email;
        private String fullName;
        private String department;
        private String position;
        private String avatar;
        
        public static UserResponse fromUser(User user) {
            return UserResponse.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .fullName(user.getFullName())
                    .department(user.getDepartment())
                    .position(user.getPosition())
                    .avatar(user.getAvatar())
                    .build();
        }
    }
}