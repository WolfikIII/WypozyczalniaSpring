package com.example.logowaniespring.userRepository;

import com.example.logowaniespring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import static org.hibernate.hql.internal.antlr.HqlTokenTypes.FROM;
import static org.hibernate.hql.internal.antlr.HqlTokenTypes.WHERE;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
    User findByEmail(String emial);
    User findByPassword(String password);
    @Query("Select u from User u WHERE u.login=:login and u.password=:password")
    User findUser(@Param("login") String login, @Param("password") String password);



}
