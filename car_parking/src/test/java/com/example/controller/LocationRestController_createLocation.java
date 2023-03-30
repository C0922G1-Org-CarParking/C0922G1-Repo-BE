package com.example.controller;

import com.example.dto.LocationDto;
import com.example.model.Floor;
import com.example.model.Section;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LocationRestController_createLocation {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


/**
     *
     * This function is used to check an input position number property is null
     */

    @Test
    public void createLocation_width_13() throws Exception {
        LocationDto locationDto = new LocationDto();
        locationDto.setName("1");
        locationDto.setWidth(null);
        locationDto.setHeight(10.0);
        locationDto.setLength(10.0);
        Floor floor = new Floor();
        floor.setId(Long.valueOf(1));
        locationDto.setFloor(floor);
        Section section = new Section();
        section.setId(Long.valueOf(1));
        locationDto.setSection(section);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/location/create")
                        .content(this.objectMapper.writeValueAsString(locationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

/*
*
     *
     * This function is used to check an input Height property is null

*/

    @Test
    public void createLocation_Height_13() throws Exception {
        LocationDto locationDto = new LocationDto();
        locationDto.setName("1");
        locationDto.setWidth(10.0);
        locationDto.setHeight(null);
        locationDto.setLength(10.0);
        Floor floor = new Floor();
        floor.setId(Long.valueOf(1));
        locationDto.setFloor(floor);
        Section section = new Section();
        section.setId(Long.valueOf(1));
        locationDto.setSection(section);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/location/create")
                        .content(this.objectMapper.writeValueAsString(locationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
/**
     *
     * This function is used to check an input Length property is null
     */

    @Test
    public void createLocation_Length_13() throws Exception {
        LocationDto locationDto = new LocationDto();
        locationDto.setName("1");
        locationDto.setWidth(10.0);
        locationDto.setHeight(10.0);
        locationDto.setLength(null);
        Floor floor = new Floor();
        floor.setId(Long.valueOf(1));
        locationDto.setFloor(floor);
        Section section = new Section();
        section.setId(Long.valueOf(1));
        locationDto.setSection(section);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/location/create")
                        .content(this.objectMapper.writeValueAsString(locationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


/*
*
     *
     * This function is used to check an input Width property is empty

*/

    @Test
    public void createLocation_Width_14() throws Exception {
        LocationDto locationDto = new LocationDto();
        locationDto.setName("1");
        locationDto.setWidth("");
        locationDto.setHeight(10.0);
        locationDto.setLength(10.0);
        Floor floor = new Floor();
        floor.setId(Long.valueOf(1));
        locationDto.setFloor(floor);
        Section section = new Section();
        section.setId(Long.valueOf(1));
        locationDto.setSection(section);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/location/create")
                        .content(this.objectMapper.writeValueAsString(locationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
/**
     *
     * This function is used to check an input height property is empty
     */

    @Test
    public void createLocation_height_14() throws Exception {
        LocationDto locationDto = new LocationDto();
        locationDto.setName("1");
        locationDto.setWidth(10.0);
        locationDto.setHeight("");
        locationDto.setLength(10.0);
        Floor floor = new Floor();
        floor.setId(Long.valueOf(1));
        locationDto.setFloor(floor);
        Section section = new Section();
        section.setId(Long.valueOf(1));
        locationDto.setSection(section);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/location/create")
                        .content(this.objectMapper.writeValueAsString(locationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
/*
*
     *
     * This function is used to check an input length property is empty

*/

    @Test
    public void createLocation_length_14() throws Exception {
        LocationDto locationDto = new LocationDto();
        locationDto.setName("1");
        locationDto.setWidth(10.0);
        locationDto.setHeight(10.0);
        locationDto.setLength("");
        Floor floor = new Floor();
        floor.setId(Long.valueOf(1));
        locationDto.setFloor(floor);
        Section section = new Section();
        section.setId(Long.valueOf(1));
        locationDto.setSection(section);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/location/create")
                        .content(this.objectMapper.writeValueAsString(locationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

/**
     *
     * This function is used to check an input width property has correct format
     */


    @Test
    public void createLocation_width_15() throws Exception {
        LocationDto locationDto = new LocationDto();
        locationDto.setName("1");
        locationDto.setWidth("10.0");
        locationDto.setHeight(10.0);
        locationDto.setLength(10.0);
        Floor floor = new Floor();
        floor.setId(Long.valueOf(1));
        locationDto.setFloor(floor);
        Section section = new Section();
        section.setId(Long.valueOf(""));
        locationDto.setSection(section);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/location/create")
                        .content(this.objectMapper.writeValueAsString(locationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
/*
*
     *
     * This function is used to check an input height property has correct format

*/


    @Test
    public void createLocation_height_15() throws Exception {
        LocationDto locationDto = new LocationDto();
        locationDto.setName("1");
        locationDto.setWidth(10.0);
        locationDto.setHeight("10.0");
        locationDto.setLength(10.0);
        Floor floor = new Floor();
        floor.setId(Long.valueOf(1));
        locationDto.setFloor(floor);
        Section section = new Section();
        section.setId(Long.valueOf(""));
        locationDto.setSection(section);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/location/create")
                        .content(this.objectMapper.writeValueAsString(locationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
/**
     *
     * This function is used to check an input length property has correct format
     */


    @Test
    public void createLocation_length_15() throws Exception {
        LocationDto locationDto = new LocationDto();
        locationDto.setName("1");
        locationDto.setWidth(10.0);
        locationDto.setHeight(10.0);
        locationDto.setLength("10.0");
        Floor floor = new Floor();
        floor.setId(Long.valueOf(1));
        locationDto.setFloor(floor);
        Section section = new Section();
        section.setId(Long.valueOf(""));
        locationDto.setSection(section);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/location/create")
                        .content(this.objectMapper.writeValueAsString(locationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


/**
     *
     * This function is used to check when all input data is correct
     */

    @Test
    public void createLocation_18() throws Exception {
        LocationDto locationDto = new LocationDto();
        locationDto.setName("1");
        locationDto.setWidth(10.0);
        locationDto.setHeight(10.0);
        locationDto.setLength(10.0);
        Floor floor = new Floor();
        floor.setId(Long.valueOf(1));
        locationDto.setFloor(floor);
        Section section = new Section();
        section.setId(Long.valueOf(1));
        locationDto.setSection(section);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/location/create")
                        .content(this.objectMapper.writeValueAsString(locationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
