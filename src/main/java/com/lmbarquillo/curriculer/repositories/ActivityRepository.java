package com.lmbarquillo.curriculer.repositories;

import com.lmbarquillo.curriculer.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Long, Activity> {
}
