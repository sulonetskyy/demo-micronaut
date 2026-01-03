package com.example.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit test for {@link InfoServiceImpl} of the {@link InfoService}.
 */
class InfoServiceImplTest {

    private static final String APP_NAME = "Test App";
    private static final String APP_VERSION = "1.2.3";
    private InfoService infoService;

    @BeforeEach
    void setUp() {
        this.infoService = new InfoServiceImpl(APP_NAME, APP_VERSION);
    }

    @Test
    void testGetInfo() {
        final Map<String, String> info = this.infoService.getInfo();
        assertNotNull(info);
        assertEquals(APP_NAME, info.get("name"));
        assertEquals(APP_VERSION, info.get("version"));
        assertNotNull(info.get("instance-uuid"));
    }

    @Test
    void testGetName() {
        assertEquals(APP_NAME, this.infoService.getName());
    }

    @Test
    void testGetVersion() {
        assertEquals(APP_VERSION, this.infoService.getVersion());
    }

}
