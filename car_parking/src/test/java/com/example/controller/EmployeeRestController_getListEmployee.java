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
public class EmployeeRestController_getListEmployee {
    @Autowired
    MockMvc mockMvc;


    /**
     * Created by: TaiLH
     * Date created: 30/03/2023
     * function: check the case when search is null
     * @throws Exception
     */
    @Test
    public void getListEmployee_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/list-employee?page=0&size=10&dateOfBirth=null&name=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: TaiLH
     * Date created: 30/03/2023
     * function: check case search is empty but this case has default setting so this case doesn't happen
     * @throws Exception
     */
    @Test
    public void getListEmployee_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/list-employee?page=0&size=10&dateOfBirth=&name=",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: TaiLH
     * Date created: 30/03/2023
     * function: check case search name not in database
     * @throws Exception
     */
    @Test
    public void getListEmployee_3_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/list-employee?page=0&size=10&dateOfBirth=&name=Vũ"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: TaiLH
     * Date created: 30/03/2023
     * function: check case search date not in database
     * @throws Exception
     */
    @Test
    public void getListEmployee_3_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/list-employee?page=0&size=10&dateOfBirth=2000-10-03&name="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: TaiLH
     * Date created: 30/03/2023
     * function: check if name search instance exists in database
     * @throws Exception
     */
    @Test
    public void getListEmployee_4_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/list-employee?page=0&size=10&dateOfBirth=&name=Tài"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Created by: TaiLH
     * Date created: 30/03/2023
     * function: check if the date search instance exists in the database
     * @throws Exception
     */
    @Test
    public void getListEmployee_4_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/list-employee?page=0&size=10&dateOfBirth=1995-05-10&name="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    @Test
    public void getListEmployee_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/list-employee?page=0&size=0&dateOfBirth=null&name=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: TaiLH
     * Date created: 30/03/2023
     * function: test case returns a list with size greater than 0
     * @throws Exception
     */
    @Test
    public void getListEmployee_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/list-employee?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].name").value("Nguyễn Hoàng"))
                .andExpect(jsonPath("content[0].dateOfBirth").value("1995-05-10"))
                .andExpect(jsonPath("content[0].idCard").value("321321321"))
                .andExpect(jsonPath("content[1].name").value("Lê Tài"))
                .andExpect(jsonPath("content[1].dateOfBirth").value("1999-03-02"))
                .andExpect(jsonPath("content[1].idCard").value("123456789"));
    }
}

