package com.trustrace.RedditCloneApp.service;

import com.trustrace.RedditCloneApp.dto.UserRequest;
import com.trustrace.RedditCloneApp.exception.AllReadyExistsException;
import com.trustrace.RedditCloneApp.exception.FieldsMissedException;
import com.trustrace.RedditCloneApp.model.User;
import com.trustrace.RedditCloneApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MailService mailService;

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

//    public User getCurrentUser() {
//        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User)
//                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return userRepository.findByUserName(principal.getUsername())
//                .orElseThrow(() -> new UsernameNotFoundException("User name not found - " + principal.getUsername()));
//    }
}
