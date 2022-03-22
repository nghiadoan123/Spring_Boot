package com.codegym.case_module_four.service.employee.impl;

import com.codegym.case_module_four.model.employee.EducationDegree;
import com.codegym.case_module_four.repository.employee.IEducationDegreeRepository;
import com.codegym.case_module_four.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements IEducationDegreeService {

    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public List<EducationDegree> getAll() {
        return iEducationDegreeRepository.findAll();
    }

    @Override
    public EducationDegree findById(Integer id) {
        return iEducationDegreeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(EducationDegree educationDegree) {
        iEducationDegreeRepository.save(educationDegree);
    }

    @Override
    public List<EducationDegree> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iEducationDegreeRepository.deleteById(id);
    }
}
