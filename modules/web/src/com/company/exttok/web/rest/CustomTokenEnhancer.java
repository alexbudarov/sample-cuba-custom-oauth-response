package com.company.exttok.web.rest;

import com.company.exttok.entity.UserDetails;
import com.haulmont.addon.restapi.api.auth.CubaTokenEnhancer;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CustomTokenEnhancer extends CubaTokenEnhancer {

    @Inject
    private DataManager dataManager;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        OAuth2AccessToken token = super.enhance(accessToken, authentication);
        String userLogin = (String) authentication.getUserAuthentication().getPrincipal();

        Optional<UserDetails> userDetails = dataManager.load(UserDetails.class)
                .query("select ud from exttok_UserDetails ud where ud.user.loginLowerCase = :login")
                .parameter("login", userLogin.toLowerCase())
                .optional();

        userDetails.ifPresent(ud -> {
            Map<String, Object> additionalInfos = new HashMap<>(token.getAdditionalInformation());
            additionalInfos.put("telephone", ud.getPhoneNumber());

            DefaultOAuth2AccessToken mutableAccessToken = (DefaultOAuth2AccessToken) accessToken;
            mutableAccessToken.setAdditionalInformation(additionalInfos);
        });

        return token;
    }
}
