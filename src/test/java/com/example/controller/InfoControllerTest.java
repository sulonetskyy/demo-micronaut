package com.example.controller;

import io.micronaut.context.annotation.Property;
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

    @Property(name = "micronaut.application.name")
    private String applicationName;

    @Property(name = "micronaut.application.version")
    private String applicationVersion;

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testInfo() {
        final Map<String, String> info = this.client.toBlocking().retrieve(HttpRequest.GET("/info"), Map.class);
        assertNotNull(info);
        assertEquals(this.applicationName, info.get("name"));
        assertEquals(this.applicationVersion, info.get("version"));
        assertNotNull(info.get("instance-uuid"));
    }

    @Test
    void testName() {
        final String name = this.client.toBlocking().retrieve(HttpRequest.GET("/info/name"), String.class);
        assertEquals(this.applicationName, name);
    }

    @Test
    void testVersion() {
        final String version = this.client.toBlocking().retrieve(HttpRequest.GET("/info/version"), String.class);
        assertEquals(this.applicationVersion, version);
    }

}
