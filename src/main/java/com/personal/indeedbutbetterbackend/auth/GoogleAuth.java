package com.personal.indeedbutbetterbackend.auth;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.personal.indeedbutbetterbackend.entity.User;


import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

public class GoogleAuth {

    //@Value("${spring.security.oauth2.client.registration.google.clientId}")
    private String clientId = "583369200281-ubok9tafv7bf6rm259jhklq30clh2fbs.apps.googleusercontent.com";
    private HttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
    private JsonFactory jsonFactory = GsonFactory.getDefaultInstance();
    GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
            .setAudience(Collections.singletonList(clientId))
            .build();

    public GoogleAuth() throws GeneralSecurityException, IOException {
    }

    public User validateUser(String idTokenString) {
        try {
            GoogleIdToken idToken = verifier.verify(idTokenString);
            if (idToken != null) {
                Payload payload = idToken.getPayload();
                User user = new User(payload.getEmail(), (String) payload.get("name"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
