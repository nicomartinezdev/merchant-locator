package com.nicomartinezdev.qless.merchantlocator.model;

/**
 * Created by nicolasmartinez on 2/19/18.
 */
public enum NetworkSourceType {

    LOCATION("location"),

    MERCHANT("merchant");

    private String value;

    NetworkSourceType(String value) {
        this.value = value;
    }

    public static NetworkSourceType fromValue(String text) {
        for (NetworkSourceType nst : NetworkSourceType.values()) {
            if (String.valueOf(nst.value).equalsIgnoreCase(text)) {
                return nst;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}

