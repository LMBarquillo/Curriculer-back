package com.lmbarquillo.curriculer.services;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.models.LanguageModel;

import java.util.List;

public interface LanguageService {
    List<LanguageModel> getLanguages(User user);
}
