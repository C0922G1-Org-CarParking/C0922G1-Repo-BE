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
    @Query(value = "select * from employee", nativeQuery = true)
    Page<Employee> findAll(Pageable pageable);


    @Transactional
    @Query(value = "select * from `employee` e where lower(e.name) like lower(concat('%', :name, '%'))", nativeQuery = true)
    Page<Employee> searchByName(Pageable pageable, @Param("name") String name);


    @Transactional
    @Query(value = "select * from `employee` e where e.date_of_birth = COALESCE(NULLIF(:dateOfBirth, ''), date_of_birth)", nativeQuery = true)
    Page<Employee> searchByDateOfBirth(Pageable pageable, @Param("dateOfBirth") String dateOfBirth);


    @Transactional
    @Query(value = "select * from `employee` e where lower(e.name) like lower(concat('%', :name, '%')) and e.date_of_birth = COALESCE(NULLIF(:dateOfBirth, ''), date_of_birth)", nativeQuery = true)
    Page<Employee> searchByNameAndDateOfBirth(Pageable pageable, @Param("name") String name, @Param("dateOfBirth") String dateOfBirth);


    @Modifying
    @Transactional
    @Query(value = "delete from `employee` where id_employee = :id", nativeQuery = true)
    void deleteEmployeeById(@Param("id") Long id);

    //xóa mềm
    @Modifying
    @Transactional
    @Query(value = "update employee e SET e.is_deleted = true where e.id = :id", nativeQuery = true)
    void softDeleteById(@Param("id") Long id);

    //    danh sách xóa mềm
    Page<Employee> findAllByDeletedFalse(Pageable pageable);


}
