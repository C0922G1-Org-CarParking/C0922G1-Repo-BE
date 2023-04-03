//package com.example.controller;
//
//import com.example.dto.TicketDto;
//import com.example.model.Car;
//import com.example.model.Employee;
//import com.example.model.Location;
//import com.example.model.TicketType;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class TicketRestController_createTicket {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//
//
//
//    @Test
//    public void createStudent_effective_date_13() throws Exception {
//
//        /* Created by: HuyNV
//         * Date created: 30/03/2023
//         * Test: test null of field EffectiveDate
//         * return: status: 400
//         */
//
//        TicketDto ticketDto = new TicketDto();
//        ticketDto.setEffectiveDate(null);
//        ticketDto.setExpiryDate("2020-11-06");
//        ticketDto.setTotalPrice(250.000);
//        ticketDto.setDeleted(false);
//        ticketDto.setCar(new Car(1L));
//        ticketDto.setLocation(new Location(1L));
//        ticketDto.setEmployee(new Employee(1L));
//        ticketDto.setTicketType(new TicketType(1L));
//        ticketDto.setPrice(50.000);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/ticket/createTicket")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createStudent_expiry_date_13() throws Exception {
//
//        /* Created by: HuyNV
//         * Date created: 30/03/2023
//         * Test: test null of field ExpiryDate
//         * return: status: 400
//         */
//
//        TicketDto ticketDto = new TicketDto();
//        ticketDto.setEffectiveDate("2020-10-04");
//        ticketDto.setExpiryDate(null);
//        ticketDto.setTotalPrice(250.000);
//        ticketDto.setDeleted(false);
//        ticketDto.setCar(new Car(1L));
//        ticketDto.setLocation(new Location(1L));
//        ticketDto.setEmployee(new Employee(1L));
//        ticketDto.setTicketType(new TicketType(1L));
//        ticketDto.setPrice(50.000);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/ticket/createTicket")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createStudent_TotalPrice_13() throws Exception {
//
//        /* Created by: HuyNV
//         * Date created: 30/03/2023
//         * Test: test null of field expiry_date
//         * return: status: 400
//         */
//
//        TicketDto ticketDto = new TicketDto();
//        ticketDto.setEffectiveDate("2020-10-04");
//        ticketDto.setExpiryDate("2020-11-09");
//        ticketDto.setTotalPrice(null);
//        ticketDto.setDeleted(false);
//        ticketDto.setCar(new Car(1L));
//        ticketDto.setLocation(new Location(1L));
//        ticketDto.setEmployee(new Employee(1L));
//        ticketDto.setTicketType(new TicketType(1L));
//        ticketDto.setPrice(50.000);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/ticket/createTicket")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createStudent_Car_13() throws Exception {
//
//        /* Created by: HuyNV
//         * Date created: 30/03/2023
//         * Test: test null of field expiry_date
//         * return: status: 400
//         */
//
//        TicketDto ticketDto = new TicketDto();
//        ticketDto.setEffectiveDate("2020-10-04");
//        ticketDto.setExpiryDate("2020-11-09");
//        ticketDto.setTotalPrice(250.000);
//        ticketDto.setDeleted(false);
////        ticketDto.setCar(new Car(null));
//        ticketDto.setLocation(new Location(1L));
//        ticketDto.setEmployee(new Employee(1L));
//        ticketDto.setTicketType(new TicketType(1L));
//        ticketDto.setPrice(50.000);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/ticket/createTicket")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createStudent_Location_13() throws Exception {
//
//        /* Created by: HuyNV
//         * Date created: 30/03/2023
//         * Test: test null of field expiry_date
//         * return: status: 400
//         */
//
//        TicketDto ticketDto = new TicketDto();
//        ticketDto.setEffectiveDate("2020-10-04");
//        ticketDto.setExpiryDate("2020-11-09");
//        ticketDto.setTotalPrice(250.000);
//        ticketDto.setDeleted(false);
//        ticketDto.setCar(new Car(1L));
//        ticketDto.setLocation(new Location(null));
//        ticketDto.setEmployee(new Employee(1L));
//        ticketDto.setTicketType(new TicketType(1L));
//        ticketDto.setPrice(50.000);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/ticket/createTicket")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createStudent_Employee_13() throws Exception {
//
//        /* Created by: HuyNV
//         * Date created: 30/03/2023
//         * Test: test null of field expiry_date
//         * return: status: 400
//         */
//
//        TicketDto ticketDto = new TicketDto();
//        ticketDto.setEffectiveDate("2020-10-04");
//        ticketDto.setExpiryDate("2020-11-09");
//        ticketDto.setTotalPrice(250.000);
//        ticketDto.setDeleted(false);
//        ticketDto.setCar(new Car(1L));
//        ticketDto.setLocation(new Location(1L));
//        ticketDto.setEmployee(new Employee(null));
//        ticketDto.setTicketType(new TicketType(1L));
//        ticketDto.setPrice(50.000);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/ticket/createTicket")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createStudent_TicketType_13() throws Exception {
//
//        /* Created by: HuyNV
//         * Date created: 30/03/2023
//         * Test: test null of field expiry_date
//         * return: status: 400
//         */
//
//        TicketDto ticketDto = new TicketDto();
//        ticketDto.setEffectiveDate("2020-10-04");
//        ticketDto.setExpiryDate("2020-11-09");
//        ticketDto.setTotalPrice(250.000);
//        ticketDto.setDeleted(false);
//        ticketDto.setCar(new Car(1L));
//        ticketDto.setLocation(new Location(1L));
//        ticketDto.setEmployee(new Employee(1L));
//        ticketDto.setTicketType(new TicketType(null));
//        ticketDto.setPrice(50.000);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/ticket/createTicket")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createStudent_Price_13() throws Exception {
//
//        /* Created by: HuyNV
//         * Date created: 30/03/2023
//         * Test: test null of field expiry_date
//         * return: status: 400
//         */
//
//        TicketDto ticketDto = new TicketDto();
//        ticketDto.setEffectiveDate("2020-10-04");
//        ticketDto.setExpiryDate("2020-11-09");
//        ticketDto.setTotalPrice(250.000);
//        ticketDto.setDeleted(false);
//        ticketDto.setCar(new Car(1L));
//        ticketDto.setLocation(new Location(1L));
//        ticketDto.setEmployee(new Employee(1L));
//        ticketDto.setTicketType(new TicketType(1L));
//        ticketDto.setPrice(null);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/ticket/createTicket")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createStudent_effective_date_14() throws Exception {
//
//        /* Created by: HuyNV
//         * Date created: 30/03/2023
//         * Test: test " " of field EffectiveDate
//         * return: status: 400
//         */
//
//        TicketDto ticketDto = new TicketDto();
//        ticketDto.setEffectiveDate(" ");
//        ticketDto.setExpiryDate("2020-11-06");
//        ticketDto.setTotalPrice(250.000);
//        ticketDto.setDeleted(false);
//        ticketDto.setCar(new Car(1L));
//        ticketDto.setLocation(new Location(1L));
//        ticketDto.setEmployee(new Employee(1L));
//        ticketDto.setTicketType(new TicketType(1L));
//        ticketDto.setPrice(50.000);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/ticket/createTicket")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createStudent_expiry_date_14() throws Exception {
//
//        /* Created by: HuyNV
//         * Date created: 30/03/2023
//         * Test: test " " of field ExpiryDate
//         * return: status: 400
//         */
//
//        TicketDto ticketDto = new TicketDto();
//        ticketDto.setEffectiveDate("2020-10-04");
//        ticketDto.setExpiryDate(" ");
//        ticketDto.setTotalPrice(250.000);
//        ticketDto.setDeleted(false);
//        ticketDto.setCar(new Car(1L));
//        ticketDto.setLocation(new Location(1L));
//        ticketDto.setEmployee(new Employee(1L));
//        ticketDto.setTicketType(new TicketType(1L));
//        ticketDto.setPrice(50.000);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/ticket/createTicket")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    @Test
//    public void createStudent_effective_date_15() throws Exception {
//
//        /* Created by: HuyNV
//         * Date created: 29/03/2023
//         * Test: test format "đúng định dạng yyyy-mm-dd "
//         * return: status: 400
//         */
//
//        TicketDto ticketDto = new TicketDto();
//
//        ticketDto.setEffectiveDate("-2021");
//        ticketDto.setExpiryDate("2020-10-04");
//        ticketDto.setTotalPrice(250.000);
//        ticketDto.setDeleted(false);
//        ticketDto.setCar(new Car(1L));
//        ticketDto.setLocation(new Location(1L));
//        ticketDto.setEmployee(new Employee(1L));
//        ticketDto.setTicketType(new TicketType(1L));
//        ticketDto.setPrice(50.000);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/ticket/createTicket")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//
//    @Test
//    public void createStudent_expiry_date_15() throws Exception {
//
//        /* Created by: HuyNV
//         * Date created: 29/03/2023
//         * Test: test format "đúng định dạng yyyy-mm-dd "
//         * return: status: 400
//         */
//
//        TicketDto ticketDto = new TicketDto();
//
//        ticketDto.setEffectiveDate("2020-08-12");
//        ticketDto.setExpiryDate("25/11");
//        ticketDto.setTotalPrice(250.000);
//        ticketDto.setDeleted(false);
//        ticketDto.setCar(new Car(1L));
//        ticketDto.setLocation(new Location(1L));
//        ticketDto.setEmployee(new Employee(1L));
//        ticketDto.setTicketType(new TicketType(1L));
//        ticketDto.setPrice(50.000);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/ticket/createTicket")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void createStudent_TotalPrice_15() throws Exception {
//
//        /* Created by: HuyNV
//         * Date created: 29/03/2023
//         * Test: test format totalPrice min = 0
//         * return: status: 400
//         */
//
//        TicketDto ticketDto = new TicketDto();
//
//        ticketDto.setEffectiveDate("12/08/2021");
//        ticketDto.setExpiryDate("25/11");
//        ticketDto.setTotalPrice(-1.2);
//        ticketDto.setDeleted(false);
//        ticketDto.setCar(new Car(1L));
//        ticketDto.setLocation(new Location(1L));
//        ticketDto.setEmployee(new Employee(1L));
//        ticketDto.setTicketType(new TicketType(1L));
//        ticketDto.setPrice(50.000);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/ticket/createTicket")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    @Test
//    public void createStudent_Price_15() throws Exception {
//
//        /* Created by: HuyNV
//         * Date created: 29/03/2023
//         * Test: test format totalPrice min = 0
//         * return: status: 400
//         */
//
//        TicketDto ticketDto = new TicketDto();
//
//        ticketDto.setEffectiveDate("2020-11-12");
//        ticketDto.setExpiryDate("2020-12-12");
//        ticketDto.setTotalPrice(-1.2);
//        ticketDto.setDeleted(false);
//        ticketDto.setCar(new Car(1L));
//        ticketDto.setLocation(new Location(1L));
//        ticketDto.setEmployee(new Employee(1L));
//        ticketDto.setTicketType(new TicketType(1L));
//        ticketDto.setPrice(-50.000);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/ticket/createTicket")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//
//    @Test
//    public void createStudent_effective_date_16() throws Exception {
//
//        /* Created by: HuyNV
//         * Date created: 29/03/2023
//         * Test: min length effective_date is 2
//         * return: status: 400
//         */
//
//        TicketDto ticketDto = new TicketDto();
//
//        ticketDto.setEffectiveDate("9");
//        ticketDto.setExpiryDate("2020-11-12");
//        ticketDto.setTotalPrice(250.000);
//        ticketDto.setDeleted(false);
//        ticketDto.setCar(new Car(1L));
//        ticketDto.setLocation(new Location(1L));
//        ticketDto.setEmployee(new Employee(1L));
//        ticketDto.setTicketType(new TicketType(1L));
//        ticketDto.setPrice(50.000);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/ticket/createTicket")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    @Test
//    public void createStudent_expiry_date_16() throws Exception {
//
//        /* Created by: HuyNV
//         * Date created: 29/03/2023
//         * Test: min length effective_date is 2
//         * return: status: 400
//         */
//
//        TicketDto ticketDto = new TicketDto();
//
//        ticketDto.setEffectiveDate("2020-11-12");
//        ticketDto.setExpiryDate("7");
//        ticketDto.setTotalPrice(250.000);
//        ticketDto.setDeleted(false);
//        ticketDto.setCar(new Car(1L));
//        ticketDto.setLocation(new Location(1L));
//        ticketDto.setEmployee(new Employee(1L));
//        ticketDto.setTicketType(new TicketType(1L));
//        ticketDto.setPrice(50.000);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/ticket/createTicket")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    @Test
//    public void createStudent_effective_date_17() throws Exception {
//
//        /* Created by: HuyNV
//         * Date created: 29/03/2023
//         * Test: max length effective_date is 12
//         * return: status: 400
//         */
//
//        TicketDto ticketDto = new TicketDto();
//
//        ticketDto.setEffectiveDate("100000000000000");
//        ticketDto.setExpiryDate("2020-11-12");
//        ticketDto.setTotalPrice(250.000);
//        ticketDto.setDeleted(false);
//        ticketDto.setCar(new Car(1L));
//        ticketDto.setLocation(new Location(1L));
//        ticketDto.setEmployee(new Employee(1L));
//        ticketDto.setTicketType(new TicketType(1L));
//        ticketDto.setPrice(50.000);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/ticket/createTicket")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    @Test
//    public void createStudent_expiry_date_17() throws Exception {
//
//        /* Created by: HuyNV
//         * Date created: 29/03/2023
//         * Test: max length expiry_date is 12
//         * return: status: 400
//         */
//
//        TicketDto ticketDto = new TicketDto();
//
//        ticketDto.setEffectiveDate("2020-11-12");
//        ticketDto.setExpiryDate("233323122545546546");
//        ticketDto.setTotalPrice(250.000);
//        ticketDto.setDeleted(false);
//        ticketDto.setCar(new Car(1L));
//        ticketDto.setLocation(new Location(1L));
//        ticketDto.setEmployee(new Employee(1L));
//        ticketDto.setTicketType(new TicketType(1L));
//        ticketDto.setPrice(50.000);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/ticket/createTicket")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//
//
//
//
//
//    @Test
//    public void createStudent_all_18() throws Exception {
//
//        /* Created by: HuyNV
//         * Date created: 29/03/2023
//         * Test: test add complete
//         * return: status: 200
//         */
//
//        TicketDto ticketDto = new TicketDto();
//
//        ticketDto.setEffectiveDate("2020-11-12");
//        ticketDto.setExpiryDate("2020-12-12");
//        ticketDto.setTotalPrice(250.000);
//        ticketDto.setDeleted(false);
//        ticketDto.setCar(new Car(1L));
//        ticketDto.setLocation(new Location(1L));
//        ticketDto.setEmployee(new Employee(1L));
//        ticketDto.setTicketType(new TicketType(1L));
//        ticketDto.setPrice(50.000);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/ticket/createTicket")
//                        .content(this.objectMapper.writeValueAsString(ticketDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//
//
//
//
//
//
//
//
//
//
//}