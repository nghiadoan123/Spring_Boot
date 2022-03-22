package com.codegym.case_module_four.service.employee.impl;

import com.codegym.case_module_four.model.employee.Division;
import com.codegym.case_module_four.repository.employee.IDivisionRepository;
import com.codegym.case_module_four.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements IDivisionService {

    @Autowired
    IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> getAll() {
        return iDivisionRepository.findAll();
    }

    @Override
    public Division findById(Integer id) {
        return iDivisionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Division division) {
        iDivisionRepository.save(division);
    }

    @Override
    public List<Division> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iDivisionRepository.deleteById(id);
    }
}
