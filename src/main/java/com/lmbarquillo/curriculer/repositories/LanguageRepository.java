package com.lmbarquillo.curriculer.repositories;

import com.lmbarquillo.curriculer.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

}
