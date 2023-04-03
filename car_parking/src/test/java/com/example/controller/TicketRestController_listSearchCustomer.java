package com.example.controller;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class TicketRestController_listSearchCustomer {
    @Autowired
    private MockMvc mockMvc;



    /**
     * tìm kiếm thông tin customer có tham số name = null
     * stauts: 400
     * @author HuyNV
     * @Date 30/03/2023
     */

    @Test
    public void searchCustomer_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/listSearchCustomer?name=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * tìm kiếm thông tin customer có tham số name = ''
     *stauts:400
     * @author HuyNV
     * @Date 30/03/2023
     */

    @Test
    public void searchCustomer_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/listSearchCustomer?name=''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * tìm kiếm thông tin customer có tham số name = rong không tồn tại trong database
     *status:400
     * @author HuyNV
     * @Date 30/03/2023
     */


    @Test
    public void searchCustomer_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/listSearchCustomer?name=rong"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * tìm kiếm thông tin customer có tham số name = 1000 không tồn tại trong databas và trả về mảng rỗng
     * status:400
     * @author HuyNV
     * @Date 30/03/2023
     */

    @Test
    public void searchCustomer_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/listSearchCustomer?name=1000"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * tìm kiếm thông tin customer có tham số name= Vu BD có trong database
     *status:200
     * @author HuyNV
     * @Date 30/03/2023
     */

    @Test
    public void searchCustomer_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/listSearchCustomer?name=Vu BD"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].id").value(1))
                .andExpect(jsonPath("[0].name").value("Vu BD"))
                .andExpect(jsonPath("[0].phoneNumber").value("1234567893"))

                .andExpect(jsonPath("[1].id").value(2))
                .andExpect(jsonPath("[1].name").value("Vu BD"))
                .andExpect(jsonPath("[1].phoneNumber").value("1234567894"));

    }






}
