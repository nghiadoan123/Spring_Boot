package com.codegym.case_module_four.service.customer;

import com.codegym.case_module_four.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerService {

    List<Customer> getAll();

    Customer findById(Integer id);

    void save(Customer customer);

    List<Customer> findByName(String name);


    void remove(Integer id);

    Page<Customer> findAll(Pageable pageable);

    List<Customer> findByNameTwo(String name, String code);

    List<Customer> findByCode(String code);

}
