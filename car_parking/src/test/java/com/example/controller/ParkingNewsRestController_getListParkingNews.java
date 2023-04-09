package com.example.controller;


import org.hamcrest.core.IsNull;
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
public class ParkingNewsRestController_getListParkingNews {
    @Autowired
    private MockMvc mockMvc;

    /**QuynhND
     * Created: 30/03/2023
     * Test for keyword null
     * Note: Function getListParkingNews set @RequestParam(name = "keyword", defaultValue = "") for param keyword
     * Expect:  HttpStatus.OK
     * Return: pages of parking news
     * @throws Exception
     */
    @Test
    public void getListParkingNews_keyword_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/parking_news?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    /**QuynhND
     * Created: 30/03/2023
     * Test for keyword blank
     * Note: Function getListParkingNews set @RequestParam(name = "keyword", defaultValue = "") for param keyword
     * Expect:  HttpStatus.OK
     * Return: pages of parking news
     * @throws Exception
     */
    @Test
    public void getListParkingNews_keyword_8() throws Exception {
        String emptyKeyword = "";
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/parking_news?page=0&keyword=" + emptyKeyword))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**QuynhND
     * Created: 30/03/2023
     * Test for keyword not exist in database
     * Note: Function getListParkingNews set @RequestParam(name = "keyword", defaultValue = "") for param keyword
     * Expect:  HttpStatus.No_Content
     * Return: empty page
     * @throws Exception
     */
    @Test
    public void getListParkingNews_keyword_9() throws Exception {
        String notExistedKeyword = "not existed keyword";
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/parking_news?page=0&keyword=" + notExistedKeyword))
                .andDo(print())
                .andExpect(status().is(204));
    }

    /**QuynhND
     * Created: 30/03/2023
     * Test for keyword exists in database
     * Function: Test for key word exists in database and return list with size > 0, can use for function getListParkingNews_keyword_10()
     * Note: Function getListParkingNews set @RequestParam(name = "keyword", defaultValue = "") for param keyword, and query database with condition: is_deleted = false
     * Expect:  HttpStatus.No_Content
     * Return: pages of parking news
     * @throws Exception
     */

    @Test
    public void getListParkingNews_keyword_11() throws Exception {
        String existedKeyword = "đỗ xe";
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/public/parking_news?page=0&keyword=" + existedKeyword))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(3))
                .andExpect(jsonPath("totalElements").value(8))
                .andExpect(jsonPath("content[0].parkingNewsId").value("10"))
                .andExpect(jsonPath("content[0].title").value("HỆ THỐNG ĐỖ XE TỰ ĐỘNG SCP TẠI CÔNG TY MYOB"))
                .andExpect(jsonPath("content[0].description").value("Do nhu cầu mở rộng sức chứa bãi đỗ xe của công ty MYOB, SCP hân hạnh lắp đặt hệ thống bãi đỗ xe tự động 3 tầng, giúp công ty MYOB tăng số lượng xe có thể đỗ lên gấp 3 lần, đáp ứng được nhu cầu của công ty."))
                .andExpect(jsonPath("content[0].imageUrl").value("../../assets/img/news/news_10.png"))
                .andExpect(jsonPath("content[0].postingDate").value("2023-03-16"))
                .andExpect(jsonPath("content[0].content").value(IsNull.nullValue()))
                .andExpect(jsonPath("content[2].parkingNewsId").value("7"))
                .andExpect(jsonPath("content[2].title").value("PHƯƠNG ÁN GIẢI QUYẾT MÂU THUẪN DO THIẾU CHỖ ĐỖ XE TẠI CHUNG CƯ"))
                .andExpect(jsonPath("content[2].description").value("Tình trạng đỗ xe tràn lan trong các khu chung cư tại các thành phố lớn do thiếu chỗ đỗ xe ngày càng phổ biến, kéo theo nhiều hệ lụy phức tạp về an ninh trật tự, tắc nghẽn giao thông, thậm chí gây khó khăn trong việc phòng cháy, chữa cháy."))
                .andExpect(jsonPath("content[2].imageUrl").value("../../assets/img/news/news_7.png"))
                .andExpect(jsonPath("content[2].postingDate").value("2023-02-15"))
                .andExpect(jsonPath("content[2].content").value(IsNull.nullValue()));
    }
}
