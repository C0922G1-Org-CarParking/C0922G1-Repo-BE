package com.example.repository.customer_car;

import com.example.dto.ICarDto;
import com.example.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * Function : connect database to information customer join car  with corresponding id of customer
     *
     * @return List<ICarDto>
     * @Param id
     */
    @Modifying
    @Query(value = "select c.name as name, c.id as id, c.id_card as idCard, c.gender as isGender, c.phone_number as phoneNumber, c.email as email, c.commune, c.district, c.province, c.street as street, car.id as carId, car.car_type_id as carTypeId, car.name as carName, car.plate_number as plateNumber from car join customer c on c.id = car.customer_id where c.id = :id and c.is_deleted = false and car.is_deleted = false ", nativeQuery = true)
    List<ICarDto> findCustomerCarById(@Param("id") Long id);

    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * Function : connect database to update customer  with corresponding id of customer
     *
     * @Param name, id_card,date_of_birth,gender,email,phone,province,district,commune,street,id)
     */
    @Modifying
    @Query(value = "UPDATE `customer` c SET c.name = :name,c.id_card = :id_card,c.date_of_birth = :date_of_birth," +
            "c.gender = :gender,c.email = :email, c.phone_number =:phone,c.province = :province," +
            "c.district = :district,c.commune = :commune, c.street=:street WHERE c.id =:id", nativeQuery = true)
    void updateCustomer(@Param("name") String name, @Param("id_card") String id_card, @Param("date_of_birth") String date_of_birth,
                        @Param("gender") boolean gender, @Param("email") String email, @Param("phone") String phone,
                        @Param("province") int province, @Param("district") int district, @Param("commune") int commune,
                        @Param("street") String street, @Param("id") Long id);

    /**
     * Create by: VuTN,
     * Date create : 29/03/2023
     * Function : connect database to find  customer with corresponding id of customer
     *
     * @Param id
     */
    @Query(value = "select * from customer where customer.id=:id", nativeQuery = true)
    Customer findCustomerById(Long id);
}
