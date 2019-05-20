package com.lmbarquillo.curriculer.repositories;

import com.lmbarquillo.curriculer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserAndPassword(String user, String pass);

    Optional<User> findByUser(String user);

    @Query(value = "SELECT * FROM user WHERE user = :user AND SHA2(password, 512) = :pass",
            nativeQuery = true)
    User checkUser(@Param("user") String user, @Param("pass") String password);

    Boolean existsUserByEmail(String email);

    Boolean existsUserByUser(String username);
}
