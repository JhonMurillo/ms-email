/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.email.utils;

/**
 *
 * @author DESARROLLO
 */
import org.springframework.http.HttpStatus;

public class ConstanteUtil {

    /**
     *
     * CODES OF ANSWERS
     */
    public static final int CODE_OK = HttpStatus.OK.value();
    public static final int CODE_ERROR = HttpStatus.CONFLICT.value();
    public static final int CODE_INTERNAL_ERROR = HttpStatus.INTERNAL_SERVER_ERROR.value();
    public static final int CODE_UNAUTHORIZED = HttpStatus.UNAUTHORIZED.value();
    public static final int CODE_FORBIDDEN = HttpStatus.FORBIDDEN.value();
    public static final Integer CODE_BAD_REQUEST = HttpStatus.BAD_REQUEST.value();

    /**
     * MSG - GENERALES
     */
    public static final String MSG_EXITO = "OPERACIÓN EXITOSA.";
    public static final String MSG_FALLIDO = "OPERACIÓN FALLIDA.";
    public static final String CODIGO_EXISTE = "CÓDIGO EXISTE.";

    /**
     * MSG - AUTH
     */
    public static final String MSG_AUTORIZACION = "NO AUTORIZADO!!";
    public static final String MSG_NO_AUTORIZACION = "NO AUTORIZADO!!";
    public static final String MSG_ERROR_AUTENTICACION = "ERROR AL AUTENTICAR";
    public static final String MSG_USER_NO_EXISTE = "USUARIO NO EXISTE.";
    public static final String MSG_PASS_NO_VALIDAD = "CONTRASEÑA INCORRECTA";
    public static final String MSG_NO_ACCESS = "USUARIO NO POSEE ACCESO AL SISTEMA";
    public static final String MSG_USER_NO_LOGIN = "USUARIO NO ESTA LOGUEADO.";
    public static final String MSG_USER_ERROR_LOGOUT = "ERROR AL CERRAR LA SESION DEL USUARIO.";
    public static final String MSG_USER_LOGOUT = "CIERRE DE SESION EXITOSA.";
    public static final String MSG_PASS_NO_EQUALS = "CONTRASEÑA ACTUAL NO ES IGUAL A LA ALMACENADA";
    
    /**
     * MSG - RESTRICTION
     */
    public static final String MSG_RESTRICTION_EMAIL = "ESTE EMAIL YA SE ENCUENTRA REGISTRADO EN LA PLATAFORMA";

    /**
     * STATES
     */
    public static final String STATE_ACTIVO = "A";
    public static final String STATE_INACTIVO = "I";
    /**
     * STATES_LOGIN
     */
    public static final String STATE_LOGIN = "LOGIN";
    public static final String STATE_LOGOUT = "LOGOUT";
    /**
     * STATES_TOKEN
     */
    public static final String STATE_EXPIRED = "EXPIRED";
    public static final String STATE_INITIATED = "INITIATED";
}
