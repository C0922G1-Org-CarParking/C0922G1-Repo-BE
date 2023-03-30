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
public class TicketController_searchTicket {

    @Autowired
    private MockMvc mockMvc;

    /**
     * This function use to test list ticket of all field is null
     *
     * @author NhanPT
     * @Date 30/03/2023
     */

    @Test
    public void searchTicket_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/search"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].ticketId").value("1"))
                .andExpect(jsonPath("content[0].totalPrice").value("12000.0"))
                .andExpect(jsonPath("content[0].customerName").value("Vu BD"))
                .andExpect(jsonPath("content[0].expiryDate").value("2023-03-12"))
                .andExpect(jsonPath("content[0].employeeName").value("Nguyễn Hoàng"))
                .andExpect(jsonPath("content[0].plateNumber").value("92B-99999"))
                .andExpect(jsonPath("content[0].floor").value("1"))
                .andExpect(jsonPath("content[0].ticketType").value("ngày"))
                .andExpect(jsonPath("content[0].employeePhoneNumber").value("0363568456"))
                .andExpect(jsonPath("content[0].customerPhoneNumber").value("1234567893"))

                .andExpect(jsonPath("content[3].ticketId").value("4"))
                .andExpect(jsonPath("content[3].totalPrice").value("12000.0"))
                .andExpect(jsonPath("content[3].customerName").value("Vu BD"))
                .andExpect(jsonPath("content[3].expiryDate").value("2023-03-24"))
                .andExpect(jsonPath("content[3].employeeName").value("Lê Tài"))
                .andExpect(jsonPath("content[3].plateNumber").value("92B-99999"))
                .andExpect(jsonPath("content[3].floor").value("1"))
                .andExpect(jsonPath("content[3].ticketType").value("ngày"))
                .andExpect(jsonPath("content[3].employeePhoneNumber").value("0347468556"))
                .andExpect(jsonPath("content[3].customerPhoneNumber").value("1234567893"));
    }

    /**
     * This function use to test list ticket of all field is ""
     *
     * @author NhanPT
     * @Date 30/03/2023
     */

    @Test
    public void searchTicket_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/search?customerName=&&customerPhone=&&employeeName=&&employeePhone=&&floor=&&expiryDate=&&ticketType="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].ticketId").value("1"))
                .andExpect(jsonPath("content[0].totalPrice").value("12000.0"))
                .andExpect(jsonPath("content[0].customerName").value("Vu BD"))
                .andExpect(jsonPath("content[0].expiryDate").value("2023-03-12"))
                .andExpect(jsonPath("content[0].employeeName").value("Nguyễn Hoàng"))
                .andExpect(jsonPath("content[0].plateNumber").value("92B-99999"))
                .andExpect(jsonPath("content[0].floor").value("1"))
                .andExpect(jsonPath("content[0].ticketType").value("ngày"))
                .andExpect(jsonPath("content[0].employeePhoneNumber").value("0363568456"))
                .andExpect(jsonPath("content[0].customerPhoneNumber").value("1234567893"))

                .andExpect(jsonPath("content[3].ticketId").value("4"))
                .andExpect(jsonPath("content[3].totalPrice").value("12000.0"))
                .andExpect(jsonPath("content[3].customerName").value("Vu BD"))
                .andExpect(jsonPath("content[3].expiryDate").value("2023-03-24"))
                .andExpect(jsonPath("content[3].employeeName").value("Lê Tài"))
                .andExpect(jsonPath("content[3].plateNumber").value("92B-99999"))
                .andExpect(jsonPath("content[3].floor").value("1"))
                .andExpect(jsonPath("content[3].ticketType").value("ngày"))
                .andExpect(jsonPath("content[3].employeePhoneNumber").value("0347468556"))
                .andExpect(jsonPath("content[3].customerPhoneNumber").value("1234567893"));
    }

    /**
     * This function use to test list ticket of field expiryDate is 2025-05-12 this not exist in database
     *
     * @author NhanPT
     * @Date 30/03/2023
     */


    @Test
    public void searchTicketByExpiryDate_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/search?expiryDate=2025-05-12"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * This function use to test list ticket of field expiryDate is 2025-05-12 this exist in database and is_deleted = 0
     *
     * @author NhanPT
     * @Date 30/03/2023
     */

    @Test
    public void searchTicketByExpiryDate_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/search?expiryDate=2023-03-12"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].ticketId").value("1"))
                .andExpect(jsonPath("content[0].totalPrice").value("12000.0"))
                .andExpect(jsonPath("content[0].customerName").value("Vu BD"))
                .andExpect(jsonPath("content[0].expiryDate").value("2023-03-12"))
                .andExpect(jsonPath("content[0].employeeName").value("Nguyễn Hoàng"))
                .andExpect(jsonPath("content[0].plateNumber").value("92B-99999"))
                .andExpect(jsonPath("content[0].floor").value("1"))
                .andExpect(jsonPath("content[0].ticketType").value("ngày"))
                .andExpect(jsonPath("content[0].employeePhoneNumber").value("0363568456"))
                .andExpect(jsonPath("content[0].customerPhoneNumber").value("1234567893"));
    }


    /**
     * This function use to test list ticket of field floor is 100 this not exist in database
     *
     * @author NhanPT
     * @Date 30/03/2023
     */


    @Test
    public void searchTicketByFloor_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/search?floor=100"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * This function use to test list ticket of field floor is 10 this exist in database but ticket not have this
     *
     * @author NhanPT
     * @Date 30/03/2023
     */

    @Test
    public void searchTicketByFloor_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/search?floor=4"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    /**
     * This function use to test list ticket of field floor is 1 this exist in database
     *
     * @author NhanPT
     * @Date 30/03/2023
     */

    @Test
    public void searchTicketByFloor_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/search?floor=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].ticketId").value("1"))
                .andExpect(jsonPath("content[0].totalPrice").value("12000.0"))
                .andExpect(jsonPath("content[0].customerName").value("Vu BD"))
                .andExpect(jsonPath("content[0].expiryDate").value("2023-03-12"))
                .andExpect(jsonPath("content[0].employeeName").value("Nguyễn Hoàng"))
                .andExpect(jsonPath("content[0].plateNumber").value("92B-99999"))
                .andExpect(jsonPath("content[0].floor").value("1"))
                .andExpect(jsonPath("content[0].ticketType").value("ngày"))
                .andExpect(jsonPath("content[0].employeePhoneNumber").value("0363568456"))
                .andExpect(jsonPath("content[0].customerPhoneNumber").value("1234567893"));
    }

    /**
     * This function use to test list ticket of field ticketType is 100 this not exist in database
     *
     * @author NhanPT
     * @Date 30/03/2023
     */


    @Test
    public void searchTicketByTicketType_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/search?ticketType=haingay"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * This function use to test list ticket of field ticketType is 1 this exist in database
     *
     * @author NhanPT
     * @Date 30/03/2023
     */

    @Test
    public void searchTicketByTicketType_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/search?ticketType=ngày"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].ticketId").value("1"))
                .andExpect(jsonPath("content[0].totalPrice").value("12000.0"))
                .andExpect(jsonPath("content[0].customerName").value("Vu BD"))
                .andExpect(jsonPath("content[0].expiryDate").value("2023-03-12"))
                .andExpect(jsonPath("content[0].employeeName").value("Nguyễn Hoàng"))
                .andExpect(jsonPath("content[0].plateNumber").value("92B-99999"))
                .andExpect(jsonPath("content[0].floor").value("1"))
                .andExpect(jsonPath("content[0].ticketType").value("ngày"))
                .andExpect(jsonPath("content[0].employeePhoneNumber").value("0363568456"))
                .andExpect(jsonPath("content[0].customerPhoneNumber").value("1234567893"));
    }


    /**
     * This function use to test list ticket of field customerName is TraiDat this not exist in database
     *
     * @author NhanPT
     * @Date 30/03/2023
     */


    @Test
    public void searchTicketByCustomerName_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/search?CustomerName=TraiDat"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    /**
     * This function use to test list ticket of field customerName is Vu BD this exist in database
     *
     * @author NhanPT
     * @Date 30/03/2023
     */

    @Test
    public void searchTicketByCustomerName_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/search?CustomerName=Vu BD"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].ticketId").value("1"))
                .andExpect(jsonPath("content[0].totalPrice").value("12000.0"))
                .andExpect(jsonPath("content[0].customerName").value("Vu BD"))
                .andExpect(jsonPath("content[0].expiryDate").value("2023-03-12"))
                .andExpect(jsonPath("content[0].employeeName").value("Nguyễn Hoàng"))
                .andExpect(jsonPath("content[0].plateNumber").value("92B-99999"))
                .andExpect(jsonPath("content[0].floor").value("1"))
                .andExpect(jsonPath("content[0].ticketType").value("ngày"))
                .andExpect(jsonPath("content[0].employeePhoneNumber").value("0363568456"))
                .andExpect(jsonPath("content[0].customerPhoneNumber").value("1234567893"));
    }

    /**
     * This function use to test list ticket of field customerPhone is 023457576 this not exist in database
     *
     * @author NhanPT
     * @Date 30/03/2023
     */


    @Test
    public void searchTicketBycustomerPhone_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/search?customerPhone=023457576"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    /**
     * This function use to test list ticket of field customerPhone is 1234567893 this exist in database
     *
     * @author NhanPT
     * @Date 30/03/2023
     */

    @Test
    public void searchTicketByCustomerPhone_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/search?customerPhone=1234567893"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].ticketId").value("1"))
                .andExpect(jsonPath("content[0].totalPrice").value("12000.0"))
                .andExpect(jsonPath("content[0].customerName").value("Vu BD"))
                .andExpect(jsonPath("content[0].expiryDate").value("2023-03-12"))
                .andExpect(jsonPath("content[0].employeeName").value("Nguyễn Hoàng"))
                .andExpect(jsonPath("content[0].plateNumber").value("92B-99999"))
                .andExpect(jsonPath("content[0].floor").value("1"))
                .andExpect(jsonPath("content[0].ticketType").value("ngày"))
                .andExpect(jsonPath("content[0].employeePhoneNumber").value("0363568456"))
                .andExpect(jsonPath("content[0].customerPhoneNumber").value("1234567893"))

                .andExpect(jsonPath("content[2].ticketId").value("4"))
                .andExpect(jsonPath("content[2].totalPrice").value("12000.0"))
                .andExpect(jsonPath("content[2].customerName").value("Vu BD"))
                .andExpect(jsonPath("content[2].expiryDate").value("2023-03-24"))
                .andExpect(jsonPath("content[2].employeeName").value("Lê Tài"))
                .andExpect(jsonPath("content[2].plateNumber").value("92B-99999"))
                .andExpect(jsonPath("content[2].floor").value("1"))
                .andExpect(jsonPath("content[2].ticketType").value("ngày"))
                .andExpect(jsonPath("content[2].employeePhoneNumber").value("0347468556"))
                .andExpect(jsonPath("content[2].customerPhoneNumber").value("1234567893"));
    }

    /**
     * This function use to test list ticket of field employeeName is 023457576 this not exist in database
     *
     * @author NhanPT
     * @Date 30/03/2023
     */


    @Test
    public void searchTicketByEmployeeName_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/search?employeeName=023457576"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    /**
     * This function use to test list ticket of field employeeName is Nguyễn Hoàng this exist in database
     *
     * @author NhanPT
     * @Date 30/03/2023
     */

    @Test
    public void searchTicketByEmployeeName_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/search?employeeName=Nguyễn Hoàng"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].ticketId").value("1"))
                .andExpect(jsonPath("content[0].totalPrice").value("12000.0"))
                .andExpect(jsonPath("content[0].customerName").value("Vu BD"))
                .andExpect(jsonPath("content[0].expiryDate").value("2023-03-12"))
                .andExpect(jsonPath("content[0].employeeName").value("Nguyễn Hoàng"))
                .andExpect(jsonPath("content[0].plateNumber").value("92B-99999"))
                .andExpect(jsonPath("content[0].floor").value("1"))
                .andExpect(jsonPath("content[0].ticketType").value("ngày"))
                .andExpect(jsonPath("content[0].employeePhoneNumber").value("0363568456"))
                .andExpect(jsonPath("content[0].customerPhoneNumber").value("1234567893"))

                .andExpect(jsonPath("content[1].ticketId").value("3"))
                .andExpect(jsonPath("content[1].totalPrice").value("5256000.0"))
                .andExpect(jsonPath("content[1].customerName").value("Vu BD"))
                .andExpect(jsonPath("content[1].expiryDate").value("2024-02-11"))
                .andExpect(jsonPath("content[1].employeeName").value("Nguyễn Hoàng"))
                .andExpect(jsonPath("content[1].plateNumber").value("92B-11111"))
                .andExpect(jsonPath("content[1].floor").value("1"))
                .andExpect(jsonPath("content[1].ticketType").value("tháng"))
                .andExpect(jsonPath("content[1].employeePhoneNumber").value("0363568456"))
                .andExpect(jsonPath("content[1].customerPhoneNumber").value("1234567894"));
    }

    /**
     * This function use to test list ticket of field employeePhone is 023457576 this not exist in database
     *
     * @author NhanPT
     * @Date 30/03/2023
     */

    @Test
    public void searchTicketByEmployeePhone_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/search?employeePhone=023007576"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * This function use to test list ticket of field employeePhone is Nguyễn Hoàng this exist in database
     *
     * @author NhanPT
     * @Date 30/03/2023
     */

    @Test
    public void searchTicketByEmployeePhonee_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/ticket/search?employeePhone=0363568456"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].ticketId").value("1"))
                .andExpect(jsonPath("content[0].totalPrice").value("12000.0"))
                .andExpect(jsonPath("content[0].customerName").value("Vu BD"))
                .andExpect(jsonPath("content[0].expiryDate").value("2023-03-12"))
                .andExpect(jsonPath("content[0].employeeName").value("Nguyễn Hoàng"))
                .andExpect(jsonPath("content[0].plateNumber").value("92B-99999"))
                .andExpect(jsonPath("content[0].floor").value("1"))
                .andExpect(jsonPath("content[0].ticketType").value("ngày"))
                .andExpect(jsonPath("content[0].employeePhoneNumber").value("0363568456"))
                .andExpect(jsonPath("content[0].customerPhoneNumber").value("1234567893"))

                .andExpect(jsonPath("content[1].ticketId").value("3"))
                .andExpect(jsonPath("content[1].totalPrice").value("5256000.0"))
                .andExpect(jsonPath("content[1].customerName").value("Vu BD"))
                .andExpect(jsonPath("content[1].expiryDate").value("2024-02-11"))
                .andExpect(jsonPath("content[1].employeeName").value("Nguyễn Hoàng"))
                .andExpect(jsonPath("content[1].plateNumber").value("92B-11111"))
                .andExpect(jsonPath("content[1].floor").value("1"))
                .andExpect(jsonPath("content[1].ticketType").value("tháng"))
                .andExpect(jsonPath("content[1].employeePhoneNumber").value("0363568456"))
                .andExpect(jsonPath("content[1].customerPhoneNumber").value("1234567894"));
    }

}
