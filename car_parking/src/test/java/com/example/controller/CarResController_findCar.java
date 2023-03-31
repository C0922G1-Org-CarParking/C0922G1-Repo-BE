package com.example.controller;

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
public class CarResController_findCar {
    @Autowired
    private MockMvc mockMvc;

    /**
     * This function use to test list car of all field search is null
     *
     * @author HuyNL
     * @Date 30/03/2023
     */
    @Test
    public void getPageCar_7() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/findCarIn?plate=null&phone=null&name=null&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function use to test list car of all field search is '', page = 0
     *
     * @author HuyNL
     * @Date 30/03/2023
     */
    @Test
    public void searchCustomer_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/car-in-out/findCarIn?plate=''&phone=''&name=''&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * This function use to test list car of plate search is 13A1-456789
     *
     * @author HuyNL
     * @Date 30/03/2023
     */

    @Test
    public void getPageCar_plateNumberSearch_9() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/findCarIn?plate=13A1-456789&phone=&name=&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function use to test list car of name search is Hoang
     *
     * @author HuyNL
     * @Date 30/03/2023
     */
    @Test
    public void getPageCar_nameSearch_9() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/findCarIn?plate=&phone=&name=Hoang&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function use to test list car of phone search is 0777277278
     *
     * @author HuyNL
     * @Date 30/03/2023
     */

    @Test
    public void getPageCar_phoneSearch_9() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/findCarIn?plate=&phone=0777277278&name=&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function use to test list car of all field search is character special
     *
     * @author HuyNL
     * @Date 30/03/2023
     */
    @Test
    public void getPageCar_search_9() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/findCarIn?plate=@&phone=abc&name=$&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function use to test list car of name search is Huy but is_deleted = true
     *
     * @author HuyNL
     * @Date 30/03/2023
     */
    @Test
    public void getPageCar_nameCustomer_10() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/findCarIn?plate=&phone=&name=Hai&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function use to test list car of all field search is plate=75B-11111, nameSearch=Huy NL, phone=0905275275, page = 0
     *
     * @author HuyNL
     * @Date 30/03/2023
     */
    @Test
    public void getPageCar_8() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/car-in-out/findCarIn?plate=75B-11111&phone=0905275275&name=Huy NL&page=0").param(""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("size").value(3))
                .andExpect(jsonPath("number").value(0))
                .andExpect(jsonPath("content[0].cardId").value(2))
                .andExpect(jsonPath("content[0].carPlateNumber").value("75B-11111"))
                .andExpect(jsonPath("content[0].carName").value("CX5"))
                .andExpect(jsonPath("content[0].carBrand").value("Mazda"))
                .andExpect(jsonPath("content[0].carTypeName").value("7 Ch?"))
                .andExpect(jsonPath("content[0].customerName").value("Huy NL"))
                .andExpect(jsonPath("content[0].customerPhoneNumber").value("0905275275"))
                .andExpect(jsonPath("content[0].locationName").value("B2"))
                .andExpect(jsonPath("content[0].floorName").value("1"));
    }

}
