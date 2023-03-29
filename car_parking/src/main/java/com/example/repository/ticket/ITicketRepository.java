package com.example.repository.ticket;

import com.example.dto.TicketDto;
import com.example.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
    @Query(nativeQuery = true, value = "select t.id as TicketId, c.plate_number as PlateNumber, cus.name as CustomerName, cus.phone_number as CustomerPhoneNumber,\t\t\t\t\t\n" +
            "e.name as EmployeeName, e.phone_number as EmployeePhoneNumber, tt.name as TicketType, tt.price * ct.rate / 100 as TotalPrice, \n" +
            "f.name as Floor, t.expiry_date as ExpiryDate \t\t\t\n" +
            "from `ticket` as t\t\t\t\t\t\n" +
            "\tjoin `car` as c on t.car_id = c.id\t\t\t\t\t\n" +
            "\tjoin `car_type` as ct on c.car_type_id = ct.id\t\t\t\t\t\n" +
            "\tjoin  `customer` as cus on  c.customer_id = cus.id\t\t\t\t\t\n" +
            "\tjoin `ticket_type` as tt on t.ticket_type_id = tt.id\t\t\t\t\t\n" +
            "\tjoin `employee` as e on e.id = t.employee_id\t\t\t\t\t\n" +
            "\tjoin `location` as lc on lc.id = t.location_id \t\t\t\t\t\n" +
            "\tjoin `floor` as f on f.id = lc.floor_id\n" +
            "where cus.name like concat('%',:customerName,'%') and " +
            "cus.phone_number like concat('%',:customerPhone,'%') and " +
            "e.name like concat('%',:employeeName,'%') and " +
            "e.phone_number like concat('%',:employeePhone,'%') and " +
            "f.name like concat('%',:floor,'%') and " +
            "t.expiry_date like concat('%',:expiryDate,'%') and " +
            "tt.name like concat('%',:ticketType,'%') ")
    Page<TicketDto> search(@Param("customerName")String customerName,
                        @Param("customerPhone")String customerPhone,
                        @Param("employeeName")String employeeName,
                        @Param("employeePhone")String employeePhone,
                        @Param("floor")String floor,
                        @Param("expiryDate")String expiryDate,
                        @Param("ticketType")String ticketType, Pageable pageable);
    @Modifying
    @Query(nativeQuery = true, value = "delete from ticket as t where t.id = :idDelete")
    void delete(@Param("idDelete")int idDelete);

    @Query(nativeQuery = true, value = "select t.id as TicketId, c.plate_number as PlateNumber, cus.name as CustomerName, cus.phone_number as CustomerPhoneNumber,\t\t\t\t\t\n" +
            "e.name as EmployeeName, e.phone_number as EmployeePhoneNumber, tt.name as TicketType, tt.price * ct.rate / 100 as TotalPrice, \n" +
            "f.name as Floor, t.expiry_date as ExpiryDate, s.name as Section \t\t\t\n" +
            "from ticket as t\t\t\t\t\t\n" +
            "\tjoin car as c on t.car_id = c.id\t\t\t\t\t\n" +
            "\tjoin car_type as ct on c.car_type_id = ct.id\t\t\t\t\t\n" +
            "\tjoin  customer as cus on  c.customer_id = cus.id\t\t\t\t\t\n" +
            "\tjoin ticket_type as tt on t.ticket_type_id = tt.id\t\t\t\t\t\n" +
            "\tjoin employee as e on e.id = t.employee_id\t\t\t\t\t\n" +
            "\tjoin location as lc on lc.id = t.location_id \t\t\t\t\t\n" +
            "\tjoin floor as f on f.id = lc.floor_id\n" +
            "\tjoin section as s on s.id = lc.section_id\n" +
            "where t.id = :id")
    TicketDto findById(@Param("id") int id);
}
