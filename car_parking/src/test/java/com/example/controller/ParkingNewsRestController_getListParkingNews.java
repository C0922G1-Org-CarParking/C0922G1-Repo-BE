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
     * @return pages of parking news
     * @throws Exception
     */
    @Test
    public void getListParkingNews_keyword_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/parking_news?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    /**QuynhND
     * Created: 30/03/2023
     * Test for keyword blank
     * Note: Function getListParkingNews set @RequestParam(name = "keyword", defaultValue = "") for param keyword
     * Expect:  HttpStatus.OK
     * @return pages of parking news
     * @throws Exception
     */
    @Test
    public void getListParkingNews_keyword_8() throws Exception {
        String emptyKeyword = "";
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/parking_news?page=0&keyword=" + emptyKeyword))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**QuynhND
     * Created: 30/03/2023
     * Test for keyword not exist in database
     * Note: Function getListParkingNews set @RequestParam(name = "keyword", defaultValue = "") for param keyword
     * Expect:  HttpStatus.No_Content
     * @return: empty page
     * @throws Exception
     */
    @Test
    public void getListParkingNews_keyword_9() throws Exception {
        String notExistedKeyword = "not existed keyword";
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/parking_news?page=0&keyword=" + notExistedKeyword))
                .andDo(print())
                .andExpect(status().is(204));
    }

    /**QuynhND
     * Created: 30/03/2023
     * Test for keyword exists in database
     * Function: Test for key word exists in database and return list with size > 0, can use for function getListParkingNews_keyword_10()
     * Note: Function getListParkingNews set @RequestParam(name = "keyword", defaultValue = "") for param keyword, and query database with condition: is_deleted = false
     * Expect:  HttpStatus.No_Content
     * @return: pages of parking news
     * @throws Exception
     */

    @Test
    public void getListParkingNews_keyword_11() throws Exception {
        String existedKeyword = "đỗ xe";
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/parking_news?page=0&keyword=" + existedKeyword))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(5))
                .andExpect(jsonPath("content[0].parkingNewsId").value("5"))
                .andExpect(jsonPath("content[0].title").value("TÌM HIỂU CHI TIẾT VỀ HỆ THỐNG ĐỖ XE DẠNG XẾP HÌNH NHIỀU TẦNG"))
                .andExpect(jsonPath("content[0].description").value("Hệ thống đỗ xe dạng xếp hình nhiều tầng được nhiều chủ đầu tư ưu tiên lựa chọn vì chi phí lắp đặt tiết kiệm, thời gian thi công nhanh chóng, dễ dàng bảo trì."))
                .andExpect(jsonPath("content[0].imageUrl").value("../../assets/img/news/news_5.png"))
                .andExpect(jsonPath("content[0].postingDate").value("2023-01-30"))
                .andExpect(jsonPath("content[0].content").value(IsNull.nullValue()))
                .andExpect(jsonPath("content[2].parkingNewsId").value("3"))
                .andExpect(jsonPath("content[2].title").value("Bộ khóa vị trí đỗ định danh, chỗ đỗ VIP"))
                .andExpect(jsonPath("content[2].description").value("Mỗi một bộ quản lý vị trí đỗ cá nhân có trang bị cảm biến phát hiện xe và trên xe ô tô được trang bị bộ phát tín hiệu. Tiến hiệu thu/phát là trùng khớp và duy nhất."))
                .andExpect(jsonPath("content[2].imageUrl").value("../../assets/img/news/news_3.png"))
                .andExpect(jsonPath("content[2].postingDate").value("2021-10-30"))
                .andExpect(jsonPath("content[2].content").value(IsNull.nullValue()));
    }
}
