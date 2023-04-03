package com.example.controller;

import com.example.dto.CarDTO;
import com.example.dto.CarInOutDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc

public class CarInOutController_saveCarOut {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Created: NamLQN
     * Date: 30/03/2023
     * test saving car history getting in the parking lot
     * @Param: an instance of CarInOutDTO with the field CarDTO being null
     * Expect return status 406 error with Http.status.NOT_ACCEPTABLE
     */
    @Test
    public void saveCarOut_18() throws Exception {
        CarInOutDTO carOutDTO = new CarInOutDTO();

        carOutDTO.setCarDTO(new CarDTO(4));

        carOutDTO.setTimeIn("2023-02-27T19:34:50");

        carOutDTO.setUrlCarInImage("test-97.jpg");

        carOutDTO.setId(1L);
        String dateTime = LocalDateTime.now().toString();
        carOutDTO.setTimeOut("2023-03-27T11:00:50");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("http://localhost:8080/car-in-out/save-car-out")
                        .content(this.objectMapper.writeValueAsString(carOutDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().isOk());
    }
}
