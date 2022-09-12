package com.example.testtask_clearsolutions.controllers;

import com.example.testtask_clearsolutions.modela.dto.UserDTO;
import com.example.testtask_clearsolutions.modela.entity.User;
import com.example.testtask_clearsolutions.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createUserTest() throws Exception {

        User user = new User(1, "Stepan", "Potiuk", "asd@gmail.com", "123456789",
                LocalDate.parse("1998-02-27"), "street", LocalDate.now());

        BDDMockito.given(userService.create(user))
                        .willReturn(user);


        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateUserTest() throws Exception {

        User user = new User(1, "Stepan", "Potiuk", "asd@gmail.com", "123456789",
                LocalDate.parse("1998-02-27"), "street", LocalDate.now());

        User upDateUser = new User(1, "Igor", "Potiuk", "asd@gmail.com", "123456789",
                LocalDate.parse("1998-02-27"), "street", LocalDate.now());

        BDDMockito.given(userService.upDAte(user,1))
                .willReturn(upDateUser);

        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void finaALLUsersTest() throws Exception {

        List<UserDTO> userDTOList = new ArrayList<>();
        userDTOList.add(new UserDTO(new User(1, "Stepan", "Potiuk", "asd@gmail.com", "123456789",
                LocalDate.parse("1998-02-27"), "street", LocalDate.now())));

        BDDMockito.given(userService.getALL())
                .willReturn(userDTOList);

        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findByIdUserTest() throws Exception {

        User user = new User(1, "Stepan", "Potiuk", "asd@gmail.com", "123456789",
                LocalDate.parse("1998-02-27"), "street", LocalDate.now());

        BDDMockito.given(userService.getById(anyInt()))
                .willReturn(new UserDTO(user));

        mockMvc.perform(MockMvcRequestBuilders.get("/users/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Stepan"));
    }

    @Test
    public void deleteUserTest() throws Exception {

        User user = new User(1, "Stepan", "Potiuk", "asd@gmail.com", "123456789",
                LocalDate.parse("1998-02-27"), "street", LocalDate.now());

        BDDMockito.given(userService.getById(anyInt()))
                .willReturn(new UserDTO(user));

        mockMvc.perform(MockMvcRequestBuilders.get("/users/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Stepan"));
    }
}