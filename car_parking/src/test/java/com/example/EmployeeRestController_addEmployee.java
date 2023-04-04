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
public class EmployeeRestController_addEmployee {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

//------------------------------------------- TEST CREATE EMPLOYEE
    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_name_13 with item  [name] null
     * @return
     */
    @Test
    public void createEmployee_name_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(null);
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
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_mail_13 with item  [mail] null  "defaultMessage":"email không ???c ?? tr?ng",
     * @return
     */
    @Test
    public void createEmployee_mail_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail(null);
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
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_idCard_13 with item  [idCard] null
     * @return
     */
    @Test
    public void createEmployee_idCard_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
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
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_idCard_13 with item  [idCard] null
     * @return
     */
    @Test
    public void createEmployee_DateOfBirth_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
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
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_PhoneNumber_13 with item  [PhoneNumber] null
     * @return
     */
    @Test
    public void createEmployee_PhoneNumber_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
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
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_street_13 with item  [street] null
     * @return
     */
    @Test
    public void createEmployee_street_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
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
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_position_13 with item  [position] null
     * @return
     */
    @Test
    public void createEmployee_position_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
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
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_code_14 with item  [name] = rỗng("")
     * @return
     */
    @Test
    public void createEmployee_name_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("");
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
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_mail_13 with item  [mail] ""  "defaultMessage":"email không ???c ?? tr?ng",
     * @return
     */
    @Test
    public void createEmployee_mail_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("");
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
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_idCard_13 with item  [idCard] ""
     * @return
     */
    @Test
    public void createEmployee_idCard_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
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
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_idCard_13 with item  [idCard] ""
     * @return
     */
    @Test
    public void createEmployee_DateOfBirth_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
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
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_PhoneNumber_13 with item  [PhoneNumber] ""
     * @return
     */
    @Test
    public void createEmployee_PhoneNumber_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
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
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_street_13 with item  [street] ""
     * @return
     */
    @Test
    public void createEmployee_street_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
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
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



























    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_code_13 with item  setIdCard("01010101") errors regex
     * @Pattern(regexp = "(\\d{9})|(\\d{12})",message = "số cmnd phải đúng định dạng,
     * vd:XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9).")
     * @return
     */
    @Test
    public void createEmployee_idCard_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
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
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_name_15()
     * @return
     */
    @Test
    public void createEmployee_name_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
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
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_email_15()
     * @return
     */
    @Test
    public void createEmployee_email_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
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
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_email_15()
     * @return
     */
    @Test
    public void createEmployee_phoneNumber_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
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
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }




    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_province_16 with province(-5) errors Min(value=0)
     * @return
     */
    @Test
    public void createEmployee_province_16() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tu@gmail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("091010101");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("0123466788");
        employeeDto.setProvince(-5);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_district_16 with district(-5) errors Min(value=0)
     * @return
     */
    @Test
    public void createEmployee_district_16() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
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
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_commune_16 with commune(-5) errors Min(value=0)
     * @return
     */
    @Test
    public void createEmployee_commune_16() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
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
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_province_17 with province(80) errors Max(value=63) "defaultMessage":"must be less than or equal to 63"
     * @return
     */
    @Test
    public void createEmployee_province_17() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Nguyen Tu");
        employeeDto.setCommune(1);
        employeeDto.setDistrict(1);
        employeeDto.setEmail("tu@gmail.com");
        employeeDto.setGender(false);
        employeeDto.setIdCard("091010101");
        employeeDto.setDateOfBirth("1990-01-01");
        employeeDto.setPhoneNumber("0123466788");
        employeeDto.setProvince(80);
        employeeDto.setStreet("hamnghi");
        employeeDto.setPosition(new Position(1L));
//        employeeDto.setPosition(employeeDto.getPosition());

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: DinhNTC
     * Date created: 30/03/2023
     * Function: test func createEmployee_all_18 test successful
     * @return
     */
    @Test
    public void createEmployee_all_18() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Nguyen Tu");
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
                        .post("/api/create-employee")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
