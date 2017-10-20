package com.liveasy.facebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Service;

import com.liveasy.model.User;
import com.liveasy.repository.UserRepository;

@Service
public class FacebookConnectionSignUp implements ConnectionSignUp {
 
    @Autowired
    private UserRepository userRepository;
 
    @Override
    public String execute(Connection<?> connection) {
        User user = new User();
        
        Facebook facebook = (Facebook) connection.getApi();
        
        user.setName(facebook.userOperations().getUserProfile().getFirstName());
        user.setLastName(facebook.userOperations().getUserProfile().getLastName());
        user.setPassword("FDJSIOFJSDIOFHJSDIO");
        
        userRepository.save(user);
        return user.getName();
    }
}


