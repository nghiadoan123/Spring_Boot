package com.codegym.case_module_four.service.employee.impl;

import com.codegym.case_module_four.model.employee.Employee;
import com.codegym.case_module_four.repository.employee.IDivisionRepository;
import com.codegym.case_module_four.repository.employee.IEmployeeRepository;
import com.codegym.case_module_four.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public List<Employee> getAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findAll(PageRequest of) {
        return iEmployeeRepository.findAll(of);
    }
}
