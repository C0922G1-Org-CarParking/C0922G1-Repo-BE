package com.example;


import com.example.dto.EmployeeDto;
import com.example.model.Position;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_findById {
    @Autowired
    private MockMvc mockMvc;
    /**
     *
     * This function checks  the input parameter is null
     */
    @Test
    public void findById_id_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     *
     * This function checks the input parameter empty
     */
    @Test
    public void findById_id_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     *
     * This function checks the input parameter does not exist
     */
    @Test
    public void findById_id_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/{id}", "100000"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *
     * This function checks the correct input parameter
     */
    @Test
    public void getInfoStudent_id_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpectAll(
                        jsonPath("id").value(1),
                        jsonPath("name").value("Nguyen Tu"),
                        jsonPath("commune").value(1),
                        jsonPath("district").value(1),
                        jsonPath("email").value("tu@gmail.com"),
                        jsonPath("gender").value(true),
                        jsonPath("idCard").value("01010101"),
                        jsonPath("dateOfBirth").value("1990-01-01"),
                        jsonPath("phoneNumber").value("01234667885"),
                        jsonPath("province").value(1),
                        jsonPath("street").value("hamnghi"),
                        jsonPath("position").value(1),
                        jsonPath("deleted").value(false),
                        jsonPath("position").value(1)

        );
    }




}
