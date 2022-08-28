package com.benosowiecki.activedatamanager.client;

import com.benosowiecki.activedatamanager.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class ActiveAlertClient {

    private final WebClient webClient;

    private final ParameterizedTypeReference<ActiveAlertResponse<AlertIdentifierList>> responseAlertSummaryListTypeReference = new ParameterizedTypeReference<>() {};
    private final ParameterizedTypeReference<ActiveAlertResponse<Alert>> responseAlertTypeReference = new ParameterizedTypeReference<>() {};
    private final ParameterizedTypeReference<ActiveAlertResponse<Device>> responseDeviceTypeReference = new ParameterizedTypeReference<>() {};

    public ActiveAlertResponse<AlertIdentifierList> getAlertIdentifiers(int numDays) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("open_api/api/alert")
                        .queryParam("alert_days", "{days}")
                        .build(numDays)
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(responseAlertSummaryListTypeReference)
                .block();
    }

    public ActiveAlertResponse<Alert> getAlert(String alertId) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("open_api/api/alerts/{alertId}")
                        .build(alertId)
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(responseAlertTypeReference)
                .block();
    }

    public ActiveAlertResponse<Device> getDevice(String deviceId) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("open_api/api/devices/{deviceId}")
                        .build(deviceId)
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(responseDeviceTypeReference)
                .block();
    }

    public RequestToken getAccessToken(String refreshToken) {
        return this.webClient.post()
                .uri("dev/api_access.php")
                .body(BodyInserters.fromFormData("refresh_token", refreshToken))
                .retrieve()
                .bodyToMono(RequestToken.class)
                .block();
    }
}
