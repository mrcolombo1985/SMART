/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcolombo.smart.provider.security;

import com.mrcolombo.smart.configuration.GeneralOptions;
import com.mrcolombo.smart.dtoes.security.LoginDTO;
import com.mrcolombo.smart.dtoes.security.LoginResponse;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author serg
 */
public class LoginProvider {
    public  final HttpMethod POST = HttpMethod.POST;
    RequestEntity<?> request;
    ResponseEntity<LoginResponse> responseS;
    RestTemplate restTemplate = new RestTemplate();
    public LoginResponse login(){
        LoginResponse resp = null;
        try {
            request = new RequestEntity(new LoginDTO("rbulcock1","rbulcock1"), POST , new URI(GeneralOptions.URL+GeneralOptions.URNLOGIN));
            responseS = restTemplate.exchange(request, LoginResponse.class);
            resp = responseS.getBody();
        } catch (URISyntaxException ex) {
            Logger.getLogger(LoginProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }
}
