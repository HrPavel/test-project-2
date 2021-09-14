package com.selectors.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.selectors.test.BaseIntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.selectors.test.util.TestDataCreator.createMainSector;
import static com.selectors.test.util.TestDataCreator.createSubSector;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class SectorControllerTest extends BaseIntegrationTest {
    private static final String BASE_URL = "/api/sector";

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;

    @BeforeEach
    public void init() {
        sectorRepository.save(
                createSubSector(createMainSector()));
    }

    @Test
    public void getAll() throws Exception {
        // given
        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders
                        .get(BASE_URL)
                        .contentType(APPLICATION_JSON);

        // when
        ResultActions perform = mockMvc.perform(requestBuilder);

        // then
        perform
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}