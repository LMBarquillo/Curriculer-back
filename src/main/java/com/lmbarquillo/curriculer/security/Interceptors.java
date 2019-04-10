package com.lmbarquillo.curriculer.security;

import com.lmbarquillo.curriculer.entities.User;
import com.lmbarquillo.curriculer.services.UserService;
import com.lmbarquillo.curriculer.utilities.Values;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Clase interceptora de requests. Se encarga de verificar si las llamadas a nuestros endPoints vienen con autorización.
 */
public class Interceptors extends HandlerInterceptorAdapter {
    private static Logger log = LoggerFactory.getLogger(Interceptors.class);

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String endPoint = request.getRequestURI();
        String auth = request.getHeader(Values.Strings.HEADER_AUTH);

        // Si vamos al login, no necesitamos credenciales
        if(endPoint.equals(Values.EndPoints.LOGIN)) {
            return true;
        }
        // Si no recibimos credenciales, tiramos un error
        if(auth == null) {
            log.error(String.format(Values.Errors.ERROR_NO_AUTHORIZATION, getRemoteAddr(request)));
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        String authValues[] = auth.split(Values.Strings.SPLIT_AUTH);
        User user = userService.checkUser(authValues[0], authValues[1]);
        // Si no existe el usuario, tiramos error
        if(user == null) {
            log.error(String.format(Values.Errors.ERROR_UNAUTHORIZED, getRemoteAddr(request)));
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        // Si está autorizado, añadimos el usuario a los atributos de la llamada.
        request.setAttribute(Values.Strings.ATTRIBUTE_USER, user);
        log.info(String.format(Values.Info.USER_AUTHORIZED, user.getUser()));
        return true;
    }

    private String getRemoteAddr(HttpServletRequest request) {
        String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
        if (ipFromHeader != null && ipFromHeader.length() > 0) {
            return ipFromHeader;
        }
        return request.getRemoteAddr();
    }

}
