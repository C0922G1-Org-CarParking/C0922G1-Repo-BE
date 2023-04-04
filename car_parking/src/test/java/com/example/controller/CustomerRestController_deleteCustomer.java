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
public class CustomerRestController_deleteCustomer {
    @Autowired
    private MockMvc mockMvc;
    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function use to check delete customer with customer id is null
     * @throws Exception
     */
    @Test
    public void delete_id_25() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/customerReast/{id}/delete", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function use to check delete customer with customer id is ""
     * @throws Exception
     */
    @Test
    public void delete_id_26() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/customerReast/{id}/delete", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to check and delete customers whose customer id does not exist in the database
     * @throws Exception
     */
    @Test
    public void delete_id_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/customerReast/20/delete"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to check and delete customers with customer IDs in the database
     * @throws Exception
     */
    @Test
    public void delete_id_28() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/customerReast/1/delete"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to check and delete customers who have a customer ID in the
     * database but the vehicle's ticket validity period is still valid
     * @throws Exception
     */
    @Test
    public void delete_id_100() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/customerReast/2/delete"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
