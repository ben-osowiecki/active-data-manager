package com.benosowiecki.activedatamanager.domain;

import com.benosowiecki.activedatamanager.utility.UnixSecondsDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.util.Date;

@Data
public class RequestToken {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonDeserialize(using = UnixSecondsDeserializer.class)
    private Date expiration;

    private String error;
}
