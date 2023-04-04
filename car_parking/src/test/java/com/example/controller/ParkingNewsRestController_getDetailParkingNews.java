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
public class ParkingNewsRestController_getDetailParkingNews {
    @Autowired
    private MockMvc mockMvc;

    /**QuynhND
     * Created: 29/03/2023
     * Test for id is null
     * @return: empty page
     * @throws Exception
     */
    @Test
    public void getDetailParkingNews_parkingNewsId_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/parking_news/detail/{parkingNewsId}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**Created by: QuynhND
     * Date created: 29/03/2023
     * Test for id is blank
     * @throws Exception
     */
    @Test
    public void getDetailParkingNews_parkingNewsId_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/parking_news/detail/{parkingNewsId}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**Created by: QuynhND
     * Date created: 29/03/2023
     * Test for id does not exist in database. Parking News ID 999 is not existed in testing database
     * @throws Exception
     */
    @Test
    public void getDetailParkingNews_parkingNewsId_3() throws Exception {
        int notExistedParkingNewsId = 999;
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/parking_news/detail/{parkingNewsId}", notExistedParkingNewsId))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**Created by: QuynhND
     * Date created: 29/03/2023
     * Test for id exists in database
     * @throws Exception
     */
    @Test
    public void getDetailParkingNews_parkingNewsId_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/parking_news/detail/{parkingNewsId}", "3"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpectAll(
                        jsonPath("parkingNewsId").value(3),
                        jsonPath("title").value("Bộ khóa vị trí đỗ định danh, chỗ đỗ VIP"),
                        jsonPath("description").value("Mỗi một bộ quản lý vị trí đỗ cá nhân có trang bị cảm biến phát hiện xe và trên xe ô tô được trang bị bộ phát tín hiệu. Tiến hiệu thu/phát là trùng khớp và duy nhất."),
                        jsonPath("imageUrl").value("../../assets/img/news/news_3.png"),
                        jsonPath("content").value("Sản phẩm phù hợp cho các hầm chung cư, nhằm cá nhân hóa vị trí đỗ xe cho mỗi cư dân."),
                        jsonPath("postingDate").value("2021-10-30")
                );
    }
}