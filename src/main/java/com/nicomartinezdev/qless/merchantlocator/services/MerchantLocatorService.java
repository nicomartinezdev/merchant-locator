package com.nicomartinezdev.qless.merchantlocator.services;

import com.nicomartinezdev.qless.merchantlocator.model.Location;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by nicolasmartinez on 2/22/18.
 */


@Service
public class MerchantLocatorService {

    private final MongoTemplate mongoTemplate;


    public MerchantLocatorService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    public List<Location> search (String nameText, Double lat, Double lon, Integer radius, Integer maxResults, Boolean mobileClientAccess, boolean omitMerchantInfo, boolean omitContactInfo, boolean omitConsumerFeatures) {

        Query query = new Query();
        if(StringUtils.isNotBlank(nameText)) {
            query.addCriteria(Criteria.where("name").regex("^" + nameText, "i"));
        }

        filterLocationQuery(mobileClientAccess, omitMerchantInfo, omitContactInfo, omitConsumerFeatures, query);

        if(maxResults == null) {
            maxResults = 10; //Default value
        }
        query.limit(maxResults);

        //TODO: Needs research and refinement
//        if(lat != null && lon != null) {
//            if(radius == null){
//                radius = 50000; //Default value in km
//            }
//            NearQuery nq = NearQuery.near(new Point(lon, lat), Metrics.KILOMETERS).maxDistance(radius/1000);
//            nq.query(query);
//            GeoResults<Location> geoResults = mongoTemplate.geoNear(nq, Location.class);
//        }

        return mongoTemplate.find(query, Location.class);
    }


    public Location getById(String locationId, Boolean mobileClientAccess, boolean omitMerchantInfo, boolean omitContactInfo, boolean omitConsumerFeatures) {

        Query query = new Query();
        query.addCriteria(Criteria.where("source.type").is("location"));
        query.addCriteria(Criteria.where("source.globalId").is(locationId));

        filterLocationQuery(mobileClientAccess, omitMerchantInfo, omitContactInfo, omitConsumerFeatures, query);

        return mongoTemplate.findOne(query, Location.class);

    }

    private void filterLocationQuery(Boolean mobileClientAccess, boolean omitMerchantInfo, boolean omitContactInfo, boolean omitConsumerFeatures, Query query) {
        if(mobileClientAccess != null) {
            query.addCriteria(Criteria.where("consumerFeatures.hasMobileAccess").is(mobileClientAccess));
        }

        if(omitMerchantInfo) {
            query.fields().exclude("merchantInfo");
        }
        if(omitContactInfo) {
            query.fields().exclude("contactInfo");
        }
        if(omitConsumerFeatures) {
            query.fields().exclude("consumerFeatures");
        }
    }
}