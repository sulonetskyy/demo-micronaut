package com.example.services;

import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;

import java.util.Map;
import java.util.UUID;

@Singleton
public class InfoServiceImpl implements InfoService {

    private static final UUID INSTANCE_UUID = UUID.randomUUID();
    private final Map<String, String> info;

    public InfoServiceImpl(@Value("${micronaut.application.name}") String applicationName,
                           @Value("${micronaut.application.version}") String applicationVersion) {
        this.info = Map.of(
                "name", applicationName,
                "version", applicationVersion,
                "instance-uuid", INSTANCE_UUID.toString());
    }

    @Override
    public Map<String, String> getInfo() {
        return this.info;
    }

    @Override
    public String getName() {
        return this.info.get("name");
    }

    @Override
    public String getVersion() {
        return this.info.get("version");
    }

}
