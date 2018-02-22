package com.nicomartinezdev.qless.merchantlocator.controllers;

/**
 * Created by nicolasmartinez on 2/19/18.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 *
 * Endpoint that returns current build version number and last build timestamp
 */

@RestController
@RequestMapping(value = "/version", produces = APPLICATION_JSON_UTF8_VALUE)
public class VersionController {
    private static final String BUILD_VERSION = "version";
    private static final String BUILD_TIMESTAMP = "date";

    private final Map<String, String> buildInfo;

    public VersionController(String buildVersion, String buildTimestamp) {
        buildInfo = new HashMap<>(2);
        buildInfo.put(BUILD_VERSION, buildVersion);
        buildInfo.put(BUILD_TIMESTAMP, buildTimestamp);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, String> version() {
        return buildInfo;
    }
}
