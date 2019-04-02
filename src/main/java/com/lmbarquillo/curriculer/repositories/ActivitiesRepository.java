package com.lmbarquillo.curriculer.repositories;

import com.lmbarquillo.curriculer.entities.Activities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivitiesRepository extends JpaRepository<Long, Activities> {
}
