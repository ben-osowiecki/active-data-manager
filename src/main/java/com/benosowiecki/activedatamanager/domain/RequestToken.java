package com.benosowiecki.activedatamanager.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RequestToken {
    @JsonProperty("access_token")
    private String accessToken;

    private String expiration;

    private String error;
}
