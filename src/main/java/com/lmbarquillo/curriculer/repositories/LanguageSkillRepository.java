package com.lmbarquillo.curriculer.repositories;

import com.lmbarquillo.curriculer.entities.LanguageSkill;
import com.lmbarquillo.curriculer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LanguageSkillRepository extends JpaRepository<LanguageSkill, Long> {

    Optional<List<LanguageSkill>> findAllByPk_User(User user);

    Optional<LanguageSkill> findByPk_Language_IdAndPk_User(Long id, User user);
}
