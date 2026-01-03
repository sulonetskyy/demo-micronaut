package com.example.controller;

import com.example.services.InfoService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import java.util.Map;

@Controller("/info")
public class InfoController {

    private final InfoService infoService;

    @Inject
    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public Map<String, String> info() {
        return this.infoService.getInfo();
    }

    @Get(uri = "/name", produces = MediaType.TEXT_PLAIN)
    public String name() {
        return this.infoService.getName();
    }

    @Get(uri = "/version", produces = MediaType.TEXT_PLAIN)
    public String version() {
        return this.infoService.getVersion();
    }

}
