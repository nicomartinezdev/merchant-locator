package com.nicomartinezdev.qless.merchantlocator;

/**
 * Created by nicolasmartinez on 2/19/18.
 */

import com.nicomartinezdev.qless.merchantlocator.controllers.VersionController;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class VersionControllerTest {
    private static final String buildVersion = "0.0.1-SNAPSHOT";
    private static final String buildTimestamp = "2016-01-22T00:06:29.545Z";

    private final VersionController versionController = new VersionController(buildVersion, buildTimestamp);

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(versionController).build();
    }

    @Test
    public void returnsCorrectResponse() throws Exception {
        mockMvc.perform(get("/version"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.version", is(buildVersion)))
                .andExpect(jsonPath("$.date", is(buildTimestamp)));
    }

    @Test
    public void noOtherMethodsButGet() throws Exception {
        mockMvc.perform(post("/version")).andExpect(status().isMethodNotAllowed());
        mockMvc.perform(put("/version")).andExpect(status().isMethodNotAllowed());
        mockMvc.perform(delete("/version")).andExpect(status().isMethodNotAllowed());
    }
}