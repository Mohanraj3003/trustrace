package com.trustrace.RedditCloneApp.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtTokenVerifier extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

            String authorizationHeader = request.getHeader("Authorization");

            try {
                if(authorizationHeader.isEmpty() || ! authorizationHeader.startsWith("Bearer "))
                {
                    filterChain.doFilter(request,response);
                }
            }catch (NullPointerException e){
                throw  new  NullPointerException("Authorization token required");
            }






            String token = authorizationHeader.replace("Bearer","");

            try {

                Jws<Claims> claimsJws = Jwts.parser()
                        .setSigningKey("SecretSecretSecretSecretSecretSecretSecretSecretSecretSecret")
                        .parseClaimsJws(token);

                Claims body = claimsJws.getBody();

                String username = body.getSubject();

                var authorities = (List<Map<String, String>>) body.get("Authorities");

                Set<SimpleGrantedAuthority> simpleGrantedAuthorities = authorities.stream()
                        .map(m -> new SimpleGrantedAuthority(m.get("authority")))
                        .collect(Collectors.toSet());

                Authentication authentication = new UsernamePasswordAuthenticationToken(
                        username,
                        null,
                        simpleGrantedAuthorities
                );

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }catch (JwtException e) {
                throw new IllegalStateException(String.format("Token %s cannot be trusted or Expired", token));
            }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

        String currentRequestURI =  request.getRequestURI();

//        System.out.println("-------------------->>"+currentRequestURI+"--------------");
        boolean filterAndAllowApiUrls = Arrays
                .asList("/api/auth","/api/auth/confirm")
                .contains(currentRequestURI);

        return filterAndAllowApiUrls ;
    }
}
