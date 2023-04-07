package com.example.repository;

import com.example.dto.ILocationDTOEdit;
import com.example.dto.ISectionDTO;
import com.example.dto.ITicketDTO;
import com.example.model.Ticket;
import com.example.dto.TicketOfListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

import java.util.List;

@Transactional
public interface ITicketRepository extends JpaRepository<Ticket, Long> {

    /**
     * Created by: HuyNL
     * Date created: 29/03/2023
     * Function: editTicket and
     */
    @Modifying
    @Query(value = "update ticket as t set t.expiry_date = :expiryDate, t.location_id = :locationId, t.ticket_type_id = :ticketTypeId, t.total_price = :totalPrice where t.id =:id", nativeQuery = true)
    void updateTicket(@Param("expiryDate") String expiryDate, @Param("locationId") Long locationId, @Param("ticketTypeId") Long ticketTypeId, @Param("totalPrice") double totalPrice, @Param("id") Long id);

    /**
     * Created by: HuyNL
     * Date created: 29/03/2023
     * Function: editTicket and
     */

    @Query(value = " select \n" +
            "ticket.id as TicketId, ct.rate as Rate, c.name as CustomerName, c2.plate_number as PlateNumber,c.phone_number as PhoneNumber,\n" +
            "ticket.effective_date as EffectiveDate, ticket.expiry_date as ExpiryDate, f.id as FloorId,l.id as LocationId, \n" +
            "s.id as SectionId, ticket.total_price as totalPrice, tt.id as TicketTypeId \n" +
            " from `ticket` \n" +
            " join `car` c2 on c2.id = ticket.car_id \n" +
            " join `car_type` ct on ct.id = c2.car_type_id \n" +
            " join `customer` c on c.id = c2.customer_id join `location` l on l.id = ticket.location_id \n" +
            " join `section` s on s.id = l.section_id join `floor` f on f.id = l.floor_id \n" +
            " join `ticket_type` tt on tt.id = ticket.ticket_type_id where ticket.id = :id and ticket.is_deleted = false", nativeQuery = true)
    ITicketDTO findTicket(@Param("id") int id);


    /**
     * Created by: HuyNL
     * Date created: 29/03/2023
     * Function: editTicket and
     */


    @Query(nativeQuery = true, value = "select lc.id, lc.name\n" +
            "from location as lc\n" +
            "join floor as fl on lc.floor_id = fl.id\n" +
            "where lc.is_occupied = 0\n" +
            "and fl.id = :idFloor")
    List<ILocationDTOEdit> findLocationOfFloor(@Param("idFloor") int idFloor);


    @Query(nativeQuery = true, value = "select s.name,s.id\n" +
            "from section as s\n" +
            "join location as l on l.section_id = s.id\n" +
            "join floor as f on l.floor_id = f.id\n" +
            "where l.is_occupied = 0\n" +
            "and f.id = 1;")
    List<ISectionDTO> findSectionOfFloor(@Param("idSection") int idSection);



    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `c0922g1_car_parking`.`ticket` (`effective_date`, `expiry_date`, `is_deleted`, `total_price`, `car_id`, `employee_id`, `location_id`, `ticket_type_id`,`price`)" +
            " VALUES (:effectiveDate, :expiryDate, :isDeleted,:totalPrice, :carId, :employeeId, :locationId,:ticketTypeId,:price )", nativeQuery = true)
    void addTicket(@Param("effectiveDate") String effectiveDate,
                   @Param("expiryDate") String expiryDate,
                   @Param("isDeleted") boolean isDeleted,
                   @Param("totalPrice") double totalPrice,
                   @Param("carId") Long carId,
                   @Param("employeeId") Long employeeId,
                   @Param("locationId") Long locationId,
                   @Param("ticketTypeId") Long ticketTypeId,
                   @Param("price") Double price);

    @Query(value = "SELECT DATEDIFF(:expiry_date, :effective_date ) * 15000 * :rate ", nativeQuery = true)
    Integer getPriceOfTicket(@Param("expiry_date") Date expiry_date
            , @Param("effective_date") Date effective_date,
                             @Param("rate") double rate);


    @Query(value = "SELECT DISTINCT MONTH(expiry_date) AS month FROM ticket WHERE MONTH(expiry_date) BETWEEN :sinceMonth AND :toMonth ORDER BY month ASC", nativeQuery = true)
    List<ITicketDTO> displayMonth(@Param("sinceMonth") int sinceMonth, @Param("toMonth") int toMonth);

    @Query(nativeQuery = true, value = "select t.id as TicketId, c.plate_number as PlateNumber, cus.name as CustomerName, cus.phone_number as CustomerPhoneNumber,\n" +
            "            e.name as EmployeeName, e.phone_number as EmployeePhoneNumber, tt.name as TicketType, \n" +
            "             DATEDIFF(t.expiry_date , t.effective_date) * t.price * ct.rate as TotalPrice, \n" +
            "            f.name as Floor, lc.name as Location,  t.expiry_date as ExpiryDate\n" +
            "            from `ticket` as t\n" +
            "            join `car` as c on t.car_id = c.id\n" +
            "            join `car_type` as ct on c.car_type_id = ct.id\n" +
            "            join  `customer` as cus on  c.customer_id = cus.id\n" +
            "            join `ticket_type` as tt on t.ticket_type_id = tt.id\n" +
            "            join `employee` as e on e.id = t.employee_id\n" +
            "            join `location` as lc on lc.id = t.location_id \n" +
            "            join `floor` as f on f.id = lc.floor_id\n" +
            "            where cus.name like concat('%',:customerName,'%') and\n" +
            "            cus.phone_number = coalesce(nullif(:customerPhone,''), cus.phone_number) and\n" +
            "            e.name like concat('%',:employeeName,'%') and\n" +
            "            e.phone_number = coalesce(nullif(:employeePhone,''), e.phone_number) and \n" +
            "            f.name like concat('%',:floor,'%') and\n" +
            "            t.expiry_date = coalesce(nullif(:expiryDate,''), t.expiry_date) and\n" +
            "            tt.name like concat('%',:ticketType,'%') and\n" +
            "            t.is_deleted = :status")
    Page<TicketOfListDTO> search(@Param("customerName") String customerName,
                                 @Param("customerPhone") String customerPhone,
                                 @Param("employeeName") String employeeName,
                                 @Param("employeePhone") String employeePhone,
                                 @Param("floor") String floor,
                                 @Param("expiryDate") String expiryDate,
                                 @Param("ticketType") String ticketType,
                                 @Param("status") int status, Pageable pageable);

    @Modifying
    @Query(nativeQuery = true, value = "delete from ticket as t where t.id = :idDelete")
    void delete(@Param("idDelete") int idDelete);

    @Query(nativeQuery = true, value = "select t.id as TicketId, tt.name as TicketType, c.plate_number as PlateNumber, cus.name as CustomerName, cus.id as CustomerCode, cus.phone_number as CustomerPhoneNumber,\t\t\t\t\t\n" +
            "e.name as EmployeeName, e.id as EmployeeCode, e.phone_number as EmployeePhoneNumber, DATEDIFF(t.expiry_date , t.effective_date) * t.price * ct.rate as TotalPrice, \n" +
            "f.name as Floor, s.name as Section,t.effective_date as EffectiveDate, t.expiry_date as ExpiryDate, lc.name as Location \t\t\t\n" +
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
    TicketOfListDTO findById(@Param("id") int id);

    /**
     * this method no param expiredDate and status
     */
    @Query(nativeQuery = true, value = "select t.id as TicketId, c.plate_number as PlateNumber, cus.name as CustomerName, cus.phone_number as CustomerPhoneNumber,\n" +
            "            e.name as EmployeeName, e.phone_number as EmployeePhoneNumber, tt.name as TicketType, \n" +
            "             DATEDIFF(t.expiry_date , t.effective_date) * t.price * ct.rate as TotalPrice, \n" +
            "            f.name as Floor, lc.name as Location,  t.expiry_date as ExpiryDate\n" +
            "            from `ticket` as t\n" +
            "            join `car` as c on t.car_id = c.id\n" +
            "            join `car_type` as ct on c.car_type_id = ct.id\n" +
            "            join  `customer` as cus on  c.customer_id = cus.id\n" +
            "            join `ticket_type` as tt on t.ticket_type_id = tt.id\n" +
            "            join `employee` as e on e.id = t.employee_id\n" +
            "            join `location` as lc on lc.id = t.location_id \n" +
            "            join `floor` as f on f.id = lc.floor_id\n" +
            "            where cus.name like concat('%',:customerName,'%') and\n" +
            "            cus.phone_number = coalesce(nullif(:customerPhone,''), cus.phone_number) and\n" +
            "            e.name like concat('%',:employeeName,'%') and\n" +
            "            e.phone_number = coalesce(nullif(:employeePhone,''), e.phone_number) and \n" +
            "            f.name like concat('%',:floor,'%') and\n" +
            "            t.expiry_date < curdate() and\n" +
            "            tt.name like concat('%',:ticketType,'%') and\n" +
            "            t.is_deleted = 0")
    Page<TicketOfListDTO> searchTicketExpired(@Param("customerName")String customerName,
                                              @Param("customerPhone")String customerPhone,
                                              @Param("employeeName")String employeeName,
                                              @Param("employeePhone")String employeePhone,
                                              @Param("floor")String floor,
                                              @Param("ticketType")String ticketType, Pageable pageable);

    @Query(value = "SELECT COUNT(ticket.id) " +
            "FROM car " +
            "JOIN ticket ON car.id = ticket.car_id " +
            "WHERE MONTH(ticket.effective_date) >= :sinceMonth " +
            "  AND MONTH(ticket.expiry_date) <= :toMonth " +
            "  AND YEAR(ticket.effective_date) = :year and YEAR(ticket.expiry_date) =:year " +
            "  AND (MONTH(ticket.effective_date) =:month )", nativeQuery = true)
    Integer getTotalOfTicket(@Param("sinceMonth") int sinceMonth,
                             @Param("toMonth") int toMonth,
                             @Param("month") int month,@Param("year") int year );
    /**
     * Create by: VuBD
     * Date create: 30/03/2023
     * Function: connect database to get data a ticket with corresponding id
     *
     * @param carId
     * @return
     */
    @Query(value = "SELECT ticket.id FROM c0922g1_car_parking.ticket where car_id = :carId " +
            "and is_deleted = 0 " +
            "and expiry_date >= CURRENT_DATE()", nativeQuery = true)
    int[] findTicketByCarId(@Param("carId") int carId);
    /**
     * Create by: VuBD
     * Date create: 03/04/2023
     * Function: connect database to delete a ticket with corresponding id
     *
     * @param carId
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE c0922g1_car_parking.ticket SET is_deleted = 1  WHERE car_id = :carId", nativeQuery = true)
    void deleteTicketByCarId(@Param("carId") int carId);




    @Query(value = "SELECT COUNT(distinct customer.phone_number)" +
            " FROM customer " +
            " JOIN car ON customer.id = car.customer_id " +
            " JOIN ticket ON car.id = ticket.car_id" +
            " WHERE MONTH(ticket.effective_date) >=:sinceMonth AND MONTH(ticket.expiry_date) <= :toMonth " +
            "AND YEAR(ticket.effective_date) =:year and YEAR(ticket.expiry_date)= :year " +
            "AND MONTH(ticket.effective_date) = :month" , nativeQuery = true)
    Integer getTotalOfCustomer(@Param("sinceMonth") int sinceMonth,
                               @Param("toMonth") int toMonth,
                               @Param("month") int month,@Param("year") int year);

    @Query(value = "SELECT COUNT(DISTINCT customer.phone_number)" +
            "FROM car\n" +
            "JOIN customer ON car.customer_id = customer.id" +
            " JOIN ticket ON car.id = ticket.car_id" +
            " WHERE ((MONTH(ticket.effective_date) >= :sinceMonth" +
            "        AND YEAR(ticket.effective_date) = :yearStart)" +
            "       OR (MONTH(ticket.expiry_date) >= :sinceMonth" +
            "        AND YEAR(ticket.expiry_date) = :yearEnd))" +
            "  AND ((MONTH(ticket.effective_date) <= :toMonth" +
            "        AND YEAR(ticket.effective_date) = :yearStart)" +
            "       OR (MONTH(ticket.expiry_date) <= :toMonth" +
            "        AND YEAR(ticket.expiry_date) = :yearEnd)" +
            " AND MONTH(ticket.effective_date) = :month)", nativeQuery = true)
    Integer getTotalOfCustomerRange(@Param("sinceMonth") int sinceMonth,
                                    @Param("toMonth") int toMonth,
                                    @Param("month") int month,
                                    @Param("yearStart") int yearStart,
                                    @Param("yearEnd") int yearEnd);


    @Query(value = "SELECT COUNT(ticket.id) " +
            "FROM car " +
            "JOIN ticket ON car.id = ticket.car_id " +
            "WHERE ((MONTH(ticket.effective_date) >= :sinceMonth " +
            "   AND YEAR(ticket.effective_date) = :yearStart) " +
            "   OR (MONTH(ticket.expiry_date) >= :sinceMonth " +
            "   AND YEAR(ticket.expiry_date) = :yearEnd)) " +
            " AND ((MONTH(ticket.effective_date) <= :toMonth " +
            "   AND YEAR(ticket.effective_date) = :yearStart) " +
            "   OR (MONTH(ticket.expiry_date) <= :toMonth " +
            "   AND YEAR(ticket.expiry_date) = :yearEnd))" +
            " AND MONTH(ticket.effective_date) = :month", nativeQuery = true)
    Integer getTotalOfTicketRange(@Param("sinceMonth") int sinceMonth,
                                  @Param("toMonth") int toMonth,
                                  @Param("month") int month,
                                  @Param("yearStart") int yearStart,
                                  @Param("yearEnd") int yearEnd);
}

