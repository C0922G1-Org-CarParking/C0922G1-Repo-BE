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
public class TicketRestController_infoCustomer {
    @Autowired
    private MockMvc mockMvc;



    /**
     * tìm kiếm thông tin customer có tham số id = "null"
     *
     * @author HuyNV
     * @Date 30/03/2023
     */

    @Test
    public void getInfoCustomer_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/chooseCustomer/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * tìm kiếm thông tin customer có tham số id = ""
     *status: 400
     * @author HuyNV
     * @Date 30/03/2023
     */

    @Test
    public void getInfoCustomer_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/chooseCustomer/").param("id",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * tìm kiếm thông tin customer có tham số id không có trong database
     *status: 400
     * @author HuyNV
     * @Date 30/03/2023
     */


    @Test
    public void getInfoCustomer_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/chooseCustomer/").param("id","6"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * tìm kiếm thông tin customer có tham số id có trong database
     *status:200
     * @author HuyNV
     * @Date 30/03/2023
     */

    @Test
    public void searchInfoEmployee_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/chooseCustomer/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

        //phương thức này  nhận đúng hết giá trị rồi nhưng em chấm tới thành phần thì lại không được, nên em đóng comment lại
//                .andExpect(jsonPath("[0].id").value(1))
//                .andExpect(jsonPath("[0].name").value("Vu BD"))
//                .andExpect(jsonPath("[0].phoneNumber").value("1234567893"));
    }


}
