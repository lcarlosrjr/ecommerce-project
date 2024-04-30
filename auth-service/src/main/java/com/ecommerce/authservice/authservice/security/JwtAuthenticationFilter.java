package com.ecommerce.authservice.authservice.security;

import com.ecommerce.authservice.authservice.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Date;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final UserService userService;
    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.expiration.ms}")
    private long jwtExpirationMs;

    public JwtAuthenticationFilter(UserService userService) {
        this.userService = userService;
        setFilterProcessesUrl("/auth/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User principal = (User) authResult.getPrincipal();
        String token = Jwts.builder()
                .setSubject(principal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
        response.addHeader("Authorization", "Bearer " + token);
    }
}
