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
public class CustomerRestController_getListCustomer {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to output a list of customers on the size equal to 0
     *
     * @throws Exception
     */
    @Test
    public void getListCustomer_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customerReast/list?page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to output a list of customers on the page equal to 0
     *
     * @throws Exception
     */
    @Test
    public void getListCustomer_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customerReast/list?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(4))
                .andExpect(jsonPath("totalElements").value(8))
                .andExpect(jsonPath("content[0].name").value("Bùi Đức Vũ"))
                .andExpect(jsonPath("content[0].date_of_birth").value("1990-01-15"))
                .andExpect(jsonPath("content[0].id_card").value("197256401"))
                .andExpect(jsonPath("content[1].name").value("Nguyễn Ngọc Hậu"))
                .andExpect(jsonPath("content[1].date_of_birth").value("2004-11-15"))
                .andExpect(jsonPath("content[1].id_card").value("197256707"));
    }

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to search by customer name when customer name is "null"
     */
    @Test
    public void getListCustomer_name_1() {
//        this case is already set (required = false, defaultValue = "") in controller, so this case cannot happen
    }

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to search by customer name when customer name is ""
     */
    @Test
    public void getListCustomer_name_2() {
//        this case is already set (required = false, defaultValue = "") in controller, so this case cannot happen
    }

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to search by customer name when the customer name does not exist in the database
     *
     * @throws Exception
     */
    @Test
    public void getListCustomer_name_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customerReast/list?name=Bao"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to search by customer name when the customer name is in the database
     *
     * @throws Exception
     */
    @Test
    public void getListCustomer_name_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customerReast/list?name=Vu"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].name").value("Bùi Đức Vũ"))
                .andExpect(jsonPath("content[0].date_of_birth").value("1990-01-15"))
                .andExpect(jsonPath("content[0].id_card").value("197256401"));
    }

//    idCard

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to search by customer idCard when customer idCard is "null"
     */
    @Test
    public void getListCustomer_idCard_1() {
//        this case is already set (required = false, defaultValue = "") in controller, so this case cannot happen
    }

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to search by customer idCard when customer idCard is ""
     */
    @Test
    public void getListCustomer_idCard_2() {
//        this case is already set (required = false, defaultValue = "") in controller, so this case cannot happen
    }

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to search by customer idCard when the customer idCard does not exist in the database
     *
     * @throws Exception
     */
    @Test
    public void getListCustomer_idCard_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customerReast/list?idCard=Bao"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to search by customer idCard when the customer idCard is in the database
     *
     * @throws Exception
     */
    @Test
    public void getListCustomer_idCard_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customerReast/list?idCard=197256401"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].name").value("Bùi Đức Vũ"))
                .andExpect(jsonPath("content[0].date_of_birth").value("1990-01-15"))
                .andExpect(jsonPath("content[0].id_card").value("197256401"));
    }

//    phoneNumber

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to search by customer phoneNumber when customer phoneNumber is "null"
     */
    @Test
    public void getListCustomer_phoneNumber_1() {
//        this case is already set (required = false, defaultValue = "") in controller, so this case cannot happen
    }

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to search by customer phoneNumber when customer phoneNumber is ""
     */
    @Test
    public void getListCustomer_phoneNumber_2() {
//        this case is already set (required = false, defaultValue = "") in controller, so this case cannot happen
    }

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to search by customer phoneNumber when the customer phoneNumber does not exist in the database
     *
     * @throws Exception
     */
    @Test
    public void getListCustomer_phoneNumber_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customerReast/list?phoneNumber=Bao"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to search by customer phoneNumber when the customer phoneNumber is in the database
     *
     * @throws Exception
     */
    @Test
    public void getListCustomer_phoneNumber_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customerReast/list?phoneNumber=0899868444"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].name").value("Bùi Đức Vũ"))
                .andExpect(jsonPath("content[0].date_of_birth").value("1990-01-15"))
                .andExpect(jsonPath("content[0].phone_number").value("0899868444"))
                .andExpect(jsonPath("content[0].id_card").value("197256401"));
    }
//     from the date of birth

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to search by customer from the date of birth when customer from the date of birth is "null"
     */
    @Test
    public void getListCustomer_starDate_1() {
//        this case is already set (required = false, defaultValue = "") in controller, so this case cannot happen
    }

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to search by customer from the date of birth when customer from the date of birth is ""
     */
    @Test
    public void getListCustomer_starDate_2() {
//        this case is already set (required = false, defaultValue = "") in controller, so this case cannot happen
    }

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to search by customer from the date of birth when the customer from the
     * date of birth does not exist in the database
     *
     * @throws Exception
     */
    @Test
    public void getListCustomer_starDate_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customerReast/list?starDate=2009-01-01"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to search by customer from the date of birth when the customer from the
     * date of birth is in the database
     *
     * @throws Exception
     */
    @Test
    public void getListCustomer_starDate_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customerReast/list?starDate=2004-11-15"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].name").value("Nguyễn Ngọc Hậu"))
                .andExpect(jsonPath("content[0].date_of_birth").value("2004-11-15"))
                .andExpect(jsonPath("content[0].phone_number").value("0905789789"))
                .andExpect(jsonPath("content[0].id_card").value("197256707"));
    }
//    to the date of birth

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to search by customer to the date of birth when customer to the date of birth is "null"
     */
    @Test
    public void getListCustomer_endDate_1() {
//        this case is already set (required = false, defaultValue = "") in controller, so this case cannot happen
    }

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to search by customer to the date of birth when customer to the date of birth is ""
     */
    @Test
    public void getListCustomer_endDate_2() {
//        this case is already set (required = false, defaultValue = "") in controller, so this case cannot happen
    }

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to search by customer to the date of birth when the customer to the
     * date of birth does not exist in the database
     *
     * @throws Exception
     */
    @Test
    public void getListCustomer_endDate_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customerReast/list?endDate=1990-01-01"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: VuBD
     * Date created: 30/03/2023
     * function: This function is used to search by customer to the date of birth when the customer to the
     * date of birth is in the database
     *
     * @throws Exception
     */
    @Test
    public void getListCustomer_endDate_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/customerReast/list?endDate=1990-01-15"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].name").value("Bùi Đức Vũ"))
                .andExpect(jsonPath("content[0].date_of_birth").value("1990-01-15"))
                .andExpect(jsonPath("content[0].phone_number").value("0899868444"))
                .andExpect(jsonPath("content[0].id_card").value("197256401"));
    }
}
