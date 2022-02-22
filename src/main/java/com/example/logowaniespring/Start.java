package com.example.logowaniespring;

import com.example.logowaniespring.entity.Car;
import com.example.logowaniespring.entity.User;
import com.example.logowaniespring.service.UserService;
import com.example.logowaniespring.userRepository.CarRepository;
import com.example.logowaniespring.userRepository.UserRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Start {
    List <Car> carList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    private UserRepository userRepository;

    @Autowired
    public Start(UserRepository userRepository, CarRepository carRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    private CarRepository carRepository;


    public void addCars() {
        int iter = 0;
        long id = carRepository.count() + 1;
        for (int i = 0; i < id; i++) {
            iter++;
        }
        System.out.println("Podaj marke:");
        String mark = scanner.next();
        System.out.println("Podaj model:");
        String model = scanner.next();
        System.out.println("Podaj rok produkcji:");
        int productionYear = scanner.nextInt();
        System.out.println("Podaj cene");
        double price = scanner.nextDouble();
        boolean isAvailable = true;
        Car car = new Car(iter + 1, mark, model, productionYear, price, isAvailable);
        carRepository.save(car);
        carList.add(car);
    }

    public void displayCars() {
        for (Car car:carList) {
            car.displayCarList();
        }
        //carRepository.findAll().toString();

        /*boolean isAvailable = true;
        Gson gson = new Gson();
        Car car;
        long allCars = carRepository.count();
        //if(carRepository.getCarByIsAvailable(isAvailable))


        for (int i = 0; i < allCars; i++) {
            String carDisp = gson.toJson(carRepository.findById(i + 1));
            System.out.println(carDisp.toString() + "\n");*/

        /*List<Car> getAvailableCar = carRepository.getCarByIsAvailable(true);
        getAvailableCar.forEach(e->{
            System.out.println(e);
        });*/
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
                System.out.println("Rejestracja");
                signUp();
                System.out.println("Logowanie:");
                signIn();
                System.out.println("Wybierz samochod");
                displayCars();
                x=4;
                break;
            case 2:
                System.out.println("Logowanie");
                signIn();
                //System.out.println("Wybierz samochod");
                //displayCars();
                System.out.println("Dodaj auto");
                addCars();
                displayCars();
                x=4;
                break;
            case 3:
                changePass();
                x=4;
                break;

        }
        }

    }
}
