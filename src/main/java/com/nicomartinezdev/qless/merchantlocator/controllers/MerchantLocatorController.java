package com.nicomartinezdev.qless.merchantlocator.controllers;

import com.nicomartinezdev.qless.merchantlocator.model.Location;
import com.nicomartinezdev.qless.merchantlocator.services.MerchantLocatorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

    private final MerchantLocatorService merchantLocatorService;

    public MerchantLocatorController(MerchantLocatorService merchantLocatorService) {
        this.merchantLocatorService = merchantLocatorService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity get(@RequestParam(required = false) String searchText,
                              @RequestParam(required = false) Double longitude,
                              @RequestParam(required = false) Double latitude,
                              @RequestParam(required = false) Integer searchRadius,
                              @RequestParam(required = false) Integer maxResults,
                              @RequestParam(required = false) Boolean mobileClientAccess,
                              @RequestParam(required = false) boolean omitMerchantInfo,
                              @RequestParam(required = false) boolean omitContactInfo,
                              @RequestParam(required = false) boolean omitConsumerFeatures,
                              @RequestHeader(required = false) String xFields) {

        List<Location> locations = merchantLocatorService.search(searchText, latitude, longitude, searchRadius, maxResults, mobileClientAccess, omitMerchantInfo, omitContactInfo, omitConsumerFeatures);

        return ResponseEntity.ok(locations);
    }

    @RequestMapping(value = "/{location_gid}", method = RequestMethod.GET)
    public ResponseEntity getByLocationId(@PathVariable("location_gid") String locationId,
                                           @RequestParam(required = false) Boolean mobileClientAccess,
                                           @RequestParam(required = false) boolean omitMerchantInfo,
                                           @RequestParam(required = false) boolean omitContactInfo,
                                           @RequestParam(required = false) boolean omitConsumerFeatures,
                                           @RequestHeader(required = false) String xFields) {

        Location location = merchantLocatorService.getById(locationId, mobileClientAccess, omitMerchantInfo, omitContactInfo, omitConsumerFeatures);

        if(location == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(location);
    }

}
