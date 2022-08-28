package com.benosowiecki.activedatamanager.domain;

import lombok.Data;

import java.util.List;

@Data
public class Alert {
    private String id;
    private String received, sent;
    private String priority;
    private String description;
    private String details;
    private String externalData;
    private String place;
    private String address;
    private String unit;
    private String crossStreet;
    private String city;
    private String state;
    private String latitude;
    private String longitude;
    private String source;
    private String units;
    private String cadCode;
    private String mapCode;
    private IdentifiedResource agency;
    private List<IdentifiedResource> responses;
}
