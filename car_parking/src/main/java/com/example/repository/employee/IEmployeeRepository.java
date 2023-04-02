package com.example.repository.employee;

import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    //
//    @Query(value = "SELECT e.id as employee_id,e.name as employee_name,e.date_of_birth as dateOfBirth,e.gender as employee_gender,e.phone_number as phoneNumber,e.id_card as idCard,e.district,e.commune,e.province,e.street,e.position_id as positionId,e.email as employeeEmail from employee e " +
//            "JOIN position p on p.id = e.position_id  " +
//            "WHERE e.id=:idEmployee",
//            nativeQuery = true)
//    Employee findById(@Param("id") Long id);
    /**
     * Created by: DinhNTC
     * Date created: 29/03/2023
     * Function: find id employee
     * @return  call to updateEmployee in employeeRepository
     */
    @Query(value = "select e.* from employee e join `position` p on p.id = e.position_id  where e.id =:id", nativeQuery = true)
    Employee findEmployeeById(@Param("id") Long id);
    /**
     * Created by: DinhNTC
     * Date created: 29/03/2023
     * Function: add  data employee   to data employee in database
     * @return
     */
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
     * @return   param data employee in location id
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
}
