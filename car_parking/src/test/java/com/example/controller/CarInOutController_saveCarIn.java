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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CarInOutController_saveCarIn {
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
    public void saveCarIn_13() throws Exception {
        CarInOutDTO carInOutDTO = new CarInOutDTO();

        carInOutDTO.setCarDTO(null);

        carInOutDTO.setTimeIn("2023-02-27T19:34:50");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("http://localhost:8080/car-in-out/save-car-in")
                        .content(this.objectMapper.writeValueAsBytes(carInOutDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().isNotAcceptable());
    }


    /**
     * Created: NamLQN
     * Date: 30/03/2023
     * test saving car history getting in the parking lot
     * @Param: an instance of CarInOutDTO with the field timeIn being an empty string
     * Expect return status 406 error with Http.status.NOT_ACCEPTABLE
     */
    @Test
    public void saveCarIn_14() throws Exception {
        CarInOutDTO carInOutDTO = new CarInOutDTO();

        carInOutDTO.setCarDTO(new CarDTO(2));

        carInOutDTO.setTimeIn("");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("http://localhost:8080/car-in-out/save-car-in")
                        .content(this.objectMapper.writeValueAsBytes(carInOutDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().isNotAcceptable());
    }

    /**
     * Created: NamLQN
     * Date: 30/03/2023
     * test saving car history getting in the parking lot
     * @Param: an instance of CarInOutDTO with the field timeIn being an invalid format for a datetime type
     * Expect return status 406 error with Http.status.NOT_ACCEPTABLE
     */
    @Test
    public void saveCarIn_15() throws Exception {
        CarInOutDTO carInOutDTO = new CarInOutDTO();

        carInOutDTO.setCarDTO(new CarDTO(2));

        carInOutDTO.setTimeIn("abc");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("http://localhost:8080/car-in-out/save-car-in")
                        .content(this.objectMapper.writeValueAsBytes(carInOutDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().isNotAcceptable());
    }


    /**
     * Created: NamLQN
     * Date: 30/03/2023
     * test saving car history getting in the parking lot
     * @Param: an instance of CarInOutDTO
     * Expect to return status 200 successful with Http.status.OK
     */
    @Test
    public void saveCarIn_18() throws Exception {
        CarInOutDTO carInOutDTO = new CarInOutDTO();

        carInOutDTO.setCarDTO(new CarDTO(2L));

        carInOutDTO.setTimeIn("2023-02-27T19:34:50");

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("http://localhost:8080/car-in-out/save-car-in")
                        .content(this.objectMapper.writeValueAsString(carInOutDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().isOk());
    }

}
