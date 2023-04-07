package com.example.repository;






import com.example.dto.EmployeeDTO;
import com.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     *
     * @param pageable the pageable to request a paged result, can be {@link Pageable#unpaged()}, must not be
     *                 {@literal null}.
     */
    @Query(value = "select * from employee e where e.is_deleted = false", nativeQuery = true)
    Page<Employee> findAll(Pageable pageable);

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: get the list employee and search by all field
     *
     * @param pageable
     * @param name
     * @param startDate
     * @param endDate
     * @return
     */

    @Transactional
    @Query(value = "select * from `employee` e where  lower(e.name) like lower(concat('%', :name, '%')) and e.date_of_birth >= COALESCE(NULLIF(:startDate, ''), date_of_birth)" +
            "and e.date_of_birth <= COALESCE(NULLIF(:endDate, ''), date_of_birth) " +
            "and lower(e.street) like lower(concat('%', :street, '%')) and IF(:province = 0, true, e.province = :province)and e.is_deleted = false", nativeQuery = true)
    Page<Employee> searchAll(Pageable pageable,@Param("name") String name, @Param("startDate") @DateTimeFormat(pattern = "dd-MM-yyyy")  String startDate,

                             @Param("endDate") @DateTimeFormat(pattern = "dd-MM-yyyy") String endDate, @Param("street") String street, @Param("province") int province);
    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: get a list of employees and search by all fields but the date field can only search for the start date or only the end date
     *
     * @param pageable
     * @param name
     * @param startDate
     * @param endDate
     * @return
     */
    @Transactional
    @Query(value = "select * from `c0922g1_car_parking`.`employee` e where  lower(e.name) like lower(concat('%',:name, '%')) and e.date_of_birth = COALESCE(NULLIF(:startDate, ''), date_of_birth)\n" +
            "and e.date_of_birth = COALESCE(NULLIF(:endDate, ''), date_of_birth) " +
            "and lower(e.street) like lower(concat('%', :street, '%')) and IF(:province = 0, true, e.province = :province) and e.is_deleted = false", nativeQuery = true)
    Page<Employee> searchDateOfBirth(Pageable pageable,@Param("name") String name,@Param("startDate") @DateTimeFormat(pattern = "dd-MM-yyyy")  String startDate,

                                     @Param("endDate") @DateTimeFormat(pattern = "dd-MM-yyyy") String endDate, @Param("street") String street, @Param("province") int province);


    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: delete employee by id
     *
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "delete from `employee` where id_employee = :id", nativeQuery = true)
    void deleteEmployeeById(@Param("id") Long id);

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: soft delete employee by id
     *
     * @param id
     */
    //xóa mềm
    @Modifying
    @Transactional
    @Query(value = "update employee e SET e.is_deleted = true where e.id = :id", nativeQuery = true)
    void softDeleteById(@Param("id") Long id);

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: retrieve the list of soft-deleted employees
     *
     * @param pageable
     */
    //    danh sách xóa mềm
    Page<Employee> findAllByDeletedFalse(Pageable pageable);


    /**
     * Created by: DinhNTC
     * Date created: 29/03/2023
     * Function: find id employee
     *
     * @return call to updateEmployee in employeeRepository
     */
    @Query(value = "select e.* from employee e join `position` p on p.id = e.position_id  where is_deleted = 0 and e.id =:id", nativeQuery = true)
    Employee findEmployeeById(@Param("id") Long id);

    /**
     * Created by: DinhNTC
     * Date created: 29/03/2023
     * Function: add  data employee   to data employee in database
     *
     * @return
     */

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO employee (commune, date_of_birth, district,gender,id_card,is_deleted,name,province,street,email,position_id,phone_number)" +
            "VALUES (:commune, :dateOfBirth, :district,:gender,:idCard, false ,:name,:province,:street,:email,:positionId,:phoneNumber)",
            nativeQuery = true)
    void addEmployee(@Param("commune") int commune,
                     @Param("dateOfBirth") String dateOfBirth,
                     @Param("district") int district,
                     @Param("gender") boolean gender,
                     @Param("idCard") String idCard,
                     @Param("name") String name,
                     @Param("province") int province,
                     @Param("street") String street,
                     @Param("email") String email,
                     @Param("positionId") Long positionId,
                     @Param("phoneNumber") String phoneNumber
    );

    @Transactional
    @Modifying
    @Query(value = "UPDATE employee " +
            "SET name = :name," +
            "date_of_birth = :dateOfBirth," +
            "gender = :gender," +
            "phone_number = :phoneNumber," +
            "position_id = :positionId," +
            "email = :email," +
            "id_card = :idCard," +
            "district = :district," +
            "province = :province," +
            "commune = :commune," +
            "street = :street" +
            " WHERE id = :id",
            nativeQuery = true)
    /**
     * Created by: DinhNTC
     * Date created: 29/03/2023
     * Function: add   new data employee to DB
     * @return param data employee in location id
     */
    void updateEmployee(
            @Param("name") String name,
            @Param("dateOfBirth") String dateOfBirth,
            @Param("gender") boolean gender,
            @Param("phoneNumber") String phoneNumber,
            @Param("positionId") long positionId,
            @Param("email") String email,
            @Param("idCard") String idCard,
            @Param("district") int district,
            @Param("province") int province,
            @Param("commune") int commune,
            @Param("street") String street,
            @Param("id") Long id
    );

    @Query(value = "select * from employee", nativeQuery = true)
    List<Employee> employeeList();


    @Query(value = "select employee.id as id, employee.name as name from employee " , nativeQuery = true)
    List<EmployeeDTO> getListEmployeeByName();

    /**
     * HoangNM
     */
    Employee findByEmail(String email);


}
