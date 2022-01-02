package com.example.logowaniespring.service;

import com.example.logowaniespring.entity.User;
import com.example.logowaniespring.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User findByLogin(String login){
        return userRepository.findByLogin(login);
    }

    public User findByEmail(String email){
        System.out.println();
        return userRepository.findByEmail(email);

    }
    /*public User userUpdate(User user){
        User existingUser = userRepository.findByLogin(user.getLogin());
        existingUser.setLogin(user.getLogin());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }*/


}
