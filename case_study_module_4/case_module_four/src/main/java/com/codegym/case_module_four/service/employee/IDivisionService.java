package com.codegym.case_module_four.service.employee;

import com.codegym.case_module_four.model.employee.Division;
import com.codegym.case_module_four.model.employee.Employee;
import com.codegym.case_module_four.repository.employee.IDivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IDivisionService {

    List<Division> getAll();

    Division findById(Integer id);

    void save(Division division);

    List<Division> findByName(String name);

    void remove(Integer id);
}
