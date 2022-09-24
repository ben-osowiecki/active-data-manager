package com.benosowiecki.activedatamanager.controller;

import com.benosowiecki.activedatamanager.domain.RequestToken;
import com.benosowiecki.activedatamanager.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final TokenService tokenService;

    @PutMapping("/refreshToken")
    public void putRefreshToken(@RequestBody String refreshToken, HttpServletRequest request) {
        Optional<RequestToken> requestTokenOptional = tokenService.getNewAuthToken(refreshToken);

        requestTokenOptional.ifPresentOrElse(
                (requestToken) -> tokenService.storeAuthToken(requestToken, request.getSession()),
                () -> {throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unable to Authenticate with Supplied Refresh Token");}
        );

        tokenService.storeRefreshToken(refreshToken, request.getSession());
    }

    @GetMapping("/token")
    @ResponseBody
    public String getCurrentAuthToken(HttpServletRequest request) {
        return tokenService.getStoredAuthToken(request.getSession());
    }
}
