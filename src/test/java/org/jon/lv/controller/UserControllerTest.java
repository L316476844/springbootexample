package org.jon.lv.controller;

import org.jon.lv.SpringbootexampleApplicationTests;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @Package org.jon.lv.controller.UserControllerTest
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/16 13:14
 * version V1.0.0
 */
public class UserControllerTest extends SpringbootexampleApplicationTests {
    @Test
    public void testGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user/get/38710")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
