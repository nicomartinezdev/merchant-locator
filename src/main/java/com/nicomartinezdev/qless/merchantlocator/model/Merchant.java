package com.nicomartinezdev.qless.merchantlocator.model;

/**
 * Created by nicolasmartinez on 2/19/18.
 */
public class Merchant {

    private NetworkSource source;
    private String name;

    public Merchant(NetworkSource source, String name) {
        this.source = source;
        this.name = name;
    }

    public NetworkSource getSource() {
        return source;
    }

    public void setSource(NetworkSource source) {
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
