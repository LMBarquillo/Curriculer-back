package com.lmbarquillo.curriculer.repositories;

import com.lmbarquillo.curriculer.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Long, Users> {
}
