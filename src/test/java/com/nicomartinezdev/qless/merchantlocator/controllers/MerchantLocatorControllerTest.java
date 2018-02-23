package com.nicomartinezdev.qless.merchantlocator.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nicomartinezdev.qless.merchantlocator.model.Location;
import com.nicomartinezdev.qless.merchantlocator.services.MerchantLocatorService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by nicolasmartinez on 2/23/18.
 */

@RunWith(MockitoJUnitRunner.class)
public class MerchantLocatorControllerTest {

    private static final String MERCHANT_LOCATOR_ENDPOINT = MerchantLocatorController.class.getAnnotation(RequestMapping.class).value()[0];
    private static final String LOCATION_ID = "id";
    @Mock
    private MerchantLocatorService service;

    private MerchantLocatorController controller;
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() {
        controller = new MerchantLocatorController(service);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testSearch() throws Exception {
        //GIVEN

        String jsonLocation = objectMapper.writeValueAsString(getLocations());
        when(service.search(anyString(), anyDouble(), anyDouble(), anyInt(), anyInt(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean())).thenReturn(getLocations());


        //WHEN - THEN
        mockMvc.perform(get(MERCHANT_LOCATOR_ENDPOINT))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonLocation));
    }

    @Test
    public void testGetById() throws Exception {
        //GIVEN

        String jsonLocation = objectMapper.writeValueAsString(getLocation());
        when(service.getById(anyString(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean())).thenReturn(getLocation());


        //WHEN - THEN
        mockMvc.perform(get(MERCHANT_LOCATOR_ENDPOINT + '/' + LOCATION_ID))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonLocation));
    }

    private Location getLocation() {
        return new Location(null, "name", "description", null, null, null);
    }

    private List<Location> getLocations() {
        List<Location> list = new ArrayList<Location>();
        list.add(getLocation());
        return list;
    }
}
