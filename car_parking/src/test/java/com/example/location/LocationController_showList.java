package com.example.location;

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
public class LocationController_showList {

    /**
     * Created by: BaoHX
     * Date created: 30/03/2023
     * Function: list location
     *
     * @param "pageable, search"
     * @return HttpStatus.Bad_Request if result is null or HttpStatus.OK is result is not error
     */


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void showList_5() throws Exception {
         this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/location/list?search=2"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void showList_6() throws Exception{
this.mockMvc.perform(MockMvcRequestBuilders.get("/location/list?page=0"))
        .andDo(print())
        .andExpect(status().is2xxSuccessful())
        .andExpect(jsonPath("content[0].id").value(1))
        .andExpect(jsonPath("content[0].name").value("1"))
        .andExpect(jsonPath("content[0].length").value(5.0))
        .andExpect(jsonPath("content[0].height").value(6.0))
        .andExpect(jsonPath("content[0].width").value(6.0))
        .andExpect(jsonPath("content[0].floorId").value(1))
        .andExpect(jsonPath("content[0].sectionId").value(1));
    }

}
