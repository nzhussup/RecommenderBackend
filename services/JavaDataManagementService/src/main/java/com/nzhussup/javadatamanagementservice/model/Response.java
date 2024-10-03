package com.nzhussup.javadatamanagementservice.model;

import org.springframework.stereotype.Component;

@Component
public class Response<T> {
    private String message;
    private T obj; // Using T as a type parameter

    public Response() {}

    public Response(String message, T obj) {
        this.message = message;
        this.obj = obj;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

}
