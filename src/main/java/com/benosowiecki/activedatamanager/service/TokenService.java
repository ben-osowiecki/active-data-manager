package com.benosowiecki.activedatamanager.service;

import com.benosowiecki.activedatamanager.client.ActiveAlertClient;
import com.benosowiecki.activedatamanager.domain.RequestToken;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final ActiveAlertClient activeAlertClient;

    public void storeAuthToken(RequestToken token, HttpSession httpSession) {
        httpSession.setAttribute("requestToken", token.getAccessToken());
        httpSession.setAttribute("requestTokenExpiration", token.getExpiration());
    }

    public void storeRefreshToken(String refreshToken, HttpSession httpSession) {
        httpSession.setAttribute("refreshToken", refreshToken);
    }

    public String getStoredAuthToken(HttpSession httpSession) {
        return (String) httpSession.getAttribute("requestToken");
    }

    public String getStoredRefreshToken(HttpSession httpSession) {
        return (String) httpSession.getAttribute("requestToken");
    }

    public Optional<RequestToken> getNewAuthToken(String refreshToken) {
        RequestToken requestToken = activeAlertClient.getAccessToken(refreshToken);

        if(requestToken == null || StringUtils.isNotEmpty(requestToken.getError())) {
            return Optional.empty();
        }

        return Optional.of(requestToken);
    }


}
