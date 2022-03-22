package com.codegym.case_module_four.repository.customer;


import com.codegym.case_module_four.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

//    @Query(value="select * from customer where customer.name like %:name%",nativeQuery = true)
//    List<Customer> findByName(@Param("name")String name);


    @Query(value = "select * from customer where customer.name like %:name%", nativeQuery = true)
    List<Customer> findByName(@Param("name") String name);

    @Query(value = "select * from customer where customer.code like %:code%", nativeQuery = true)
    List<Customer> findByCode(@Param("code") String code);

    @Query(value = "select * from customer where customer.name  like %:name% and customer.code like %:code%", nativeQuery = true)
    List<Customer> findByNameTwo(@Param("name") String name, @Param("code") String code);
}
