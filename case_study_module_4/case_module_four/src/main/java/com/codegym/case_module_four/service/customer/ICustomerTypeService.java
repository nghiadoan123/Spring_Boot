package com.codegym.case_module_four.service.customer;

import com.codegym.case_module_four.model.customer.Customer;
import com.codegym.case_module_four.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ICustomerTypeService {

    List<CustomerType> getAll();

    CustomerType findById(Integer id);

    void save(CustomerType customerType);

    List<CustomerType> findByName(String name);

    void remove(Integer id);

}
