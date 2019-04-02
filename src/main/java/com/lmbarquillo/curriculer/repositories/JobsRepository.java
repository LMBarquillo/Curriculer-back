package com.lmbarquillo.curriculer.repositories;

import com.lmbarquillo.curriculer.entities.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Long, Jobs> {
}
