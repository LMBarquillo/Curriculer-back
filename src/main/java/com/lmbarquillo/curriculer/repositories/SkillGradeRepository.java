package com.lmbarquillo.curriculer.repositories;

import com.lmbarquillo.curriculer.entities.SkillGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillGradeRepository extends JpaRepository<SkillGrade, Long> {
}
