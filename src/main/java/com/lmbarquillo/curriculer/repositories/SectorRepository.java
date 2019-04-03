package com.lmbarquillo.curriculer.repositories;

import com.lmbarquillo.curriculer.entities.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends JpaRepository<Long, Sector> {
}
