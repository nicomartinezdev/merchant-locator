package com.nicomartinezdev.qless.merchantlocator.model;

import java.util.List;

/**
 * Created by nicolasmartinez on 2/19/18.
 */
public class Address {

    private List<String> addressLines;
    private String city;
    private String state;
    private String postalCode;
    private String isoCountryCode;

    public Address(List<String> addressLines, String isoCountryCode, String city, String state, String postalCode) {
        this.addressLines = addressLines;
        this.isoCountryCode = isoCountryCode;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public List<String> getAddressLines() {
        return addressLines;
    }

    public void setAddressLines(List<String> addressLines) {
        this.addressLines = addressLines;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getIsoCountryCode() {
        return isoCountryCode;
    }

    public void setIsoCountryCode(String isoCountryCode) {
        this.isoCountryCode = isoCountryCode;
    }
}
