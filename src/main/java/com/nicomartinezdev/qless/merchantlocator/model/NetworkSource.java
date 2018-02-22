package com.nicomartinezdev.qless.merchantlocator.model;

/**
 * Created by nicolasmartinez on 2/19/18.
 */
public class NetworkSource {

    private NetworkSourceType type;
    private String globalId;
    private String hostName;
    private String hostId;
    private String indirectId;

    public NetworkSource(NetworkSourceType type, String globalId, String hostName, String hostId, String indirectId) {
        this.type = type;
        this.globalId = globalId;
        this.hostName = hostName;
        this.hostId = hostId;
        this.indirectId = indirectId;
    }

    public NetworkSourceType getType() {
        return type;
    }

    public void setType(NetworkSourceType type) {
        this.type = type;
    }

    public String getGlobalId() {
        return globalId;
    }

    public void setGlobalId(String globalId) {
        this.globalId = globalId;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getIndirectId() {
        return indirectId;
    }

    public void setIndirectId(String indirectId) {
        this.indirectId = indirectId;
    }
}
