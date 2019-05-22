package com.lmbarquillo.curriculer.repositories;

import com.lmbarquillo.curriculer.entities.DigitalSkill;
import com.lmbarquillo.curriculer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DigitalSkillRepository extends JpaRepository<DigitalSkill, Long> {

    Optional<DigitalSkill> findByUser_User(User user);

}
