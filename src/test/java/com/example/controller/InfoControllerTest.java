package com.example.controller;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class InfoControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testInfo() {
        final Map<String, String> info = this.client.toBlocking().retrieve(HttpRequest.GET("/info"), Map.class);
        assertNotNull(info);
        assertEquals("Demo Application", info.get("name"));
        assertNotNull(info.get("version"));
        assertNotNull(info.get("instance-uuid"));
    }

    @Test
    void testName() {
        final String name = this.client.toBlocking().retrieve(HttpRequest.GET("/info/name"), String.class);
        assertEquals("Demo Application", name);
    }

    @Test
    void testVersion() {
        final String version = this.client.toBlocking().retrieve(HttpRequest.GET("/info/version"), String.class);
        assertNotNull(version);
    }

}
