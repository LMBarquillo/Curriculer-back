package com.lmbarquillo.curriculer.repositories;

import com.lmbarquillo.curriculer.entities.DesiredJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesiredJobRepository extends JpaRepository<Long, DesiredJob> {
}
