package com.codegym.case_module_four.service.service;

import com.codegym.case_module_four.model.employee.Employee;
import com.codegym.case_module_four.model.service.RentalType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IRentalTypeService {

    List<RentalType> getAll();

    RentalType findById(Integer id);

    void save(RentalType rentalType);

    List<RentalType> findByName(String name);

    void remove(Integer id);

}
