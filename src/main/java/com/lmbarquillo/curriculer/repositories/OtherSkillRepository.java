package com.lmbarquillo.curriculer.repositories;

import com.lmbarquillo.curriculer.entities.OtherSkill;
import com.lmbarquillo.curriculer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OtherSkillRepository extends JpaRepository<OtherSkill, Long> {

    List<OtherSkill> findAllByUser(User user);

    Optional<OtherSkill> findByUserAndId(User user, Long id);
}
