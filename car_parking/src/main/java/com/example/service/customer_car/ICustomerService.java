package com.example.service.customer_car;

import com.example.dto.ICarDto;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ICustomerService {

    List<ICarDto> findCustomerById(Long id);
    void updateCustomer(String name,String id_card,String date_of_birth,boolean gender,String email,String phone,
                        int province,int district,int commune,String street,Long id);
}
