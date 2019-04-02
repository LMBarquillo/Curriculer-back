package com.lmbarquillo.curriculer.repositories;

import com.lmbarquillo.curriculer.entities.DesiredJobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesiredJobsRepository extends JpaRepository<Long, DesiredJobs> {
}
