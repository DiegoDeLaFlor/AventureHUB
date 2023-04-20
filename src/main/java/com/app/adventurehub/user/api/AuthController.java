package com.app.adventurehub.user.api;

import com.app.adventurehub.user.domain.model.entity.User;
import com.app.adventurehub.user.domain.service.AuthService;
import com.app.adventurehub.user.resource.AuthCredentialsResource;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody AuthCredentialsResource credentials) {
        return ResponseEntity.ok(authService.login(credentials));
    }

}
