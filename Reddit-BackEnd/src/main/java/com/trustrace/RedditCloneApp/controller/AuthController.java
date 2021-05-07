package com.trustrace.RedditCloneApp.controller;

import com.trustrace.RedditCloneApp.dto.UserRequest;
import com.trustrace.RedditCloneApp.service.AuthService;
import com.trustrace.RedditCloneApp.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    MailService mailService;

    @PostMapping()
    public ResponseEntity<?> signUp(@RequestBody UserRequest userRequest){
        return new ResponseEntity<>(authService.signup(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("confirm")
    public ResponseEntity<?> confirmRequest(@RequestParam("token") String token) {
        return new ResponseEntity<>(mailService.confirmToken(token), HttpStatus.OK);
    }


}
