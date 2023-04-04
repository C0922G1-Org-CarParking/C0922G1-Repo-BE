package com.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_delete {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by: TaiLH
     * Date created: 30/03/2023
     * function: This function use to check delete employee with employee id is null
     * @throws Exception
     */
    @Test
    public void delete_id_25() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: TaiLH
     * Date created: 30/03/2023
     * function: This function use to check delete employee with employee id is ""
     * @throws Exception
     */
    @Test
    public void delete_id_26() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: TaiLH
     * Date created: 30/03/2023
     * function: This function use to check delete employee with employee id is 20
     * @throws Exception
     */
    @Test
    public void delete_id_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/20"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: TaiLH
     * Date created: 30/03/2023
     * function: This function use to check delete employee with employee id is 2
     * @throws Exception
     */
    @Test
    public void delete_id_28() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}

