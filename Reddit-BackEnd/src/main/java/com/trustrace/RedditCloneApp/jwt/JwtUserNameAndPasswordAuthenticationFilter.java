package com.trustrace.RedditCloneApp.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trustrace.RedditCloneApp.dto.AuthenticationRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class JwtUserNameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private final AuthenticationManager authenticationManager;



    public JwtUserNameAndPasswordAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try{
            AuthenticationRequest usernameAndPasswordAuthenticationRequest= new ObjectMapper()
                    .readValue(request.getInputStream(), AuthenticationRequest.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    usernameAndPasswordAuthenticationRequest.getUserName(),
                    (usernameAndPasswordAuthenticationRequest.getPassword())

            ));

        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("Authorities",authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, "SecretSecretSecretSecretSecretSecretSecretSecretSecretSecret")
                .compact();

        response.addHeader("Authorization","Bearer "+ token);
    }
}
