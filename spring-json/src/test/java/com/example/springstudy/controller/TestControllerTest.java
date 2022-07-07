package com.example.springstudy.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest
class TestControllerTest {

    private static final String ORG_URL = "/test";
    @Autowired
    private MockMvc mockMvc;

    @Test
    void ModelAttribute의_LocalDateTime은_변환됨() throws Exception {
        // given
        String url = ORG_URL + "/model?name=test&dateTime=2020-01-01T10:00:00";

        // when
        ResultActions resultActions = this.mockMvc.perform(get(url));

        // then
        resultActions
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("SUCCESS")));
    }

    @Test
    void RequestBody의_LocalDateTime은_변환됨() throws Exception {
        // given
        String url = ORG_URL + "/model";

        // when
        ResultActions resultActions = this.mockMvc.perform(
            post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"test\", \"dateTime\":\"2018-12-15T10:00:00\"}"));

        // then
        resultActions
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("SUCCESS")));
    }

    @Test
    void ResponseBody의_LocalDateTime은_변환됨() throws Exception {
        // given
        String url = ORG_URL + "/response";

        // when
        ResultActions resultActions = this.mockMvc.perform(get(url));

        // then
        resultActions
            .andExpect(status().isOk())
            .andExpect(
                content().json("{\"name\":\"test\", \"date_time\":\"2022-01-01 10:00:00\"}"));
    }
}