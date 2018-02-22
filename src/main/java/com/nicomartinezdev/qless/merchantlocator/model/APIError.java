package com.nicomartinezdev.qless.merchantlocator.model;

/**
 * Created by nicolasmartinez on 2/19/18.
 */
public class APIError {

    private String message;

    public APIError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
