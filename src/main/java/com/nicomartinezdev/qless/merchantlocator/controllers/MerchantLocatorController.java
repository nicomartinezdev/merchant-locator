package com.nicomartinezdev.qless.merchantlocator.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * Created by nicolasmartinez on 2/19/18.
 */

@RestController
@RequestMapping(value = "/merchant/location", produces = APPLICATION_JSON_UTF8_VALUE)
public class MerchantLocatorController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity get(@RequestParam(required = false) String searchText,
                              @RequestParam(required = false) int longitude,
                              @RequestParam(required = false) int latitude,
                              @RequestParam(required = false, defaultValue = "5000L") Long searchRadius,
                              @RequestParam(required = false) List<String> gids,
                              @RequestParam(required = false, defaultValue = "10") Integer maxResults,
                              @RequestParam(required = false) boolean mobileClientAccess,
                              @RequestParam(required = false) boolean omitMerchantInfo,
                              @RequestParam(required = false) boolean omitContactInfo,
                              @RequestParam(required = false) boolean omitConsumerFeatures,
                              @RequestHeader(required = false) String xFields) {

        //ResponseEntity response = uuidService.get(pageable, title, contentTypeValue, event);


        return null;
    }



}
