package com.example.ttestt.controller;


import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.ttestt.controller.api.UsersApiController;
import com.example.ttestt.data.dto.UsersDto;
import com.example.ttestt.data.entity.Role;
import com.example.ttestt.service.UsersService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

//@SpringBootTest
@WebMvcTest(UsersApiController.class)
@AutoConfigureMockMvc
public class UsersApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UsersService usersService;

    @Test
    @DisplayName("users 가져오기")
    void getUsers() throws Exception {

        Long id = 22L;

        given(usersService.getUsers(id)).willReturn(
                new UsersDto().builder()
                        .usersId(22L)
                        .userName("park")
                        .password("1234")
                        .email("park@park")
                        .role(Role.USER)
                        .build());
        mockMvc.perform(
                        get("/user/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.usersId").exists())
                .andExpect(jsonPath("$.userName").exists())
                .andExpect(jsonPath("$.password").exists())
                .andExpect(jsonPath("$.email").exists())
                .andExpect(jsonPath("$.role").exists())
                .andDo(print());

        verify(usersService).getUsers(id);
    }

    @Test
    @DisplayName("test")
    void testTest() {
        assertEquals("1", "1");
        assertNotNull(new UsersDto());
    }



}
