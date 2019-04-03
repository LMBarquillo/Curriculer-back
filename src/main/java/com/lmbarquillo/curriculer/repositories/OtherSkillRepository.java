package com.lmbarquillo.curriculer.repositories;

import com.lmbarquillo.curriculer.entities.OtherSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherSkillRepository extends JpaRepository<Long, OtherSkill> {
}
