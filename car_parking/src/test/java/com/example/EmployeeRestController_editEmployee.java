package com.example;

import com.example.dto.EmployeeDto;
import com.example.model.Position;
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
public class EmployeeRestController_editEmployee {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    //------------------------------------------- TEST UPDATE EMPLOYEE
    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func pdateEmployee_name_19() [name] = null
     * @return
     */
    @Test
    public void updateEmployee_name_19() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName(null);
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tu@gmail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("999999999");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("0124311989");
        employeeDto.setProvince(1);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func updateEmployee_mail_19() with item  [mail] null  "defaultMessage":"email không ???c ?? tr?ng",
     * @return
     */
    @Test
    public void updateEmployee_mail_19() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail(null);
        employeeDto.setGender(false);
        employeeDto.setIdCard("999999999");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("0124311989");
        employeeDto.setProvince(1);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func updateEmployee_IdCard_19() with item  [idCard] null
     * @return
     */
    @Test
    public void updateEmployee_IdCard_19() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tu@gmail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard(null);
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("0123466788");
        employeeDto.setProvince(1);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func updateEmployee_DateOfBirth_19() with item  [DateOfBirth] null
     * @return
     */
    @Test
    public void updateEmployee_DateOfBirth_19() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tu@gmail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("01010101");
        employeeDto.setDateOfBirth(null);
        employeeDto.setPhoneNumber("0123466788");
        employeeDto.setProvince(1);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func updateEmployee_PhoneNumber_19() with item  [PhoneNumber] null
     * @return
     */
    @Test
    public void  updateEmployee_PhoneNumber_19() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tu@gmail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("01010101");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber(null);
        employeeDto.setProvince(1);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func updateEmployee_street_19() with item  [street] null
     * @return
     */
    @Test
    public void updateEmployee_street_19() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tu@gmail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("01010101");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("0123466788");
        employeeDto.setProvince(1);
        employeeDto.setStreet(null);
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func updateEmployee_position_19() with item  [position] null
     * @return
     */
    @Test
    public void updateEmployee_position_19()  throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tu@gmail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("01010101");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("0123466788");
        employeeDto.setProvince(1);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(null));
//        employeeDto.setPosition(employeeDto.getPosition());


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }







    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func updateEmployee_name_20() [name] = ""
     * @return
     */
    @Test
    public void updateEmployee_name_20() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tu@gmail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("999999999");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("0124311989");
        employeeDto.setProvince(1);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func updateEmployee_mail_20() with item  [mail] ""  "defaultMessage":"email không ???c ?? tr?ng",
     * @return
     */

    @Test
    public void updateEmployee_mail_20() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("");
        employeeDto.setGender(false);
        employeeDto.setIdCard("999999999");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("0124311989");
        employeeDto.setProvince(1);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func updateEmployee_IdCard_20() with item  [idCard] ""
     * @return
     */

    @Test
    public void updateEmployee_IdCard_20() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tu@gmail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("0123466788");
        employeeDto.setProvince(1);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func updateEmployee_DateOfBirth_20() with item  [DateOfBirth] ""
     * @return
     */
    @Test
    public void updateEmployee_DateOfBirth_20() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tu@gmail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("01010101");
        employeeDto.setDateOfBirth("");
        employeeDto.setPhoneNumber("0123466788");
        employeeDto.setProvince(1);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func updateEmployee_PhoneNumber_20() with item  [PhoneNumber] ""
     * @return
     */
    @Test
    public void  updateEmployee_PhoneNumber_20() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tu@gmail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("01010101");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("");
        employeeDto.setProvince(1);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func updateEmployee_street_20() with item  [street] ""
     * @return
     */
    @Test
    public void updateEmployee_street_20() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tu@gmail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("01010101");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("0123466788");
        employeeDto.setProvince(1);
        employeeDto.setStreet("");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }






























    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func updateEmployee_idCard_21() with item  setIdCard("01010101") errors regex
     * @Pattern(regexp = "(\\d{9})|(\\d{12})",message = "số cmnd phải đúng định dạng,
     * vd:XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9).")
     * @return
     */
    @Test
    public void updateEmployee_idCard_21() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tu@gmail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("01010101");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("0124311989");
        employeeDto.setProvince(1);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func updateEmployee_name_21()
     * @return
     */
    @Test
    public void updateEmployee_name_21() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("Nguyen Tu1");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tu@gmail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("01010101");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("0123466788");
        employeeDto.setProvince(1);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_email_21()
     * @return
     */
    @Test
    public void updateEmployee_email_21() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tumail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("01010101");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("0123466788");
        employeeDto.setProvince(1);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_email_21()
     * @return
     */
    @Test
    public void updateEmployee_phoneNumber_21() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tumail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("01010101");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("12");
        employeeDto.setProvince(1);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }







    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func updateEmployee_province_22() with province(-5) errors Min(value=0)
     * @return
     */
    @Test
    public void updateEmployee_province_22() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tu@gmail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("01010101");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("0124311989");
        employeeDto.setProvince(-5);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func updateEmployee_district_22() with district(-5) errors Min(value=0)
     * @return
     */
    @Test
    public void updateEmployee_district_22() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(-5);
        employeeDto.setEmail("tu@gmail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("091010101");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("0123466788");
        employeeDto.setProvince(1);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func updateEmployee_commune_22()  with commune(-5) errors Min(value=0)
     * @return
     */
    @Test
    public void updateEmployee_commune_22() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(-5);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tu@gmail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("091010101");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("0123466788");
        employeeDto.setProvince(1);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }










    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func updateEmployee_province_23() with province(80) errors Max(value=63) "defaultMessage":"must be less than or equal to 63"
     * @return
     */

    @Test
    public void updateEmployee_province_23() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tu@gmail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("01010101");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("0124311989");
        employeeDto.setProvince(80);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func updateEmployee_all_24() test successful
     * @return
     */
    @Test
    public void updateEmployee_all_24() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setName("Nguyen Tuan Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tu@gmail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("01010101");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("0124311989");
        employeeDto.setProvince(80);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/update-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


}
