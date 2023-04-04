package com.example.location;

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
public class LocationController_delete {
    @Autowired
    private MockMvc mockMvc;
    /**
     * Created by: BaoHX
     * Date created: 30/03/2023
     * Function: delete location
     *
     * @param "id"
     * @return HttpStatus.Bad_Request if result is null or HttpStatus.OK is result is not error
     */

    @Test
    public void delete_25() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/location/delete/{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void delete_26() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/location/delete/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void delete_27() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/location/delete/{id}","256"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void delete_28() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/location/delete/{id}","3"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
