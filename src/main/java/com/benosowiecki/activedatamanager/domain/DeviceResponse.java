package com.benosowiecki.activedatamanager.domain;

import lombok.Data;

@Data
public class DeviceResponse {
    private DeviceResponseType response;
    private String timestamp;
    private IdentifiedResource device;
}
