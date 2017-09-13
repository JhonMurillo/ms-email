/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.email.utils;

/**
 *
 * @author Desarrollo3
 */
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

public class ResponseUtil {

    private String message;
    private Integer tipo;
    private List responseList;
    private JsonNode objectResponse;
    private Object object;
    private String token;

    public ResponseUtil() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public List getResponseList() {
        return responseList;
    }

    public void setResponseList(List responseList) {
        this.responseList = responseList;
    }

    public JsonNode getObjectResponse() {
        return objectResponse;
    }

    public void setObjectResponse(JsonNode objectResponse) {
        this.objectResponse = objectResponse;
    }

    public ResponseUtil(String message, Integer tipo) {
        this.message = message;
        this.tipo = tipo;
    }

    public ResponseUtil(String message, Integer tipo, List responseList, JsonNode objectResponse) {
        this.message = message;
        this.tipo = tipo;
        this.responseList = responseList;
        this.objectResponse = objectResponse;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
