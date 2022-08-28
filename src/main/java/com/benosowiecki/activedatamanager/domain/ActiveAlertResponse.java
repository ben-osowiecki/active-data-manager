package com.benosowiecki.activedatamanager.domain;

import lombok.Data;

@Data
public class ActiveAlertResponse<T> {

    private ActiveAlertResponseStatus result;
    private T message;

}
