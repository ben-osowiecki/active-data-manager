package com.benosowiecki.activedatamanager.domain;

import lombok.Data;

import java.util.Set;

@Data
public class Device {
    private String id;
    private String name;
    private String latitude, longitude;
    private String positionAccuracy;
    private String positionTimestamp;
    private String responseAction;
    private String responseStamp;
    private IdentifiedResource responseAlert;
    private Set<IdentifiedResource> agencies;
}
