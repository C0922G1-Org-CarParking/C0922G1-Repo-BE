package com.example.controller;

import com.example.dto.CarDto;

import com.example.dto.CustomerCarDto;
import com.example.model.CarType;
import com.example.model.Customer;
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
public class CustomerRestController_updateCustomer {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input name property car is null
     */
    @Test
    public void updateCustomer_name_car_19() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("VuTn");
        Customer.setIdCard("1234569871");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName(null);
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input brand property car is null
     */
    @Test
    public void updateCustomer_brand_car_19() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("VuTn");
        Customer.setIdCard("1234569871");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand(null);
        carDto.setCarType(carType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input plateNumber property car is null
     */
    @Test
    public void updateCustomer_plateNumber_car_19() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("VuTn");
        Customer.setIdCard("1234569871");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber(null);
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *   * author : VuTN
     *      * create day :30/03/2023
     * This function is used to check an input carType property car is null
     */
    @Test
    public void updateCustomer_carType_car_19() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("VuTn");
        Customer.setIdCard("1234569871");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input name property car is empty
     */
    @Test
    public void updateCustomer_name_car_20() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("VuTn");
        Customer.setIdCard("1234569871");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input brand property car is empty
     */
    @Test
    public void updateCustomer_brand_car_20() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("VuTn");
        Customer.setIdCard("1234569871");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("1994-12-25");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *    author : VuTN
     *    create day :30/03/2023
     * This function is used to check an input plateNumber property car is empty
     */
    @Test
    public void updateCustomer_plateNumber_car_20() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("VuTn");
        Customer.setIdCard("1234569871");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber("");
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input name property car contains special characters
     */
    @Test
    public void updateCustomer_name_car_21() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("VuTn");
        Customer.setIdCard("1234569871");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry#%");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input name property car than more 20 character
     */
    @Test
    public void updateCustomer_name1_car_21() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("VuTn");
        Customer.setIdCard("1234569871");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camryaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input brand property car than more 20 character
     */
    @Test
    public void updateCustomer_brand2_car_21() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("VuTn");
        Customer.setIdCard("1234569871");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyotaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input brand property car than more 20 character
     */
    @Test
    public void updateCustomer_brand1_car_21() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("VuTn");
        Customer.setIdCard("1234569871");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyota@&");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input name property customer is empty
     */
    @Test
    public void updateCustomer_name_customer_20() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("");
        Customer.setIdCard("1234569871");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input name property customer is null
     */
    @Test
    public void updateCustomer_name_customer_19() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName(null);
        Customer.setIdCard("1234569871");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input name property customer is character special
     */
    @Test
    public void updateCustomer_name_customer_21() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("vutn@%");
        Customer.setIdCard("1234569871");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input name property customer than more 30 character
     */
    @Test
    public void updateCustomer_name_customer_22() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Customer.setIdCard("1234569871");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input CCCD property customer is null
     */
    @Test
    public void updateCustomer_CCCD_19() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("vutn");
        Customer.setIdCard(null);
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input CCCD property customer is empty
     */
    @Test
    public void updateCustomer_CCCD_20() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("vutn");
        Customer.setIdCard("");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input CCCD property customer malformed
     */
    @Test
    public void updateCustomer_CCCD_21() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("vutn");
        Customer.setIdCard("02569872543");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input gender property customer null
     */
    @Test
    public void updateCustomer_gender_19() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("vutn");
        Customer.setIdCard("02569872543");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input dateOfBirth property customer is null
     */
    @Test
    public void updateCustomer_datOfBirth_19() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("vutn");
        Customer.setIdCard("0269872543");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth(null);
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input dateOfBirth property customer malformed
     */
    @Test
    public void updateCustomer_dateOfBirth_21() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("vutn");
        Customer.setIdCard("0569872543");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("1995/12/12");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input email property customer is null
     */
    @Test
    public void updateCustomer_email() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("vutn");
        Customer.setIdCard("0123456789");
        Customer.setEmail(null);
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input email property customer malformed
     */
    @Test
    public void updateCustomer_email_21() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("vutn");
        Customer.setIdCard("02569872543");
        Customer.setEmail("vutran@gmailcom");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("(+84)0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input sđt property customer null
     */
    @Test
    public void updateCustomer_phone_19() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("vutn");
        Customer.setIdCard("0256987254");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber(null);
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * author : VuTN
     * create day :30/03/2023
     * This function is used to check an input sdtd property customer malformed
     */
    @Test
    public void updateCustomer_phone_21() throws Exception {
        CarDto carDto = new CarDto();

        CarType carType = new CarType();
        carType.setId(1L);
        carType.setName("4 Chổ");
        carType.setRate(1);

        Customer Customer = new Customer();
        Customer.setId(2L);
        Customer.setName("vutn");
        Customer.setIdCard("02569872543");
        Customer.setEmail("vutran@gmail.com");
        Customer.setDateOfBirth("25/06/1995");
        Customer.setGender(false);
        Customer.setPhoneNumber("0999999999");
        Customer.setDistrict(1);
        Customer.setProvince(1);
        Customer.setStreet("Trần Hưng Đạo");
        Customer.setCommune(1);

        carDto.setCustomer(Customer);
        carDto.setName("Camry");
        carDto.setPlateNumber("43H-1111");
        carDto.setBrand("Toyota");
        carDto.setCarType(carType);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customer/update")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
//    /**
//     * author : VuTN
//     * create day :30/03/2023
//     * This function is used update customer
//     */
//    @Test
//    public void updateCustomer_province_21() throws Exception {
//        CustomerCarDto customerCarDto = new CustomerCarDto();
//
//        CarType carType = new CarType();
//        carType.setId(1L);
//        carType.setName("4 Chổ");
//        carType.setRate(1);
//
//        customerCarDto.getCustomer().setId(2L);
//        customerCarDto.getCustomer().setName("vutn");
//        customerCarDto.getCustomer().setIdCard("0123456789");
//        customerCarDto.getCustomer().setEmail("vutran@gmail.com");
//        customerCarDto.getCustomer().setDateOfBirth("1994-12-25");
//        customerCarDto.getCustomer().setGender(false);
//        customerCarDto.getCustomer().setPhoneNumber("0999999999");
//        customerCarDto.getCustomer().setDistrict(1);
//        customerCarDto.getCustomer().setProvince(1);
//        customerCarDto.getCustomer().setStreet("A ha");
//        customerCarDto.getCustomer().setCommune(1);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/customer/update")
//                        .content(this.objectMapper.writeValueAsString(customerCarDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }


}