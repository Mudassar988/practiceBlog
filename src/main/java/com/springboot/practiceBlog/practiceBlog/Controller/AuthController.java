/*
package com.springboot.practiceBlog.practiceBlog.Controller;

import com.springboot.practiceBlog.practiceBlog.Dto_Payload.JWTAuthResponse;
import com.springboot.practiceBlog.practiceBlog.Dto_Payload.Login_Dto;
import com.springboot.practiceBlog.practiceBlog.Security.JwtTokenProvider;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    //login
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private  JwtTokenProvider loginTokenProvider;


    @PostMapping("api/login")
    public ResponseEntity<JWTAuthResponse> authenticatelogin(@RequestBody @NotNull Login_Dto loginDto) {

        // generating token for given
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        //get token from token provider
        String token = loginTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JWTAuthResponse(token));
    }
}
*/
