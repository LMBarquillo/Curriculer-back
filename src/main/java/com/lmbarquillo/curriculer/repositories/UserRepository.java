package com.lmbarquillo.curriculer.repositories;

import com.lmbarquillo.curriculer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user WHERE user = :user AND password = PASSWORD(:pass)",
            nativeQuery = true)
    User login(@Param("user") String user, @Param("pass") String password);

    @Query(value = "SELECT * FROM user WHERE user = :user AND SHA2(password, 512) = :pass",
            nativeQuery = true)
    User checkUser(@Param("user") String user, @Param("pass") String password);


    Boolean existsUserByEmail(String email);

    Boolean existsUserByUser(String username);
}
