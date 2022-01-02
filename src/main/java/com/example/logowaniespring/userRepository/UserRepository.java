package com.example.logowaniespring.userRepository;

import com.example.logowaniespring.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByLogin(String login);
    User findByEmail(String emial);
    //User userUpdate(User user);

}
