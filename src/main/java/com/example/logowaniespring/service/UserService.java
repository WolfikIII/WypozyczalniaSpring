package com.example.logowaniespring.service;

import com.example.logowaniespring.entity.Car;
import com.example.logowaniespring.entity.User;
import com.example.logowaniespring.userRepository.CarRepository;
import com.example.logowaniespring.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CarRepository carRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User findByPassword(String password) {
        return userRepository.findByPassword(password);
    }

    public User findByEmail(String email) {
        System.out.println();
        return userRepository.findByEmail(email);

    }

    public User findUser(String login, String password) {
        return userRepository.findUser(login, password);
    }

    public Car getCarByIsAvailable(boolean isAvailable) {
        return carRepository.getCarByIsAvailable(isAvailable);
    }
    public List<Car> getCarList() {
        List<Car> getCarByisAvailable = carRepository.findAll();
        return getCarByisAvailable;
    }
}




