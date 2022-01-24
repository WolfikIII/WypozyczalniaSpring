package com.example.logowaniespring;

import com.example.logowaniespring.entity.User;
import com.example.logowaniespring.service.UserService;
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
        String yourEmail = scanner.next();
        System.out.println("Podaj nowe haslo: ");
        String newPassword = scanner.next();
        User takePass = userRepository.findByEmail(yourEmail);
        takePass.setPassword(newPassword);
        userRepository.save(takePass);
        System.out.println("Twoje haslo zostalo zmienione!");
    }
    public void signUp () {
        String login;
        String password;
        String email;
        System.out.println("Podaj login: ");
        login = scanner.next();
        System.out.println("Podaj hasło: ");
        password = scanner.next();
        System.out.println("Podaj adres email: ");
        email = scanner.next();
        User user = new User(login, password, email);
        userRepository.save(user);
    }
    public void signIn(){
        String login;
        String password;
        System.out.println("Podaj login: ");
        login = scanner.next();
        System.out.println("Podaj hasło: ");
        password = scanner.next();
        if(userRepository.findUser(login, password)!=null){
            System.out.println("Zalogowano!");
        }
        else System.out.println("Zły login lub hasło!");
    }
    @EventListener(ApplicationReadyEvent.class)
    public void run(){

        int x = 0;
        while(x!=4){
            System.out.println("Wybierz: 1-Zarejestruj 2-Zaloguj, 3-zmien haslo");
            x = scanner.nextInt();
        switch(x) {

            case 1:
                signUp();
                System.out.println("Logowanie:");
                signIn();
                break;
            case 2:
                System.out.println("Logowanie");
                signIn();
                break;
            case 3:
                changePass();
                break;

        }
        }

    }
}
