package com.example.controller.location;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LocationController_getMapParking {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create: TheNV
     * tìm kiếm danh sách location có tham số idFloor= null
     * status= 400
     */
    @Test
    public void getMapParking_idFloor_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/location/mapParking").param("idFloor", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    /**
     * Create: TheNV
     * tìm kiếm danh sách location có tham số idFloor= " "
     * status= 400
     */
    @Test
    public void getMapParking_idFloor_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/location/mapParking").param("idFloor", " "))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create: TheNV
     * tìm kiếm danh sách location có tham số idFloor= 10(id không có trong database)
     * status= 400
     */
    @Test
    public void getMapParking_idFloor_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/location/mapParking").param("idFloor", "10"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create: TheNV
     * tìm kiếm danh sách location có tham số idFloor= 1 (idFloor có trong database)
     * status= 200
     */
    @Test
    public void getMapParking_idFloor_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/location/mapParking").param("idFloor", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].id").value(1))
                .andExpect(jsonPath("[0].name").value(1))
                .andExpect(jsonPath("[0].width").value(6.0))
                .andExpect(jsonPath("[0].height").value(6.0))
                .andExpect(jsonPath("[0].length").value(5.0))
                .andExpect(jsonPath("[0].section.id").value(1))
                .andExpect(jsonPath("[0].occupied").value(true))
                .andExpect(jsonPath("[0].floor.id").value(1))
                .andExpect(jsonPath("[0].permissionCarTypeLocations").value("xe 4 chỗ"))
                .andExpect(jsonPath("[3].id").value(4))
                .andExpect(jsonPath("[3].name").value(4))
                .andExpect(jsonPath("[3].width").value(4.0))
                .andExpect(jsonPath("[3].height").value(6.0))
                .andExpect(jsonPath("[3].length").value(4.0))
                .andExpect(jsonPath("[3].section.id").value(4))
                .andExpect(jsonPath("[3].floor.id").value(1))
                .andExpect(jsonPath("[3].occupied").value(true))
                .andExpect(jsonPath("[3].permissionCarTypeLocations").value("xe 8 chỗ"));


    }
}
