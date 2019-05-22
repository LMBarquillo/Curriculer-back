package com.lmbarquillo.curriculer.models;

import com.lmbarquillo.curriculer.entities.Language;

public class LanguageModel {
    private Long id;
    private String language;
    private String code;

    public LanguageModel() {
    }

    public LanguageModel(Long id, String language, String code) {
        this.id = id;
        this.language = language;
        this.code = code;
    }

    public static LanguageModel from(Language entity) {
        return new LanguageModel(entity.getId(), entity.getLanguage(), entity.getCode());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
