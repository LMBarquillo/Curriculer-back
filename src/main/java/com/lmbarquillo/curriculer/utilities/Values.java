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
        public static final String DUPLICATED_EMAIL = "Ya existe un usuario con el email escogido";
        public static final String DUPLICATED_USER = "Ya existe un usuario con el usuario escogido";
    }

    public static class Info {
        public static final String USER_AUTHORIZED = "Petición de usuario autorizado: %s";
    }

    public static class EndPoints {
        public static final String LOGIN = "/login";
        public static final String USER = "/user";
    }
}
