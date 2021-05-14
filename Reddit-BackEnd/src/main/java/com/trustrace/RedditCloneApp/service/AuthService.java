package com.trustrace.RedditCloneApp.service;

import com.trustrace.RedditCloneApp.dto.AuthenticationResponse;
import com.trustrace.RedditCloneApp.dto.LoginRequest;
import com.trustrace.RedditCloneApp.dto.UserRequest;
import com.trustrace.RedditCloneApp.exception.AllReadyExistsException;
import com.trustrace.RedditCloneApp.exception.FieldsMissedException;
import com.trustrace.RedditCloneApp.jwt.JwtUserNameAndPasswordAuthenticationFilter;
import com.trustrace.RedditCloneApp.model.User;
import com.trustrace.RedditCloneApp.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MailService mailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    public User signup(UserRequest user) {

        if (user.getUserName().isEmpty() || user.getName().isEmpty() || user.getMail().isEmpty() || user.getPassword().isEmpty()) {
            throw new FieldsMissedException("Please fill all the fields..");
        }else if(userRepository.existsById(user.getUserName())){
            throw new AllReadyExistsException("UserName: "+user.getUserName()+" is already exists ");
        } else if(userRepository.existsByMail(user.getMail())){
            throw new AllReadyExistsException("Mailid : "+user.getMail()+" is already exists ");
        }

        User userModel = new User(user.getUserName(),user.getName(),bCryptPasswordEncoder.encode(user.getPassword()),user.getMail(), Instant.now());

        mailService.generateToken(userModel);

        return userRepository.save(userModel);

    }

    public String enableUser(User user) {
        if(userRepository.findById(user.getUserName()).get().isEnabled()){
            throw new IllegalStateException("email already confirmed");
        }

        user.setEnabled(true);
        userRepository.save(user);
        return "confirmed";
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {

        Authentication a;

        try{
            a = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequest.getUserName(),
                    loginRequest.getPassword()
            ));
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }



        String token = Jwts.builder()
                .setSubject(a.getName())
                .claim("Authorities",a.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, "SecretSecretSecretSecretSecretSecretSecretSecretSecretSecret")
                .compact();

        return new AuthenticationResponse(token, loginRequest.getUserName());
    }


    public User getCurrentUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUserName(principal.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User name not found - " + principal.getUsername()));
    }
}
