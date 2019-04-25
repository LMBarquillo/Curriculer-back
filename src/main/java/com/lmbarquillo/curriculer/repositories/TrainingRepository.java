package com.lmbarquillo.curriculer.repositories;

import com.lmbarquillo.curriculer.entities.Training;
import com.lmbarquillo.curriculer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    Optional<List<Training>> getAllByUser(User user);

    Optional<Training> findByIdAndUser(Long id, User user);
}
