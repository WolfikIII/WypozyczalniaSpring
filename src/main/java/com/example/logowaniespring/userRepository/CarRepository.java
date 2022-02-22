package com.example.logowaniespring.userRepository;

import com.example.logowaniespring.entity.Car;
import com.example.logowaniespring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("SELECT u FROM Car u Where u.isAvailable=: isAvailable")
    Car getCarByIsAvailable(@Param("is_available")boolean isAvailable);


}
