package com.example.controller.location;

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
public class LocationController_findByIdLocation {
    @Autowired
    private MockMvc mockMvc;
    /**
     * Create: TheNV
     * tìm kiếm đối tượng location có tham số id= null
     * status= 400
     */
    @Test
    public void findByIdLocation_id_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/location/findLocationById").param("id", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create: TheNV
     * tìm kiếm đối tượng location có tham số id= " "
     * status= 400
     */
    @Test
    public void findByIdLocation_id_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/location/findLocationById").param("id", " "))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create: TheNV
     * tìm kiếm đối tượng location có tham số id= 10 (id không có trong database)
     * status= 400
     */
    @Test
    public void findByIdLocation_id_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/location/findLocationById").param("id", "10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create: TheNV
     * tìm kiếm đối tượng location có tham số id= 1 (id có trong database)
     * status= 200
     */
    @Test
    public void findByIdLocation_id_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/location/findLocationById").param("id", "1"))
                .andDo(print()).andExpectAll(jsonPath("sectionName").value("A"),
                        jsonPath("floorName").value("1"),
                        jsonPath("customerName").value("Vu BD"),
                        jsonPath("customerEmail").value("vule@gmail.com"),
                        jsonPath("nameCar").value("Fortuner"),
                        jsonPath("locationName").value("1"),
                        jsonPath("plateNumber").value("92B-99999"),
                        jsonPath("customerPhoneNumber").value("1234567893"),
                        jsonPath("nameCarType").value("4 Chỗ"),
                        jsonPath("dateOfBirth").value("1994-12-25"));

    }

}
