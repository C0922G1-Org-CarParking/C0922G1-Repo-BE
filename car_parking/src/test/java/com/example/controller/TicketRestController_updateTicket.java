package com.example.controller;

import com.example.dto.TicketDto;
import com.example.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TicketRestController_updateTicket {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Created by: HuyNL
     * Date created: 30/03/2023
     * Function: test func updateTicket [effectiveDate] = null
     * @return
     */
    @Test
    public void updateTicket_effective_19() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate(null);
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate(null);
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));
        ticketDto.setExtension_date("2022-02-20");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket/update")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HuyNL
     * Date created: 30/03/2023
     * Function: test func updateTicket [expiryDate] = null
     * @return
     */

    @Test
    public void updateTicket_expiryDate_19() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("2020-03-12");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate(null);
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));
        ticketDto.setExtension_date("2022-02-20");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket/update")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: HuyNL
     * Date created: 30/03/2023
     * Function: test func updateTicket [floor] = null
     * @return
     */
    @Test
    public void updateTicket_floor_19() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("2019-10-06");
        ticketDto.setFloor(null);
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate("2020-11-06");
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));
        ticketDto.setExtension_date("2022-02-20");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket/update")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HuyNL
     * Date created: 30/03/2023
     * Function: test func updateTicket [section] = null
     * @return
     */
    @Test
    public void updateTicket_section_19() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("2019-10-06");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(null);
        ticketDto.setExpiryDate("2020-11-06");
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));
        ticketDto.setExtension_date("2022-02-20");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket/update")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HuyNL
     * Date created: 30/03/2023
     * Function: test func updateTicket [location] = null
     * @return
     */
    @Test
    public void updateTicket_location_19() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("2019-10-06");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate("2020-11-06");
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(null);
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));
        ticketDto.setExtension_date("2022-02-20");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket/update")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HuyNL
     * Date created: 30/03/2023
     * Function: test func updateTicket [ticketTyoe] = null
     * @return
     */
    @Test
    public void updateTicket_ticketType_19() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("2019-10-06");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate("06-11-2020");
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(null);
        ticketDto.setExtension_date("2022-02-20");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket/update")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: HuyNL
     * Date created: 30/03/2023
     * Function: test func updateTicket [extensionDate] = null
     * @return
     */
    @Test
    public void updateTicket_extensionDate_19() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("2019-10-06");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate("06-11-2020");
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(null);
        ticketDto.setExtension_date(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket/update")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: HuyNL
     * Date created: 30/03/2023
     * Function: test func updateTicket [carPlateNumber] = null
     * @return
     */
    @Test
    public void updateTicket_carPlate_19() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("2019-10-06");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate("06-11-2020");
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(null);
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(null);
        ticketDto.setExtension_date("2022-02-20");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket/update")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: HuyNL
     * Date created: 30/03/2023
     * Function: test func updateTicket  [nameCustomer] = null
     * @return
     */
    @Test
    public void updateTicket_nameCustomer_19() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("2019-10-06");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate("2023-02-20");
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));
        ticketDto.setExtension_date("2022-02-20");
        ticketDto.setCustomer(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket/update")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: HuyNL
     * Date created: 30/03/2023
     * Function: test func updateTicket  [totalPrice] = null
     * @return
     */
    @Test
    public void updateTicket_totalPrice_19() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("2019-10-06");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate("2023-02-20");
        ticketDto.setTotalPrice(null);
        ticketDto.setDeleted(false);
        ticketDto.setCar(null);
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));
        ticketDto.setExtension_date("2022-02-20");
        ticketDto.setCustomer(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket/update")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    /**
     * Created by: HuyNL
     * Date created: 30/03/2023
     * Function: test func updateTicket_effectiveDate_20() [effectiveDate] = ""
     * @return
     */
    @Test
    public void updateTicket_effectiveDate_20() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate("2020-03-19");
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(null);
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(null);
        ticketDto.setExtension_date("2022-02-20");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket/update")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: HuyNL
     * Date created: 30/03/2023
     * Function: test func updateTicket_expiryDate_20() [expiryeDate] = ""
     * @return
     */
    @Test
    public void updateTicket_expiryDate_20() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("2020-03-19");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate("");
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(null);
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(null);
        ticketDto.setExtension_date("2022-02-20");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket/update")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: HuyNL
     * Date created: 30/03/2023
     * Function: test func updateTicket_extensionDate_20() [extensionDate] = ""
     * @return
     */
    @Test
    public void updateTicket_totalPrice_20() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("2020-03-19");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate("");
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(null);
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(null);
        ticketDto.setExtension_date("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket/update")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HuyNL
     * Date created: 30/03/2023
     * Function: test func updateTicket_totalPrice_21() [totalPrice] is wrong format
     * @return
     */
    @Test
    public void updateTicket_21() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("10-06");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate("2020-11-06");
        ticketDto.setTotalPrice(-250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));
        ticketDto.setExtension_date("2022-12-22");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket/update")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: HuyNL
     * Date created: 30/03/2023
     * Function: test func updateTicket_effectiveDate_21() [effectiveDate] is wrong format
     * @return
     */
    @Test
    public void updateTicket_effectiveDate_21() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("09-10-2022");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate("2020-11-06");
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));
        ticketDto.setExtension_date("2022-12-22");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket/update")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: HuyNL
     * Date created: 30/03/2023
     * Function: test func updateTicket_expiryDate_21() [expiryDate] is wrong format
     * @return
     */
    @Test
    public void updateTicket_expiryDate_21() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("2022-10-04");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate("12-2023-06");
        ticketDto.setTotalPrice(250.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));
        ticketDto.setExtension_date("2022-12-22");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/ticket/update")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: HuyNL
     * Date created: 30/03/2023
     * Function: test func updateTicket_24() test update complete
     * @return
     */
    @Test
    public void updateTicket_24() throws Exception {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setEffectiveDate("2023-10-20");
        ticketDto.setFloor(new Floor(1L));
        ticketDto.setSection(new Section(1L));
        ticketDto.setExpiryDate("2020-11-06");
        ticketDto.setTotalPrice(40.000);
        ticketDto.setDeleted(false);
        ticketDto.setCar(new Car(1L));
        ticketDto.setLocation(new Location(1L));
        ticketDto.setEmployee(new Employee(1L));
        ticketDto.setTicketType(new TicketType(1L));
        ticketDto.setExtension_date("2022-12-22");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/update")
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
