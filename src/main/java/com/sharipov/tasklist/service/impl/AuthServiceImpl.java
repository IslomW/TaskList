package com.sharipov.tasklist.service.impl;

import com.sharipov.tasklist.domain.user.User;
import com.sharipov.tasklist.service.AuthService;
import com.sharipov.tasklist.service.UserService;
import com.sharipov.tasklist.web.dto.auth.JwtRequest;
import com.sharipov.tasklist.web.dto.auth.JwtResponse;
import com.sharipov.tasklist.web.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;//kib turganda auth qilish
    private final UserService userService;//Useri olish uchun
    private final JwtTokenProvider jwtTokenProvider;//token yengi ochish uchun

    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        JwtResponse jwtResponse = new JwtResponse();
        User user = userService.getByUserName(loginRequest.getUsername());
        jwtResponse.setId(user.getId());
        jwtResponse.setUsername(user.getUsername());
        jwtResponse.setAccessToken(jwtTokenProvider.createAccessToken(user.getId(), user.getUsername(), user.getRoles()));
        jwtResponse.setRefreshToken(jwtTokenProvider.createRefreshToken(user.getId(), user.getUsername()));
        return jwtResponse;
    }

    @Override
    public JwtResponse refresh(String refreshToken){
        return jwtTokenProvider.refreshUserTokens(refreshToken);
    }
}
