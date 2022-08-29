package com.benosowiecki.activedatamanager.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ActiveAlertConfiguration {
    @Bean("activeAlertWebClient")
    public WebClient activeAlertWebClient() {
        return WebClient.builder()
                .baseUrl("https://console.active911.com/interface/open_api/api/")
                .exchangeStrategies(ExchangeStrategies.builder().codecs(this::acceptedCodecs).build())
//                .clientConnector(new ReactorClientHttpConnector(HttpClient.create().wiretap(true)))
                .build();
    }

    @Bean("activeAlertAuthWebClient")
    public WebClient activeAlertAuthWebClient() {
        return WebClient.builder()
                .baseUrl("https://console.active911.com/interface/dev/")
                .exchangeStrategies(ExchangeStrategies.builder().codecs(this::acceptedCodecs).build())
                .build();
    }

    private void acceptedCodecs(ClientCodecConfigurer clientCodecConfigurer) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false);

        clientCodecConfigurer.customCodecs().decoder(new Jackson2JsonDecoder(objectMapper, MediaType.TEXT_HTML));
    }
}
