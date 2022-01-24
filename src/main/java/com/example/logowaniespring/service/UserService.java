package com.example.logowaniespring.service;

import com.example.logowaniespring.entity.User;
import com.example.logowaniespring.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class UserService {
    Scanner scanner = new Scanner(System.in);
    @Autowired
    private UserRepository userRepository;
    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User findByLogin(String login){
        return userRepository.findByLogin(login);
    }
    public User findByPassword(String password){
        return userRepository.findByPassword(password);
    }
    public User findByEmail(String email){
        System.out.println();
        return userRepository.findByEmail(email);

    }
    public User findUser (String login, String password){return userRepository.findUser(login, password);}




}
