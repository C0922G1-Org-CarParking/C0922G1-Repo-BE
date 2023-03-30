package com.example.controller.car_in_out;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;

import javax.validation.Path;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CarInOutController_searchCarInOutDTO {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Created: NamLQN
     * Date: 30/03/2023
     * Test searchCar by scanning with id not existing
     * Expect to return error status 404 with Http.NOT_FOUND
     * @Param: image file
     */
    @Test
    public void searchCarInOutDTO_99() throws Exception {
        File plateNumberImage = ResourceUtils.getFile("classpath:snapshot/test_002.jpg");
        MockMultipartFile mockMultipartFile = new MockMultipartFile(
                "plateNumberImage",
                plateNumberImage.getName(),
                MediaType.IMAGE_JPEG_VALUE,
                new FileInputStream(plateNumberImage)
        );
        mockMvc.perform(MockMvcRequestBuilders.multipart("http://localhost:8080/car-in-out/scanning-car")
                .file(mockMultipartFile)
                .contentType(MediaType.MULTIPART_FORM_DATA)).andExpect(status().isNotFound()).andDo(print());
    }


    /**
     * Created: NamLQN
     * Date: 30/03/2023
     * Test the blurred plate image, which means the variable plateNumber after scanning will be null
     * Expect to return error 406 Http.NotAcceptable
     */
    @Test
    public void searchCarInOutDTO_blurredPlateNumber_99() throws Exception {
        File plateNumberImage = ResourceUtils.getFile("classpath:snapshot/blurred-plate-image.png");
        MockMultipartFile mockMultipartFile = new MockMultipartFile(
                "plateNumberImage",
                plateNumberImage.getName(),
                MediaType.IMAGE_PNG_VALUE,
                new FileInputStream(plateNumberImage)
        );
        mockMvc.perform(MockMvcRequestBuilders.multipart("http://localhost:8080/car-in-out/scanning-car")
                .file(mockMultipartFile)
                .contentType(MediaType.MULTIPART_FORM_DATA)).andExpect(status().isNotAcceptable()).andDo(print());
    }

    /**
     * Created: NamLQN
     * Date: 30/03/2023
     * Test the car image with the clearly seen number plate which exists in the Database.
     * Expect to return status 200 Http.status.OK with the CarInOutDTO instance that includes all non-nullable fields
     */
    @Test
    public void searchCarInOutDTO_existingInDatabase_99() throws Exception {
        File plateNumberImage = ResourceUtils.getFile("classpath:snapshot/test_097.jpg");
        MockMultipartFile mockMultipartFile = new MockMultipartFile(
                "plateNumberImage",
                plateNumberImage.getName(),
                MediaType.IMAGE_JPEG_VALUE,
                new FileInputStream(plateNumberImage)
        );
        mockMvc.perform(MockMvcRequestBuilders.multipart("http://localhost:8080/car-in-out/scanning-car")
                        .file(mockMultipartFile)
                        .contentType(MediaType.MULTIPART_FORM_DATA)).andExpect(status().isOk()).andDo(print())
                .andExpectAll(
                        jsonPath("car_type_name").value("7 Chỗ"),
                        jsonPath("car_name").value("CX8"),
                        jsonPath("car_brand").value("Mazda"),
                        jsonPath("customer_name").value("Vu BD"),
                        jsonPath("floor_name").value("1"),
                        jsonPath("location_name").value("C3"),
                        jsonPath("ticket_expiry_date").value("2024-03-29"),
                        jsonPath("car_plate_number").value("RK603AV"),
                        jsonPath("customer_phone_number").value("1234567894"),
                        jsonPath("ticket_effective_date").value("2023-03-26")
                );
    }








}
