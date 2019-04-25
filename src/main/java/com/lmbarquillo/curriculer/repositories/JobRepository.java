package com.lmbarquillo.curriculer.repositories;

import com.lmbarquillo.curriculer.entities.Job;
import com.lmbarquillo.curriculer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    Optional<List<Job>> findAllByUser(User user);
}
