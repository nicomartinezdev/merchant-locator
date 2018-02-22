package com.nicomartinezdev.qless.merchantlocator.model;

import java.util.List;

/**
 * Created by nicolasmartinez on 2/19/18.
 */
public class ConsumerFeatures {

    private boolean hasAppointments;
    private boolean hasCustomScreens;
    private boolean hasSMSSummoning;
    private boolean hasVoiceQueuing;
    private boolean hasTransactionTypes;
    private boolean hasMobileAccess;
    private int maxSimultaneousQueues;
    private boolean supportsPartySize;
    private boolean shouldDisplayTransactionTypesBeforeQueues;
    private List<String> supportedLocales;

    public ConsumerFeatures(boolean hasAppointments, boolean hasCustomScreens, boolean hasSMSSummoning, boolean hasVoiceQueuing, boolean hasTransactionTypes, boolean hasMobileAccess, int maxSimultaneousQueues, boolean supportsPartySize, boolean shouldDisplayTransactionTypesBeforeQueues, List<String> supportedLocales) {
        this.hasAppointments = hasAppointments;
        this.hasCustomScreens = hasCustomScreens;
        this.hasSMSSummoning = hasSMSSummoning;
        this.hasVoiceQueuing = hasVoiceQueuing;
        this.hasTransactionTypes = hasTransactionTypes;
        this.hasMobileAccess = hasMobileAccess;
        this.maxSimultaneousQueues = maxSimultaneousQueues;
        this.supportsPartySize = supportsPartySize;
        this.shouldDisplayTransactionTypesBeforeQueues = shouldDisplayTransactionTypesBeforeQueues;
        this.supportedLocales = supportedLocales;
    }

    public boolean isHasAppointments() {
        return hasAppointments;
    }

    public void setHasAppointments(boolean hasAppointments) {
        this.hasAppointments = hasAppointments;
    }

    public boolean isHasCustomScreens() {
        return hasCustomScreens;
    }

    public void setHasCustomScreens(boolean hasCustomScreens) {
        this.hasCustomScreens = hasCustomScreens;
    }

    public boolean isHasSMSSummoning() {
        return hasSMSSummoning;
    }

    public void setHasSMSSummoning(boolean hasSMSSummoning) {
        this.hasSMSSummoning = hasSMSSummoning;
    }

    public boolean isHasVoiceQueuing() {
        return hasVoiceQueuing;
    }

    public void setHasVoiceQueuing(boolean hasVoiceQueuing) {
        this.hasVoiceQueuing = hasVoiceQueuing;
    }

    public boolean isHasTransactionTypes() {
        return hasTransactionTypes;
    }

    public void setHasTransactionTypes(boolean hasTransactionTypes) {
        this.hasTransactionTypes = hasTransactionTypes;
    }

    public boolean isHasMobileAccess() {
        return hasMobileAccess;
    }

    public void setHasMobileAccess(boolean hasMobileAccess) {
        this.hasMobileAccess = hasMobileAccess;
    }

    public int getMaxSimultaneousQueues() {
        return maxSimultaneousQueues;
    }

    public void setMaxSimultaneousQueues(int maxSimultaneousQueues) {
        this.maxSimultaneousQueues = maxSimultaneousQueues;
    }

    public boolean isSupportsPartySize() {
        return supportsPartySize;
    }

    public void setSupportsPartySize(boolean supportsPartySize) {
        this.supportsPartySize = supportsPartySize;
    }

    public boolean isShouldDisplayTransactionTypesBeforeQueues() {
        return shouldDisplayTransactionTypesBeforeQueues;
    }

    public void setShouldDisplayTransactionTypesBeforeQueues(boolean shouldDisplayTransactionTypesBeforeQueues) {
        this.shouldDisplayTransactionTypesBeforeQueues = shouldDisplayTransactionTypesBeforeQueues;
    }

    public List<String> getSupportedLocales() {
        return supportedLocales;
    }

    public void setSupportedLocales(List<String> supportedLocales) {
        this.supportedLocales = supportedLocales;
    }
}
