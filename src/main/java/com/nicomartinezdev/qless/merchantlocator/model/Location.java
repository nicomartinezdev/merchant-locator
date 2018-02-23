package com.nicomartinezdev.qless.merchantlocator.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by nicolasmartinez on 2/19/18.
 */

@Document(collection = "locations")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {

    private NetworkSource source;
    @Indexed
    private String name;
    private String description;
    private Merchant merchantInfo;
    private LocationContactInfo contactInfo;
    private ConsumerFeatures consumerFeatures;

    public Location(NetworkSource source, String name, String description, Merchant merchantInfo, LocationContactInfo contactInfo, ConsumerFeatures consumerFeatures) {
        this.source = source;
        this.name = name;
        this.description = description;
        this.merchantInfo = merchantInfo;
        this.contactInfo = contactInfo;
        this.consumerFeatures = consumerFeatures;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Merchant getMerchantInfo() {
        return merchantInfo;
    }

    public void setMerchantInfo(Merchant merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    public LocationContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(LocationContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public ConsumerFeatures getConsumerFeatures() {
        return consumerFeatures;
    }

    public void setConsumerFeatures(ConsumerFeatures consumerFeatures) {
        this.consumerFeatures = consumerFeatures;
    }
}
