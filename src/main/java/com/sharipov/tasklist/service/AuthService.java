package com.sharipov.tasklist.service;

import com.sharipov.tasklist.web.dto.auth.JwtRequest;
import com.sharipov.tasklist.web.dto.auth.JwtResponse;

public interface AuthService {

JwtResponse login(JwtRequest loginRequest);

JwtResponse refresh(String refreshToken);
}
