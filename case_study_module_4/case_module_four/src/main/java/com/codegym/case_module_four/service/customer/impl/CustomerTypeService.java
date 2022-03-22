package com.codegym.case_module_four.service.customer.impl;

import com.codegym.case_module_four.model.customer.Customer;
import com.codegym.case_module_four.model.customer.CustomerType;
import com.codegym.case_module_four.repository.customer.ICustomerTypeRepository;
import com.codegym.case_module_four.service.customer.ICustomerService;
import com.codegym.case_module_four.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> getAll() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(Integer id) {
        return iCustomerTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(CustomerType customerType) {
        iCustomerTypeRepository.save(customerType);
    }

    @Override
    public List<CustomerType> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iCustomerTypeRepository.deleteById(id);
    }

}
