package com.trustrace.RedditCloneApp.configuration.authconfig;

import com.trustrace.RedditCloneApp.model.User;
import com.trustrace.RedditCloneApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(s);


        user.orElseThrow( () -> new UsernameNotFoundException("User Not FoundException"));

        return new MyUserDetails(user.get());
    }
}
