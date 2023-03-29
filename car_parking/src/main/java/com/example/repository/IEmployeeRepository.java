package com.example.repository;

import com.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * @param pageable the pageable to request a paged result, can be {@link Pageable#unpaged()}, must not be
     *          {@literal null}.
     */
    @Query(value = "select * from employee", nativeQuery = true)
    Page<Employee> findAll(Pageable pageable);

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: search by name
     * @param pageable
     * @param name
     */
    @Transactional
    @Query(value = "select * from `employee` e where lower(e.name) like lower(concat('%', :name, '%'))", nativeQuery = true)
    Page<Employee> searchByName(Pageable pageable, @Param("name") String name);

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: search by date of birth
     * @param pageable
     * @param dateOfBirth
     * @return
     */
    @Transactional
    @Query(value = "select * from `employee` e where e.date_of_birth = COALESCE(NULLIF(:dateOfBirth, ''), date_of_birth)", nativeQuery = true)
    Page<Employee> searchByDateOfBirth(Pageable pageable, @Param("dateOfBirth") String dateOfBirth);

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: search by name and date of birth
     * @param pageable
     * @param name
     * @param dateOfBirth
     * @return
     */
    @Transactional
    @Query(value = "select * from `employee` e where lower(e.name) like lower(concat('%', :name, '%')) and e.date_of_birth = COALESCE(NULLIF(:dateOfBirth, ''), date_of_birth)", nativeQuery = true)
    Page<Employee> searchByNameAndDateOfBirth(Pageable pageable, @Param("name") String name, @Param("dateOfBirth") String dateOfBirth);

    /**
     * Created by: TaiLH
     * Date created: 29/03/2022
     * function: delete employee by id
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
     * @param pageable
     */
    //    danh sách xóa mềm
    Page<Employee> findAllByDeletedFalse(Pageable pageable);


}
