package com.benosowiecki.activedatamanager.client;

import com.benosowiecki.activedatamanager.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class ActiveAlertClient {

    @Qualifier("activeAlertWebClient")
    private final WebClient activeAlertWebClient;

    @Qualifier("activeAlertAuthWebClient")
    private final WebClient activeAlertAuthWebClient;

    private final ParameterizedTypeReference<ActiveAlertResponse<AlertIdentifierList>> responseAlertSummaryListTypeReference = new ParameterizedTypeReference<>() {};
    private final ParameterizedTypeReference<ActiveAlertResponse<Alert>> responseAlertTypeReference = new ParameterizedTypeReference<>() {};
    private final ParameterizedTypeReference<ActiveAlertResponse<Device>> responseDeviceTypeReference = new ParameterizedTypeReference<>() {};

    public ActiveAlertResponse<AlertIdentifierList> getAlertIdentifiers(int numDays) {
        return this.activeAlertWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("alert")
                        .queryParam("alert_days", "{days}")
                        .build(numDays)
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(responseAlertSummaryListTypeReference)
                .block();
    }

    public ActiveAlertResponse<Alert> getAlert(String alertId) {
        return this.activeAlertWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("alerts/{alertId}")
                        .build(alertId)
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(responseAlertTypeReference)
                .block();
    }

    public ActiveAlertResponse<Device> getDevice(String deviceId) {
        return this.activeAlertWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("devices/{deviceId}")
                        .build(deviceId)
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(responseDeviceTypeReference)
                .block();
    }

    public RequestToken getAccessToken(String refreshToken) {
        return this.activeAlertAuthWebClient.post()
                .uri("api_access.php")
                .body(BodyInserters.fromFormData("refresh_token", refreshToken))
                .retrieve()
                .bodyToMono(RequestToken.class)
                .block();
    }
}
