package com.lmbarquillo.curriculer.repositories;

import com.lmbarquillo.curriculer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Long, User> {

    @Query(value = "SELECT * FROM users WHERE user = :user AND password = PASSWORD(:pass)",
            nativeQuery = true)
    User login(@Param("user") String user, @Param("pass") String password);
}
