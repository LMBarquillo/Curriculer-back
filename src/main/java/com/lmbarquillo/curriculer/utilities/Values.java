package com.lmbarquillo.curriculer.utilities;

public class Values {
    public static class Strings {
        public static final String HEADER_AUTH = "Authorization";
        public static final String ATTRIBUTE_USER = "user";
        public static final String SPLIT_AUTH = "\\|";
    }

    public static class Errors {
        public static final String NO_AUTHORIZATION = "Petición de: %s - Sin autenticación";
        public static final String UNAUTHORIZED = "Petición de: %s - Autenticación incorrecta";
        public static final String INVALID_USER = "Usuario o contraseña incorrectos";
        public static final String DUPLICATED_EMAIL = "Ya existe un usuario con el email introducido";
        public static final String DUPLICATED_USER = "El nombre de usuario introducido ya existe. Por favor, elija otro";
        public static final String TRAINING_NOT_FOUND = "Estudios no encontrados";
        public static final String SECTOR_NOT_FOUND = "Sector de actividad no encontrado";
        public static final String USER_NOT_FOUND = "Usuario inexistente";
        public static final String JOB_NOT_FOUND = "Experiencia laboral no encontrada";
        public static final String LANGUAGE_NOT_FOUND = "Idioma no encontrado";
        public static final String GRADE_NOT_FOUND = "Nivel de dominio no encontrado";
        public static final String LANGUAGE_SKILL_NOT_FOUND = "Conocimiento de idioma no encontrado";
        public static final String DUPLICATED_LANGUAGE = "El idioma que intenta insertar ya se encuentra en su lista";
    }

    public static class Info {
        public static final String USER_AUTHORIZED = "Petición de usuario autorizado: %s";
        public static final String REQUEST_RECEIVED = "Recibida petición %s a: %s";
    }

    public static class EndPoints {
        public static final String LOGIN = "/login";
        public static final String USER = "/user";
        public static final String AVATAR = "/user/avatar";
        public static final String TRAININGS = "/training";
        public static final String JOBS = "/job";
        public static final String SECTORS = "/sector";
        public static final String LANGUAGE_SKILLS = "/language/skill";
        public static final String LANGUAGES = "/language";
        public static final String LANGUAGE_GRADES = "/language/grade";
        public static final String DIGITAL_SKILLS = "/digitalskill";
        public static final String OTHER_SKILLS = "/otherskill";
    }

    public static class Keys {
        public static final Long LANGUAGE_SPANISH = 1L;

        public static final String ACTIVITY_JOB = "job";
    }

    public static class Definitions {
        public static final String TEXT = "LONGTEXT";
    }
}
