package com.sharipov.tasklist.web.security;

import com.sharipov.tasklist.domain.exeption.ResourceMappingException;
import com.sharipov.tasklist.domain.exeption.ResourceNotFoundException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@AllArgsConstructor
public class JwtTokenFilter extends GenericFilterBean {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @SneakyThrows
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        String bearerToken = ((HttpServletRequest) servletRequest).getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            bearerToken = bearerToken.substring(7);
        }
        try {
        if (bearerToken != null && jwtTokenProvider.isValid(bearerToken)){
            Authentication authentication = jwtTokenProvider.getAuthentication(bearerToken);
            if (authentication != null){
                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
            }
        }
        }catch (Exception ignored){
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
