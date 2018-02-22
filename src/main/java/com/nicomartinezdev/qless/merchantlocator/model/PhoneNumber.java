package com.nicomartinezdev.qless.merchantlocator.model;

/**
 * Created by nicolasmartinez on 2/19/18.
 */
public class PhoneNumber {

    private String countryCode;
    private String digits;

    public PhoneNumber(String countryCode, String digits){
        this.countryCode = countryCode;
        this.digits = digits;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDigits() {
        return digits;
    }

    public void setDigits(String digits) {
        this.digits = digits;
    }
}
