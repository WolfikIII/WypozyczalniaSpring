package com.example.logowaniespring;

import com.example.logowaniespring.entity.User;
import com.example.logowaniespring.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Start {
    Scanner scanner = new Scanner(System.in);
    private UserRepository userRepository;
    @Autowired
    public Start(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public void changePass(){
        System.out.println("Email: ");
        String youremail = scanner.next();
        System.out.println("Podaj nowe haslo: ");
        String newpassword = scanner.next();
        User takePass = userRepository.findByEmail(youremail);
        takePass.setPassword(newpassword);
        userRepository.save(takePass);
        System.out.println("Twoje haslo zostalo zmienione!");
    }
    @EventListener(ApplicationReadyEvent.class)
    public void run(){

       // System.out.println("Login: ");
        //String log = scanner.next();
        //System.out.println("Password: ");
        //String pass = scanner.next();


       //User user = new User(log, pass, mail);
       //userRepository.save(user);
        //System.out.println("dodano!");
       //userRepository.findByLogin(log);
       // System.out.println("znaleziono!");
        //userRepository.userUpdate(user);
        changePass();

    }
}
